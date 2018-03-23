import com.qiuhui.entity.Student;
import com.qiuhui.entity.Tag;
import com.qiuhui.mapper.StudentMapper;
import com.qiuhui.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class StudentSchoolTestCase {

    private SqlSession sqlSession;
    private boolean autoCommit;
    private StudentMapper studentMapper;

    @Before
    public void init(){
        sqlSession = SqlSessionUtil.getSqlSession(!autoCommit);
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }
    @Test
    public void findStudentWithTags(){
        Student student = studentMapper.findStudentWithTags(1);
        System.out.println(student);
        for(Tag tag : student.getTagList()){
            System.out.println(tag.getTagName());
        }
    }
    @Test
    public void findStudentBySchoolId(){
        List<Student> stuList = studentMapper.findStudentBySchoolId(0);

        for(Student stu : stuList){
            System.out.println(stu);
        }
    }
    @After
    public void close(){
          sqlSession.close();
    }



}
