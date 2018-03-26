package com.qiuhui.test;

import com.qiuhui.entity.Movie;
import com.qiuhui.entity.MovieExample;
import com.qiuhui.mapper.MovieMapper;
import com.qiuhui.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class Mybatis3TestCase {

    private SqlSession sqlSession;
    private MovieMapper movieMapper;



    @Before
    public void init(){

        sqlSession = SqlSessionUtil.getSqlSession(true);
        movieMapper = sqlSession.getMapper(MovieMapper.class);
    }

    @Test
    public void findListByDirector(){
        MovieExample movieExample  = new MovieExample();

        movieExample.createCriteria().andDirectorLike("%黑泽明%");

        List<Movie> movieList = movieMapper.selectByExample(movieExample);
        for(Movie movie : movieList){
            System.out.println(movie);
        }

    }


    @Test
    public void findById(){
        Movie movie = movieMapper.selectByPrimaryKey(101);
        System.out.println(movie);

    }



    @Test
    public void insert(){

        Movie movie  = new Movie();
        movie.setTitle("嘿嘿嘿和");

        int number = movieMapper.insertSelective(movie);

        /*int number = movieMapper.insert(movie);*/
        System.out.println(number);
    }

    @After
    public void close(){

        sqlSession.close();

    }


}
