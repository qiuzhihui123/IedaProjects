package com.qiuhui.mapper;

import com.qiuhui.entity.Student;
import org.apache.ibatis.annotations.*;

public interface StudentMapper {

    @Select("select * from t_student where id = #{id}")
    @Results(value = {
            @Result(column = "id",property = "id"),
            @Result(column = "student_name" ,property = "studentName"),
            @Result(column = "age" ,property = "age"),
            @Result(column="school_id", property="school" , one = @One(select = "com.qiuhui.mapper.StudentSchoolMapper.findSchoolById")),
            @Result(column = "id" ,property="tagList" , many=@Many(select = "com.qiuhui.mapper.StudentTagMapper.findTagsById"))
    })
    Student findStudentSchoolAndTagsById(int i);
}
