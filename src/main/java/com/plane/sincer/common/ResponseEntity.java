package com.plane.sincer.common;

import lombok.Data;

@Data
public class ResponseEntity<T> {

    private String code;
    private String message;
    private T body;

}
