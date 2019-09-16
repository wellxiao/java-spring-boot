package com.wellxiao.springboot.demo.wellxiao.controller;

import com.wellxiao.springboot.demo.wellxiao.common.ErrorCode;
import com.wellxiao.springboot.demo.wellxiao.common.Response;
import com.wellxiao.springboot.demo.wellxiao.entity.PageBean;
import com.wellxiao.springboot.demo.wellxiao.entity.Users;
import com.wellxiao.springboot.demo.wellxiao.service.UserService;
import com.wellxiao.springboot.demo.wellxiao.service.serviceImpl.UserImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
public class HelloController {
    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello my first spring boot!";
    }

    @RequestMapping(value="/user/{id}", method = RequestMethod.GET)
    public Response select(@PathVariable("id") int id){
        Users user = userService.select(id);
//        if(StringUtils.isEmpty(user)) return user;
        log.debug("根据用户ID查询用户信息");
        return new Response(ErrorCode.SUCCESS.code,ErrorCode.SUCCESS.message,user);
    }

    @RequestMapping(value="/create/user", method = RequestMethod.POST)
    public  Response insertUser(@RequestBody() Users user){
        System.out.println(user.getName());
        log.debug("创建一个新用户");
        userService.insert(user);
        System.out.println(user.getId());
        int id = user.getId();
        return new  Response(ErrorCode.SUCCESS.code,ErrorCode.SUCCESS.message,id);
    }

    @RequestMapping(value="/delete/user/{id}", method = RequestMethod.DELETE)
    public  Response deleteUser(@PathVariable("id") int id){
        log.debug("删除用户"+id);
        userService.delete(id);
        return new  Response(ErrorCode.SUCCESS.code,ErrorCode.SUCCESS.message,null);
    }

    @RequestMapping(value = "/user/list",method = RequestMethod.GET )
    public Response getUserList(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize ){
        System.out.println(currentPage);
        System.out.println(pageSize);

        int count = userService.getTotalCount();
        List<Users> list = userService.selectAll(currentPage,pageSize);
        PageBean<Users> map = new PageBean(currentPage,pageSize,count,list);
//        JSONObject map = new JSONObject();
//        map.put("list",list);
//        map.put("count",count);
        return new  Response(ErrorCode.SUCCESS.code,ErrorCode.SUCCESS.message,map);
    }
}
