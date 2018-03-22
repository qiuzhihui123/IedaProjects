package com.qiuhui.mapper;

import com.qiuhui.entity.Student;
/**
 *@Description:Student的mapper接口
 *@Author: 邱志辉
 *@Date 2018/3/21 0021下午 10:50
 */
public interface StudentMapper {

    /** 
     *描述:接收一个id返回一个Student对象
     *@参数:[id]查询相应id的学生
     *@返回值：com.qiuhui.entity.Student类的对象
     */
    Student findStudentById(Integer id);
    
    /** 
     *描述:向数据库插入一条student数据
     *@参数:[]
     *@返回值void
     */
    void insertStudent();
}
