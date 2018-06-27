package com.bupt.travel.Config;


import com.sun.org.apache.bcel.internal.generic.FADD;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

@Configuration
public class HttpConfig {

    @Bean
    public RestTemplate restTemplate()throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        return new RestTemplate(clientHttpRequestFactory());
    }

    private ClientHttpRequestFactory clientHttpRequestFactory() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {

      /*  //配置Https连接
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy)
                .build();

        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .build();
*/

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();

     /*   factory.setHttpClient(httpClient);*/
        //读取时间
        factory.setReadTimeout(6000);
        //连接时间
        factory.setConnectionRequestTimeout(6000);
        return  factory;
    }
}
