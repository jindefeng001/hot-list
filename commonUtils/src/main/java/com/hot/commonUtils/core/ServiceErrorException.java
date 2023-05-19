package com.hot.commonUtils.core;

import org.springframework.http.HttpStatus;

/**
 * @author jin
 * @date 2023/5/15
 */
public class ServiceErrorException extends RuntimeException {
    
    /**
     * 返回给前端的错误数据
     */
    private Object data;

    /**
     * 返回给前端的错误码
     */
    private HttpStatus status;

    /**
     *  错误信息构造服务异常
     * @param message 错误信息标识
     */
    public ServiceErrorException(String message){
        super(message);
        this.status = HttpStatus.NOT_ACCEPTABLE;
    }

    /**
     * 错误信息及错误数据构造服务异常
     * @param message 错误信息标识
     * @param data 错误数据
     */
    public ServiceErrorException(String message, Object data){
        super(message);
        this.data = data;
        this.status = HttpStatus.NOT_ACCEPTABLE;
    }

    /**
     * 错误信息、错误数据、错误状态码构造服务异常
     * @param message 错误信息标识
     * @param data 错误数据
     * @param status 错误状态码
     */
    public ServiceErrorException(String message, Object data, HttpStatus status){
        super(message);
        this.data = data;
        this.status = status;
    }

    /**
     * 错误信息、错误状态码构造服务异常
     * @param message 错误信息标识
     * @param status 错误状态码
     */
    public ServiceErrorException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
