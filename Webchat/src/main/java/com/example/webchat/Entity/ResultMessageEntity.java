package com.example.webchat.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ResultMessageEntity<T> {
    boolean IsOk;

    int MegType;

    T Body;
}
