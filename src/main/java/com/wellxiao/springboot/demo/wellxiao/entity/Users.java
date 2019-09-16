package com.wellxiao.springboot.demo.wellxiao.entity;



import lombok.Data;

import java.util.Date;

//@EntityListeners(AuditingEntityListener.class)
@Data
public class Users {
    private int id;
    private String password;
    private String name;
    private int age;
    private  int sex;

    //@CreatedDate
    private Date addTime;

}

