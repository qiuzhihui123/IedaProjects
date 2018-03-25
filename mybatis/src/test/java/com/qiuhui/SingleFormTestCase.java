package com.qiuhui;

import com.qiuhui.entity.Student;

import com.qiuhui.entity.Tag;
import com.qiuhui.mapper.StudentSchoolSingleFormMapper;
import com.qiuhui.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SingleFormTestCase {

    private SqlSession sqlSession;
    private StudentSchoolSingleFormMapper mapper;

    @Before
    public void init(){
        sqlSession = SqlSessionUtil.getSqlSession(true);
        mapper = sqlSession.getMapper(StudentSchoolSingleFormMapper.class);
    }

    @Test
    public void findStudentSchool(){

        Student student = mapper.findStudentSchoolById(1);
        System.out.println(student);
    }

    @Test
    public void findStudentWithTags(){

        Student student = mapper.findStudentWithTags(1);
        System.out.println(student);
        for(Tag tag : student.getTagList()){
            System.out.println(tag);
        }
    }

    @After
    public void close(){
        sqlSession.close();
    }
}
