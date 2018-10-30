package com.example.demo.Beans;

import java.util.Observer;

/**
 * Created by 1 on 2018/10/23.
 */
public class Test {
    public static void main(String[] args) {
        WechatServer server = new WechatServer();

        Obser userZhang = new User("ZhangSan");
        Obser userLi = new User("LiSi");
        Obser userWang = new User("WangWu");

        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);
        server.setInfomation("PHP是世界上最好用的语言！");

        System.out.println("----------------------------------------------");
        server.removeObserver(userZhang);
        server.setInfomation("JAVA是世界上最好用的语言！");

    }
}
