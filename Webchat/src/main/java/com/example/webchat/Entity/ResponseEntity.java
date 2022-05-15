package com.example.webchat.Entity;

import lombok.Data;

import java.util.Map;

/**
 * 响应的统一格式
 */
@Data
public class ResponseEntity<T> {
    int statue;

    boolean isSuccess;
    public T Bodys;


}
