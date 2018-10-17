package com.example.demo.controller;

import java.io.*;
import java.util.Properties;

/**
 * Created by 1 on 2018/10/12.
 */
interface fruit{
    public abstract void eat();
}
class Apple implements fruit{
    public void eat(){
        System.out.println("Apple");
    }
}
class Orange implements fruit{
    public void eat(){
        System.out.println("Orange");
    }
}


//操作属性文件类
class init {
    public static Properties getPro() throws FileNotFoundException, IOException {
        Properties pro = new Properties();
        File f = new File("com.example.demo.controller.Apple");
        if (f.exists()) {
            pro.setProperty("apple", "com.example.demo.controller.Apple");
            pro.setProperty("orange", "com.example.demo.controller.Orange");
            pro.store(new FileOutputStream(f), "FRUIT CLASS");
            System.out.println(new FileOutputStream(f));
        } else {
            pro.setProperty("apple", "com.example.demo.controller.Apple");
            pro.setProperty("orange", "com.example.demo.controller.Orange");
            pro.store(new FileOutputStream(f), "FRUIT CLASS");
        }
        return pro;
    }
}

//构造工厂类
//也就是说以后如果我们在添加其他的实例的时候只需要修改工厂类就行了
class Factory{
    public static fruit getInstance(String ClassName){
        fruit f=null;
        try{
            f=(fruit)Class.forName(ClassName).newInstance();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
class test{
    public static void main(String[] a) throws FileNotFoundException, IOException{
       /* fruit f=Factory.getInstance("com.example.demo.controller.Apple");
        if(f!=null){
            f.eat();
        }*/
        Properties pro=init.getPro();
        fruit f=Factory.getInstance(pro.getProperty("apple"));
        if(f!=null){
            f.eat();
        }
    }
}

