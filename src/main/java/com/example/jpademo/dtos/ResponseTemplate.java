package com.example.jpademo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseTemplate {
    private int status;
    private String message;
    private Object data;
}
