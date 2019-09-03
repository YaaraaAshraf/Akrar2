package com.example.akrar.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResObj<T> {

    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private T data;

    @SerializedName("error")
    private T error;

    @SerializedName("errors")
    private T errors;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getError() {
        return error;
    }

    public void setError(T error) {
        this.error = error;
    }

    public T getErrors() {
        return errors;
    }

    public void setErrors(T errors) {
        this.errors = errors;
    }
}

