package org.example.common.jackson.baseuse;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.common.jackson.jsonSerialzer.Person;

import java.io.IOException;

/**
 * jackson的基础使用:
 *      1 ObjectMapper
 *      2 ...
 *
 * @author jiayn01
 * @date 2023-11-23 13:55:13
 */
public class Main {
    public static void main(String[] args) {
        // 1 创建对象
        Person person = new Person();
        person.setPersonId(1);
        person.setName("张三");
        person.setEnabled(true);

        // 2 测试转字符串
        String s = writeValue(person);
        System.out.println(s);

        // 3 测试转对象
        Person person1 = readValue(s, Person.class);
        System.out.println(person1.toString());
    }

    /**
     * 使用objectMapper.writeValueAsString将对象序列化为json字符串
     *
     * @param object
     * @return
     */
    public static String writeValue(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = null;
        try {
            jsonStr = objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    /**
     * 使用objectMapper.readValue方法将json串转换为对象
     *
     * @param jsonStr
     * @param clzz
     * @param <T>
     * @return
     */
    public static <T> T readValue(String jsonStr, Class<T> clzz) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        T object = null;
        try {
             object = objectMapper.readValue(jsonStr, clzz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }
}
