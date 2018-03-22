package com.qiuhui.test;

import com.qiuhui.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class MyBatisTest {

    public static void main(String[] args) throws IOException{

        Reader reader = Resources.getResourceAsReader("MyBatis.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(reader);

        SqlSession sqlSession = factory.openSession();

        Student student = sqlSession.selectOne("com.qiuhui.mapper.StudentMapper.findStudentById",1);
        System.out.println(student);
        sqlSession.close();
    }

   /* @Test
    public void Test( ){
        List<String > strs = new ArrayList<>();
        strs.add("11");
        strs.add("22");
        strs.add("33");

        Object[] res =  strs.toArray();
        for(Object str : res){
            System.out.println(str);
        }

    }*/
}
