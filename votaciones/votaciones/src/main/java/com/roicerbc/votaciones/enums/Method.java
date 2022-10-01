package com.roicerbc.votaciones.enums;

public enum Method {

    GET("GET"), POST("POST"),PUT("PUT"), DELETE("DELETE");
    private final String text;

    Method(String text) {
        this.text = text;
    }
}
