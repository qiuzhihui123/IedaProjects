package com.qiuhui.mapper;

import com.qiuhui.entity.Tag;

import java.util.List;

public interface StudentTagMapper {

    List<Tag> findStudentTag(Integer id);
}
