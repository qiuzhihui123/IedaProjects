package com.qiuhui.mapper;

import com.qiuhui.entity.Movie;
import org.apache.ibatis.annotations.*;

import java.util.List;

@CacheNamespace
public  interface MovieMapper {


    List<Movie> findMovieByNameAndDirector(@Param("title") String name, @Param("director") String director);
    void saveMovies(@Param("movieList") List<Movie> movieList);

    @Select("select * from movie where id = #{id}")
    Movie fingMovieById(Integer id);

    @Update("update movie set title = #{title}")
    void update(Movie movie);

    @Delete("delete from movie where id = #{id}")
    void deleteById(int i);

    @Insert("insert into movie (title) values (#{title})")
    void add(Movie movie);
}
