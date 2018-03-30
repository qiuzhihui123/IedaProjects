package com.qiuhui.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoTestCase {


    @Test
    public void create(){
     // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        ClassPathXmlApplicationContext applicationContext =  new ClassPathXmlApplicationContext("applicationContext.xml");




        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        applicationContext.close();



    }



}
