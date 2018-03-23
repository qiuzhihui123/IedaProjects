import com.qiuhui.entity.Student;
import com.qiuhui.mapper.StudentMapper;
import com.qiuhui.util.SqlSessionUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMapperInterfaceTestCase {

    SqlSession sqlSession;
    StudentMapper studentMapper;
    int start = 0;
    int size = 4;

    @Before
    public void init(){
        sqlSession = SqlSessionUtil.getSqlSession(true);
        studentMapper = sqlSession.getMapper(StudentMapper.class);

    }

    @Test
    public void findAll(){
       List<Student> lists = studentMapper.findAll();
       for(Student stu : lists){
           System.out.println(stu);
       }

    }

    @Test
    public void saveStudent(){
        Student student = new Student( );
        student.setAge(12);
        student.setEmail("lkfjlkasjf@kljlj");
        student.setName("哈哈小傻瓜");
        studentMapper.insertStudent(student);
        System.out.println("我存入后返回的id是"+student.getId());

    }

    @Test
    public void update(){
        Student student = studentMapper.findStudentById(2);
        student.setName("你是不是傻");
        studentMapper.update(student);

    }

    @Test
    public void findPage(){
        List<Student> stuList = studentMapper.page1(start,size);
        for(Student stu : stuList){
            System.out.println(stu);
        }
    }

    @Test
    public void findPage2(){
        Map<String,Integer> map = new HashMap<>();
        map.put("start",start);
        map.put("size",size);
        List<Student> stuList = studentMapper.page2(map);
        for(Student stu : stuList){
            System.out.println(stu);
        }
    }

    @Test
    public void findPage3(){

        List<Student> stuList = studentMapper.page3(start,size);
        for(Student stu : stuList){
            System.out.println(stu);
        }
    }


    @Test
    public void deleteById(){
        studentMapper.delete(3);
    }

    @After
    public void close(){
        sqlSession.close();
    }
}
