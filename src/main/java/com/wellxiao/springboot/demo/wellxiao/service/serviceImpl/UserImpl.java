package com.wellxiao.springboot.demo.wellxiao.service.serviceImpl;

import com.wellxiao.springboot.demo.wellxiao.entity.Users;

import java.util.List;

public interface UserImpl {
    public Users select(int id);
    public int insert(Users user);
    public void delete(int id);
    public int getTotalCount();
    public List<Users> selectAll(int currentPage,int pageSize);
}

