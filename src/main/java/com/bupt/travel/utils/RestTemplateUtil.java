package com.bupt.travel.utils;

import com.bupt.travel.contant.IMContants;
import com.bupt.travel.model.IM.TokenInterface;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.print.attribute.standard.Media;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RestTemplateUtil {

    private static final Logger logger = LoggerFactory.getLogger(RestTemplateUtil.class);

    @Autowired
    protected  RestTemplate restTemplate;

    /**
     * 将url参数转换成map
     *
     * @param param aa=11&bb=22&cc=33
     * @return
     */
    public  Map<String, Object> getUrlParams(String param) {
        Map<String, Object> map = new HashMap<>(0);
        if (StringUtils.isEmpty(param)) {
            return map;
        }
        String[] params = param.split("&");
        for (int i = 0; i < params.length; i++) {
            String[] p = params[i].split("=");
            if (p.length == 2) {
                map.put(p[0], p[1]);
            }
        }
        return map;
    }

    /**
     * 将map转换成url
     *
     * @param map
     * @return
     */
    public  String getUrlParamsByMap(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            sb.append(entry.getKey())
                    .append("=")
                    .append(entry.getValue())
                    .append("&");
        }
        String s = sb.toString();
        if (s.endsWith("&")) {
            s = s.substring(0,s.length()-1);
        }
        return s;
    }

    public  String doGet(String url, Map<String, Object> param, Map<String, Object> header) {

        if (param == null) {
            param = new HashMap<>();
        }

        //参数转成查询参数
        if (param.size() > 0) {
            url = url + "?" + getUrlParamsByMap(param);
        }

        //设置header请求参数
        HttpHeaders httpHeaders = getHttpHeaders(header, null, "application/json; charset=UTF-8", "application/json; charset=UTF-8");

        HttpEntity<Object> httpEntity = new HttpEntity<>(httpHeaders);

        try {
            return restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class).getBody();
        } catch (Exception e) {
            logger.error("REST_REQUEST_ERROR " + url + " GET param=" + param.toString() + " header=" + (header != null ? header.toString() : "{}") + " " + e.getMessage(),e);
        }

        return "";
    }

    public  String doPost(String url, Map<String, Object> param, Map<String, Object> header) {
        //设置header
        HttpHeaders httpHeaders = getHttpHeaders(header, null, "application/json; charset=UTF-8", "application/json; charset=UTF-8");

        HttpEntity<String> httpEntity = new HttpEntity<>(JacksonUtil.writeValueAsString(param), httpHeaders);

        try {
            return restTemplate.postForEntity(url, httpEntity, String.class).getBody();
        } catch (Exception e) {
            logger.error("REST_REQUEST_ERROR " + url + " POST param=" + (param != null ? param.toString() : "{}") + " header=" + (header != null ? header.toString() : "{}") + " " + e.getMessage(),e);
        }
        return "";
    }

    //Post请求需要带有token信息
    public String doPostWithToken(String url, Map<String, Object> param, Map<String, Object> header) {
        int retry = 0;
        while (true){
            retry ++ ;
            //设置header中的token信息
            if(header == null){
                header = new HashMap<>();
            }
            header.put("Authorization","Bearer "+IMContants.HUAN_XING_TOKEN);

            HttpHeaders httpHeaders = getHttpHeaders(header, null, "application/json; charset=UTF-8", "application/json; charset=UTF-8");
            String requestParam = JacksonUtil.writeValueAsString(param);
            HttpEntity<String> httpEntity = new HttpEntity<>(requestParam, httpHeaders);

            try {
                return restTemplate.postForEntity(url, httpEntity, String.class).getBody();
            } catch (HttpClientErrorException e) {
                if(e.getRawStatusCode()==401){
                    //尝试两次获取token
                    if(retry == 2){
                        throw  e;
                    }
                    //token未授权，token过期,重新获取token
                    String token = getToken();
                    IMContants.HUAN_XING_TOKEN = token;
                    System.out.println("token="+IMContants.HUAN_XING_TOKEN);
                }else{
                    throw  e;
                }
            }
        }
    }

    /**
     *  上传图片信息到环信
     */
    public String doPostWithImage(String url, String fileLocal){
        FileSystemResource resource = new FileSystemResource(new File(fileLocal));
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("file", resource);

        //设置header请求参数
        HttpHeaders httpHeaders = new HttpHeaders();
        //设置传输内容的格式
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
        httpHeaders.add("Accept", "application/json; charset=UTF-8");
       //设置授权信息
        httpHeaders.add("restrict-access", "true");

        int retry = 0 ;
        while (true){
            try {
                httpHeaders.add("Authorization", "Bearer "+IMContants.HUAN_XING_TOKEN);
                HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(param, httpHeaders);
                ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
                return  responseEntity.getBody();
            }catch (HttpClientErrorException e ){
                if(e.getRawStatusCode()==401){
                    //尝试两次获取token
                    retry ++;
                    if(retry == 2){
                        throw  e;
                    }
                    //token未授权，token过期,重新获取token
                    String token = getToken();
                    IMContants.HUAN_XING_TOKEN = token;
                }else{
                    throw  e;
                }
            }
        }
    }

    /**
     * 设置http header
     *
     * @param header
     * @param request
     * @param contentType
     * @param acceptType
     * @return
     */
    private  HttpHeaders getHttpHeaders(Map<String, Object> header, HttpServletRequest request, String contentType, String acceptType) {
        //设置header请求参数
        HttpHeaders httpHeaders = new HttpHeaders();

        //设置请求类型以及返回类型
        MediaType type = MediaType.parseMediaType(contentType);
        httpHeaders.setContentType(type);
        httpHeaders.add("Accept", acceptType);
       /* List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.ALL);
        httpHeaders.setAccept(acceptableMediaTypes);*/


        if (header != null && header.size() > 0) {
            for (Map.Entry<String, Object> entry : header.entrySet()) {
                httpHeaders.set(entry.getKey(), entry.getValue().toString());
            }
        }
        return httpHeaders;
    }

    //获取token信息
    public  String getToken(){
        Map<String, Object> param = new HashMap<>();
        param.put("grant_type", "client_credentials");
        param.put("client_id", IMContants.client_id);
        param.put("client_secret", IMContants.client_secret);
        String token = TokenInterface.decode(this.doPost("https://a1.easemob.com/1148180614146538/travel/token", param, null));
        return  token;
    }
}

