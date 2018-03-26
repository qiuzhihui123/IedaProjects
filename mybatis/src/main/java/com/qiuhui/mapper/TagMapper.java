package com.qiuhui.mapper;

import com.qiuhui.entity.Tag;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TagMapper {

    Tag findTagById(Integer id);

    @Select("select * from t_student s inner join t_student_tag st on s.id = st.sid inner join t_tag on st.tid = t.id where st.id = #{id}")
    List<Tag> findTagsById(Integer id);
}
