package com.wellxiao.springboot.demo.wellxiao.dao;

import com.wellxiao.springboot.demo.wellxiao.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    public Users select(int id);
    public int insertUser(Users user);
    public void deleteUser(int id);
    public int getTotalCount();
    public List<Users> selectPagination(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);
}
