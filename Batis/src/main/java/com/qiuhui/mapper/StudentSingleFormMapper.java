package com.qiuhui.mapper;

import com.qiuhui.entity.Student;

public interface StudentSingleFormMapper {

    Student findStudentWithSchoolBySingleFormById(Integer id);
}
