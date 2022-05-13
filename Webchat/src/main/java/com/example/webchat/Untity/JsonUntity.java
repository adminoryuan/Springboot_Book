package com.example.webchat.Untity;

import com.fasterxml.jackson.core.JsonProcessingException;
import  com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JsonUntity {

    private ObjectMapper wrap=new ObjectMapper();

    /**
     * 序列化
     * @param data
     * @param <T>
     * @return
     * @throws JsonProcessingException
     */
    public <T>String Serialize(T data) throws JsonProcessingException {
        return wrap.writeValueAsString(data);
    }

    /**
     * 反序列化
     * @param token
     * @param Data
     * @param <T>
     * @return
     * @throws IOException
     */
    public <T> T Squence(String token,Class Data) throws IOException {
        T o = (T) wrap.readValue(token, Data);
        return o;
    }
}
