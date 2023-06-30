package com.cliff.jigsaw.common.upload;

import lombok.Data;

@Data
public class ResponseForm {

    private String msg;
    private boolean success;
    private Object data;

    public ResponseForm setError(String msg) {
        this.msg = msg;
        this.success = false;
        return this;
    }

    public ResponseForm setSuccess(String msg) {
        this.msg = msg;
        this.success = true;
        return this;
    }

}
