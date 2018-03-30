package com.qiuhui.dao;

public class UserDao {


    public void init(){

        System.out.println("UserDao初始化");

    }


    public UserDao(){
        System.out.println("UserDao被创建了");
    }


    public void destroy(){

        System.out.println("userDao销毁");
    }


}
