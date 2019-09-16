package com.wellxiao.springboot.demo.wellxiao.common;

import lombok.Data;

@Data //  这个注解可以省略 get set 方法
public class Response<T> {
    private Integer error_code;
    private String err_msg;
    private T data;

    public Response(){
    }

    public Response(Integer error_code,String err_msg,T data){
        this.error_code = error_code;
        this.err_msg = err_msg;
        this.data = data;
    }
}