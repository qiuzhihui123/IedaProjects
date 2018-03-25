package com.qiuhui.mapper;

import com.qiuhui.entity.Student;

public interface StudentSchoolMapper {

    Student findStudentSchoolById(Integer id);
    Student findStudentWithTags(Integer id);

}
