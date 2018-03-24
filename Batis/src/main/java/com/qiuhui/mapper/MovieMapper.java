package com.qiuhui.mapper;

import com.qiuhui.entity.Movie;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MovieMapper {

    List<Movie> findMoviesByName( String title );
    List<Movie> findMoviesByNameAndDirector(Map<String,String> map);
    List<Movie> findMoviesByIdList(@Param("idList") List<Integer> idList);
    void saveMovies(@Param("movieList") List<Movie> movieList);
}
