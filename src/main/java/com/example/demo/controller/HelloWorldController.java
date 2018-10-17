package com.example.demo.controller;

import com.example.demo.Dao.UserDao;
import com.example.demo.Entity.User;
import com.example.demo.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 1 on 2018/9/19.
 */
@RestController
public class HelloWorldController {

    @Autowired
    UserDao userDao;

    @Autowired
    RedisUtils redisUtils;

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);


    @RequestMapping("/getUser")
    public String getUser() {
        List<User> list=userDao.getUser();
        System.out.println(list);
        return list.toString();
    }

    @RequestMapping("/addUser")
    public String addUser(String username,String password) {
        User user=new User(username,password);
        userDao.addUser(user);
        return "增加成功";
    }

    @RequestMapping("/findUser")
    @Cacheable(value="thisredis", key="'users_'+#id")
    public User findUser(Integer id) {
        User user = new User();
        user.setUserName("hlhdidi");
        user.setPassWord("123");
        user.setId(id);
        System.out.println("log4j2坏啦?");
        logger.info("输入user,用户名:{},密码:{}",user.getUserName(),user.getPassWord());
        return user;
    }

    @CacheEvict(value="thisredis", key="'users_'+#id",condition="#id!=1")
    public void delUser(Integer id) {
        // 删除user
        System.out.println("user删除");
    }

    @RequestMapping("/getOneUser")
    public User getOneUser() {
        System.out.println(redisUtils.get("users"));
        logger.info("输入user,用户名:{},密码:{},id:{}", ((User)redisUtils.get("users")).getUserName(),((User)redisUtils.get("users")).getPassWord()
        ,((User)redisUtils.get("users")).getId());
        return (User) redisUtils.get("users");
    }

    @RequestMapping("/insertUser")
    public String insertUser() {
        User user=new User();
        user.setId(5);
        user.setUserName("zahngfwenjun");
        user.setPassWord("123456");
        logger.info("输入user,用户名:{},密码:{}", redisUtils.set("users",user));
        return "增加成功";
    }
}