package com.lening.result;

import java.io.Serializable;

/**
 * 创作时间：2020/1/14 9:36
 * 作者：李增强
 */
public class Result implements Serializable {

    private boolean success;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result() {
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
