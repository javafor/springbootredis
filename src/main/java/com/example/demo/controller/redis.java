package com.example.demo.controller;

import redis.clients.jedis.Jedis;

/**
 * Created by 1 on 2018/10/30.
 */
public class redis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.1.180",6379);
        System.out.println("连接成功");
       // jedis.set("runoobkey", "www.runoob.com");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis);
    }
}
