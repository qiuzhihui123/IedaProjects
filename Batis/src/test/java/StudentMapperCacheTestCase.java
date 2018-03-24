import com.qiuhui.entity.Student;
import com.qiuhui.mapper.StudentMapper;
import com.qiuhui.mapper.StudentSingleFormMapper;
import com.qiuhui.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Test;

public class StudentMapperCacheTestCase {

    private SqlSession sqlSession;
    private StudentSingleFormMapper mapper;


    @After
    public void init(){
        sqlSession = SqlSessionUtil.getSqlSession(true);
        mapper = sqlSession.getMapper(StudentSingleFormMapper.class);
    }

    @Test
    public void findStudentWithSchoolBySingleForm(){
        Student student = mapper.findStudentWithSchoolBySingleFormById(3);
        System.out.println(student);

    }

    @Test
    public void findStudentBYId(){

        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession(true);
        SqlSession sqlSession2 = SqlSessionUtil.getSqlSession(true);

        StudentMapper mapper1 = sqlSession1.getMapper(StudentMapper.class);
        StudentMapper mapper2 = sqlSession2.getMapper(StudentMapper.class);
        Student stu1 = mapper1.findStudentById(6);
        sqlSession1.close();
        System.out.println(stu1);

        Student stu2 = mapper2.findStudentById(6);
        System.out.println(stu2);
        sqlSession2.close();

    }

    @After
    public void close(){

    }

}
