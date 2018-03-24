import com.qiuhui.entity.Student;
import com.qiuhui.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class StudentMapperTestCase {

    SqlSession sqlSession;

    @Before
    public void init(){
        sqlSession = SqlSessionUtil.getSqlSession(true);
    }

    @Test
    public void findAll(){
       List<Student> lists = sqlSession.selectList("com.qiuhui.mapper.StudentMapper.findAll");
       for(Student stu : lists){
           System.out.println(stu);
       }

    }

    @Test
    public void saveStudent(){
        Student student = new Student( );
        student.setAge(12);
        student.setEmail("lkfjlkasjf@kljlj");
        student.setStudentName("哈哈小傻瓜");
        sqlSession.insert("com.qiuhui.mapper.StudentMapper.insertStudent",student);
        System.out.println("我存入后返回的id是"+student.getId());

    }

    @Test
    public void update(){
        Student student = sqlSession.selectOne("com.qiuhui.mapper.StudentMapper.findStudentById",1);
        student.setStudentName("你是不是傻");
        sqlSession.update("com.qiuhui.mapper.StudentMapper.update",student);

    }

    @Test
    public void deleteById(){
        sqlSession.delete("com.qiuhui.mapper.StudentMapper.delete",3);
    }

    @After
    public void close(){
        sqlSession.close();
    }
}
