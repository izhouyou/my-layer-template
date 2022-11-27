package com.youzi.layer.common.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * title JacksonUtil
 * Description Jackson使用工具类
 * CreateDate 2022/3/10 10:44
 *
 * @author izhouy
 */
@Slf4j
public class JacksonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * json字符串转为java对象
     *
     * @param str
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T parseObject(String str, Class<T> clazz) {
        if (StringUtils.isEmpty(str) || clazz == null) {
            return null;
        }
        try {
            return clazz.equals(String.class) ? (T) str : objectMapper.readValue(str, clazz);
        } catch (Exception e) {
            log.error("方法[JacksonUtils-parseObject]，异常信息：", e);
            return null;
        }
    }

    /**
     * java对象转为json字符串
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String toJsonString(T obj) {
        if (obj == null) {
            return null;
        }
        try {
            return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            log.error("方法[JacksonUtils-toJsonString]，异常信息：", e);
            return null;
        }
    }

    /**
     * 字符串转JsonNode
     *
     * @param jsonStr
     * @return
     */
    public static JsonNode parseJson(String jsonStr) {
        if (StringUtils.isEmpty(jsonStr)) {
            return null;
        }
        try {
            return objectMapper.readTree(jsonStr);
        } catch (Exception e) {
            log.error("方法[JacksonUtils-parseJson]，异常信息：", e);
            return null;
        }
    }


}
