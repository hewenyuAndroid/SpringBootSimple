package com.example.springbootssmp.controller.utils;

import lombok.Data;

@Data
public class R {

    private Boolean statusCode;
    private String statusMsg;
    private Object data;

    public R(Boolean statusCode) {
        this.statusCode = statusCode;
    }

    public R(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public R(Boolean statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }

    public R(Boolean statusCode, Object data) {
        this.statusCode = statusCode;
        this.data = data;
    }

}
