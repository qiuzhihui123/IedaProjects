package com.qiuhui.mapper;

import com.qiuhui.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentMapper {


    Student findStudentById(Integer id);
    void update(Student student);
    List<Student> findAll();
    void insertStudent(Student student);
    void delete(Integer id);
    List<Student> page1(int start,int size);
    List<Student> page2(Map<String,Integer> map);
    List<Student> page3(@Param("start")int start, @Param("size")int size);
    List<Student> findStudentBySchoolId(int schoolId);
    Student findStudentWithTags(int studentId);
}
