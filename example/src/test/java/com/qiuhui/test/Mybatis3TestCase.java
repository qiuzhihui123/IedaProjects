package com.qiuhui.test;

import com.qiuhui.entity.Movie;
import com.qiuhui.entity.MovieExample;
import com.qiuhui.mapper.MovieMapper;
import com.qiuhui.util.SqlSessionUtil;
import com.sun.org.glassfish.gmbal.Description;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class Mybatis3TestCase {

    private SqlSession sqlSession;
    private MovieMapper movieMapper;



    /**
     *@Description:初始化创建sqlSession和mapper
     *@Author: 邱志辉
     *@Date 2018/3/27 0027上午 8:54
     */
    @Before
    public void init(){

        sqlSession = SqlSessionUtil.getSqlSession(true);
        movieMapper = sqlSession.getMapper(MovieMapper.class);
    }

    /**
     *@Description:根据导演模糊匹配电影List
     *@Author:邱志辉
     *@Date 2018/3/27 0027上午 8:53
     */
    @Test
    public void findListByDirector(){
        MovieExample movieExample  = new MovieExample();

        movieExample.createCriteria().andDirectorLike("%黑泽明%").andIdGreaterThan(122);

        List<Movie> movieList = movieMapper.selectByExample(movieExample);
        for(Movie movie : movieList){
            System.out.println(movie);
        }

    }

    @Test
    public void findListOr(){
        MovieExample movieExample = new MovieExample();
        movieExample.or().andRateGreaterThanOrEqualTo(8F);
        movieExample.or().andReleaseYearBetween("2010","2018");
        movieExample.setDistinct(true);
        movieExample.setOrderByClause("release_year desc");
        List<Movie> movieList = movieMapper.selectByExample(movieExample);

        for(Movie movie : movieList){
            System.out.println(movie);
        }
        }




   /**
    *@Description:根据id找电影
    *@Author: 邱志辉
    *@Date 2018/3/27 0027上午 8:52
    */
    @Test
    public void findById(){
        Movie movie = movieMapper.selectByPrimaryKey(101);
        System.out.println(movie);

    }



    /**
     *@Description:插入一个电影
     *@Author: 邱志辉
     *@Date 2018/3/27 0027上午 8:55
     */
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
