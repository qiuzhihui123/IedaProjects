package com.qiuhui;

import com.qiuhui.entity.Movie;
import com.qiuhui.util.NewSqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class NewMovieTestCase {

    private SqlSession sqlSession;


    @Before
    public void init(){
        sqlSession = NewSqlSessionUtil.getSqlSession(true);
    }

    @Test
    public void findAll(){


        List<Movie> movieList =  sqlSession.selectList("com.qiuhui.mapper.MovieMapper.findAll");
        for(Movie movie :movieList){
            System.out.println(movie);
        }
    }

}
