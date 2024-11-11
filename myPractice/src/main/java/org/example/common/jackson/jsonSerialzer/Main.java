package org.example.common.jackson.jsonSerialzer;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/28 22:02:03
 * @Version: 1.0.0
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // 创建对象
        Person person = new Person();
        person.setPersonId(1);
        person.setName("张三");
        person.setEnabled(true);

        // 将PersonSerializer对象序列化为json字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(person);
        System.out.println(jsonStr);
    }
}
