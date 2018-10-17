package com.example.demo.Dao;

/**
 * Created by 1 on 2018/10/15.
 */
public interface Formula {
    double calculate(int a);


     default  double sqrt(int a) {
        return Math.sqrt(a);
    }
}
