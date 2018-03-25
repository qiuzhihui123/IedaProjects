package com.qiuhui.mapper;

import com.qiuhui.entity.Movie;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public  interface MovieMapper {


    List<Movie> findMovieByNameAndDirector(@Param("title") String name, @Param("director") String director);
    void saveMovies(@Param("movieList") List<Movie> movieList);

}
