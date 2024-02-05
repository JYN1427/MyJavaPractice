package org.example.common.jackson.jsonSerialzer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/28 22:01:34
 * @Version: 1.0.0
 */
public class Serializers{
    public static class OptimizedBooleanSerializer extends JsonSerializer<Boolean> {
        /**
         * 自定义序列化逻辑
         * 有各种writeXXXX...()
         *
         * @param value
         * @param jsonGenerator
         * @param serializerProvider
         * @throws IOException
         * @throws JsonProcessingException
         */
        @Override
        public void serialize(Boolean value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
            // 将false序列化为0，将true序列化为0
            if(value){
                jsonGenerator.writeNumber(1);
            } else {
                jsonGenerator.writeNumber(0);
            }
        }
    }

}


