package com.qiuhui.entity;

import java.io.Serializable;
import java.util.List;

/**
 *@Description:Student实体类
 *@Author: 邱志辉
 *@Date 2018/3/21 0021下午 10:57
 */
public class Student implements Serializable{

    private static final long servialVersionUID =1L;
    private int id;
    private  String studentName;
    private  String email;
    private  int age;

    private School school;
    private List<Tag> tagList;

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + studentName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
