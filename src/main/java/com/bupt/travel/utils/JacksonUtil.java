package com.bupt.travel.utils;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class JacksonUtil {
    private static final Logger logger = LoggerFactory.getLogger(JacksonUtil.class);
    // DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES可避免接收对象缺少对应字段时抛异常
    private static ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


    public static <T> T readValue(String content, Class<T> valueType) {
        T res = null;
        try {
            if (!StringUtils.isEmpty(content)) {
                res = objectMapper.readValue(content, valueType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    //字符串反序列化成自定义类
    public static <T> T readValue(String content, TypeReference valueTypeRef) {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        T res = null;
        try {
            if (content != null && !content.equals("")) {
                res = mapper.readValue(content, valueTypeRef);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    //反序列化成JsonNode
    public static JsonNode readTree(String content) {
        JsonNode node = null;
        try {
            if (!StringUtils.isEmpty(content)) {
                node = objectMapper.readTree(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return node;
    }

    public static String writeValueAsString(Object value) {
        String json = "";
        try {
            json = objectMapper.writeValueAsString(value);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    //解析接口数组,判断data是否正常,true表示正常,false为不正常(data为空或空Map、空数组)
    public static Boolean checkResData(String res) {
        JsonNode jsonNode = JacksonUtil.readTree(res);
        if (jsonNode == null) {//返回data为空
            return false;
        } else {
            JsonNode data = jsonNode.get("data");
            return !(data == null || data.isNull() || (data.isTextual() && data.toString().equals("\"\"")) || (data.isContainerNode() && data.size() == 0));
        }
    }

}
