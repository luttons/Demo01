import com.lutton.dao.LessonMapperInterface;
import com.lutton.dao.StudentMapperInterface;
import com.lutton.domain.Lesson;
import com.lutton.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName：StudentTest
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class StudentAndLessonTest {

    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
    }


    /**
     *  一个学生对应 一个课程
     */
    @Test
    public void test01(){
        StudentMapperInterface mapper = sqlSession.getMapper(StudentMapperInterface.class);
        List<Student> students = mapper.selStuLess();
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }


    /**
     *  一个课程对应多个学生
     */
    @Test
    public void test02(){
        LessonMapperInterface mapper = sqlSession.getMapper(LessonMapperInterface.class);
        List<Lesson> lessons = mapper.selLesson();
        for (Lesson lesson : lessons) {
            System.out.println(lesson);
        }
        sqlSession.close();
    }

    @Test
    public void test03(){
        StudentMapperInterface mapper = sqlSession.getMapper(StudentMapperInterface.class);
        List<Student> students = mapper.selStudentsSelLessons();
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
