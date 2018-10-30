package com.example.demo.Beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * Created by 1 on 2018/10/23.
 */
public class WechatServer implements Observerable {
    //注意到这个List集合的泛型参数为Observer接口，设计原则：面向接口编程而不是面向实现编程
    private List<Obser> list;
    private String message;

    public WechatServer() {
        list = new ArrayList<Obser>();
    }


    @Override
    public void registerObserver(Obser o) {

        list.add(o);
    }

    @Override
    public void removeObserver(Obser o) {
        if(!list.isEmpty())
            list.remove(o);
    }

    //遍历
    @Override
    public void notifyObserver() {
        for(int i = 0; i < list.size(); i++) {
            Obser oserver = list.get(i);
            oserver.update(message);
        }
    }

    public void setInfomation(String s) {
        this.message = s;
        System.out.println("微信服务更新消息： " + s);
        //消息更新，通知所有观察者
        notifyObserver();
    }
}
