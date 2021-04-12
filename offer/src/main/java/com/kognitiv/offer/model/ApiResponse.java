package com.kognitiv.offer.model;

import org.springframework.http.HttpStatus;

public class ApiResponse {

    private int status;
    private Object data;

    public ApiResponse() {
        super();
    }

    public ApiResponse(HttpStatus status, Object data) {
        super();
        this.status = status.value();
        this.data = data;
    }

    public ApiResponse(Integer status, Object data) {
        super();
        this.status = status;
        this.data = data;
    }

    public ApiResponse(HttpStatus status) {
        super();
        this.status = status.value();

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "status=" + status +
                ", message='" +  '\'' +
                ", data=" + data +
                '}';
    }

}
