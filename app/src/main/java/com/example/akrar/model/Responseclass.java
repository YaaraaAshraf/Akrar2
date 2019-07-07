package com.example.akrar.model;

public class Responseclass {
    private String status, error, data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Responseclass(String status, String error, String data) {
        this.status = status;
        this.error = error;
        this.data = data;

    }
}
