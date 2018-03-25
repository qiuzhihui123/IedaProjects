package com.qiuhui;

import com.qiuhui.entity.Movie;
import com.qiuhui.mapper.MovieMapper;
import com.qiuhui.mapper.StudentSchoolMapper;
import com.qiuhui.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieTestCase {

    private SqlSession sqlSession;
    private MovieMapper mapper;

    @Before
    public void init(){
        sqlSession = SqlSessionUtil.getSqlSession(true);
        mapper = sqlSession.getMapper(MovieMapper.class);
    }

    @Test
    public void findMovieByNameAndDirector(){

        List<Movie> movieList = mapper.findMovieByNameAndDirector("","%%");
        for(Movie movie : movieList){
            System.out.println(movie);
        }

    }

    @Test
    public  void save(){

        Movie m1 = new Movie();
        m1.setTitle("111");

        Movie m2 = new Movie();
        m2.setTitle("222");

        Movie m3 = new Movie();
        m3.setTitle("333");

        List<Movie> movieList = Arrays.asList(m1,m2,m3);

        mapper.saveMovies(movieList);
    }


    @After
    public void close(){
        sqlSession.close();
    }
}
