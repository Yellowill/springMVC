package com.allianz.pa.common.util;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    /**
     * json转换成类
     * @param json
     * @return
     * @throws IOException
     * @throws JsonParseException
     * @throws JsonMappingException
     */
    public static <T> T toObject(String json, Class<T> clazz) throws IOException, JsonParseException,
                                                                     JsonMappingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyyMMddHHmmss"));
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);//兼容pojo增加字段的版本升级
        T object = mapper.readValue(json, clazz);
        Beans.beanValidate(object);
        return object;
    }

    /**
     * 类转换成json
     * @param obj
     * @return
     * @throws IOException
     * @throws JsonGenerationException
     * @throws JsonMappingException
     */
    public static String toJson(Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyyMMddHHmmss"));
        mapper.setSerializationInclusion(Include.NON_NULL);
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, obj);
        return writer.toString();
    }
}
