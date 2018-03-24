package com.qiuhui.test;

import com.qiuhui.entity.Movie;
import com.qiuhui.mapper.MovieMapper;
import com.qiuhui.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class MovieMapperTestCase {

    private SqlSession sqlSession;
    private MovieMapper movieMapper;


    @Before
    public void init(){
        sqlSession = SqlSessionUtil.getSqlSession(true);
        movieMapper = sqlSession.getMapper(MovieMapper.class);
    }

    @Test
    public void findMovieByName(){
        List<Movie> movieList = movieMapper.findMoviesByName("%西游记%");
        for(Movie movie : movieList){
            System.out.println(movie);
        }
    }

    @Test
    public void findMoviesByNameAndDirector(){
        Map<String,String> map = new HashMap<>();
        map.put("title","%神探夏洛克%");
        map.put("director","柯尔姆·麦卡锡　");

        List<Movie> movieList = movieMapper.findMoviesByNameAndDirector(map);
        for(Movie movie : movieList){
            System.out.println(movie);
        }
    }

    @Test
    public void findMoviesByIdList(){
        List<Integer> idList = Arrays.asList(102,13,14);

        List<Movie>  movieList = movieMapper.findMoviesByIdList(idList);

        for(Movie movie : movieList){
            System.out.println(movie);
        }
    }

    @Test
    public void insert(){
        List<Movie> movieList = new ArrayList<>();

        Movie movie = new Movie();
        movie.setTitle("哈哈哈傻子");
        movie.setDirector("邱志辉");
        movie.setRate(89F);

        Movie movie1 = new Movie();
        movie1.setTitle("哈哈哈傻子");
        movie1.setDirector("邱志辉");
        movie1.setRate(89F);

        Movie movie2 = new Movie();
        movie2.setTitle("哈哈哈傻子");
        movie2.setDirector("邱志辉");
        movie2.setRate(89F);

        movieList.add(movie);
        movieList.add(movie1);
        movieList.add(movie2);

       movieMapper.saveMovies(movieList);
    }


    @After
    public void close(){
        sqlSession.close();
    }
}
