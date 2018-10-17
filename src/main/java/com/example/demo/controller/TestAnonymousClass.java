package com.example.demo.controller;

/**
 * Created by 1 on 2018/9/29.
 */
public class TestAnonymousClass {
    public static void main(String[] args) {
        TestAnonymousClass testAnonymousClass=new TestAnonymousClass();
        testAnonymousClass.show();
    }
     private void show(){
        Out anony=new Out()
        { // 获取匿名内部类实例
            void show(){ //重写父类的方法
            System.out.println("this is Anonymous InterClass showing.");
            }
        };
    anony.show();// 调用其方法
    }
}
class Out{
    void show(){
        System.out.println("this is out showing");
    }
}
