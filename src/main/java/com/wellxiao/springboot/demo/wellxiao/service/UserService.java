package com.wellxiao.springboot.demo.wellxiao.service;

import com.wellxiao.springboot.demo.wellxiao.dao.UserDao;
import com.wellxiao.springboot.demo.wellxiao.entity.Users;
import com.wellxiao.springboot.demo.wellxiao.service.serviceImpl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserImpl {
    @Autowired
    private UserDao userDao;

    @Transactional
    public Users select(int id){
        Users user = userDao.select(id);
        return user;
    }
    @Transactional
    public int insert(Users user){
        return userDao.insertUser(user);
    }

    @Transactional
    public void delete(int id){
        userDao.deleteUser(id);
    }

    @Transactional
    public List<Users> selectAll(int currentPage, int pageSize){
        List<Users> list = new ArrayList<>();
        list = userDao.selectPagination(currentPage,pageSize);
        return list;
    }
    @Transactional
    public int getTotalCount(){
        int count = userDao.getTotalCount();
        return count;
    }
}