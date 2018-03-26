package com.qiuhui;

import com.qiuhui.entity.Movie;
import com.qiuhui.entity.Student;
import com.qiuhui.mapper.MovieMapper;
import com.qiuhui.mapper.StudentMapper;
import com.qiuhui.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AnnotationsTest {


    private SqlSession sqlSession;
    private MovieMapper movieMapper;
    private StudentMapper stuMapper;







    @Before
    public void init(){
        sqlSession = SqlSessionUtil.getSqlSession(true);
        movieMapper = sqlSession.getMapper(MovieMapper.class);
        stuMapper = sqlSession.getMapper(StudentMapper.class);
    }

    @Test
    public void findStudentSchoolAndTags(){

        Student student = stuMapper.findStudentSchoolAndTagsById(1);
        System.out.println(student);
    }




    @Test
    public void findMovieBYId(){
        Movie movie = movieMapper.fingMovieById(111);
        System.out.println(movie);
    }

    @Test
    public void updata(){
        Movie mov = movieMapper.fingMovieById(777);
        System.out.println(mov);
        mov .setTitle("爱与诚");

        movieMapper.update(mov);
        System.out.println(mov);

    }

    @Test
    public void add(){
        Movie movie = new Movie();
        movie.setTitle("哈哈哈哈哈啊");
        movieMapper.add(movie);
    }

    @Test
    public void delete(){
        movieMapper.deleteById(777);
    }



    @After
    public void close(){

        sqlSession.close();
    }

}
