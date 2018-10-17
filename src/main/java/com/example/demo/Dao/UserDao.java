package com.example.demo.Dao;

import com.example.demo.Entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 1 on 2018/9/20.
 */
@Component
public interface UserDao {
    List<User> getUser();

    int addUser(User user);
}
