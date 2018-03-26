package com.qiuhui.mapper;

import com.qiuhui.entity.School;
import com.qiuhui.entity.Student;
import org.apache.ibatis.annotations.Select;

public interface StudentSchoolMapper {



    Student findStudentSchoolById(Integer id);

    @Select("select * from t_school where id = #{id}")
    School findSchoolById(Integer id);

    Student findStudentWithTags(Integer id);

}
