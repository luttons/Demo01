import com.lutton.domain.User;
import com.lutton.dao.UserMapperInterface;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName：MyBatiesTest
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class UserDaoTest {


    private SqlSession sqlSession;
    @Before
    public void before() throws IOException {
        //        获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        获取 session 工厂对象. 获取构建SqlSessionFactory对象 它负责创建SqlSession对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        获取 session 对话对象. 创建SqlSession对象，SqlSession用于执行SQL语句和管理事务。
        sqlSession = sqlSessionFactory.openSession();
    }


    /**
     *  查询所有
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {
        UserMapperInterface mapper = sqlSession.getMapper(UserMapperInterface.class);
        List<User> users = mapper.selAll();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    /**
     * 根据姓名查询
     */
    @Test
    public void test02(){
        UserMapperInterface mapper = sqlSession.getMapper(UserMapperInterface.class);
        User root = mapper.selByUserName("root");
        System.out.println(root);
    }

    /**
     *  添加
     */
    @Test
    public void test03() throws IOException {
        UserMapperInterface mapper = sqlSession.getMapper(UserMapperInterface.class);
        mapper.add(new User("778", "887", "1"));
        sqlSession.commit();
        test01();
    }

    /**
     *  修改
     */
    @Test
    public void test04() throws IOException {
        UserMapperInterface mapper = sqlSession.getMapper(UserMapperInterface.class);
        mapper.update(new User("778", "888", "1"));
        sqlSession.commit();
        test01();
    }

    /**
     *  根据姓名删除
     */
    @Test
    public void test05() throws IOException {
        UserMapperInterface mapper = sqlSession.getMapper(UserMapperInterface.class);
        mapper.deleteByName("778");
        sqlSession.commit();
        test01();
    }

    /**
     *  动态 sql 查询  ---- if
     */
    @Test
    public void test06() throws IOException {
        UserMapperInterface mapper = sqlSession.getMapper(UserMapperInterface.class);

//        List<User> users = mapper.selBySomething(new User(0, null, null, null));

        List<User> users = mapper.selBySomething(new User(0, "root", null, null));

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    /**
     *  动态 sql 查询 --- foreach
     * @throws IOException
     */
    @Test
    public void test07() throws IOException {
        UserMapperInterface mapper = sqlSession.getMapper(UserMapperInterface.class);

        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("root");
        nameList.add("ice");
        nameList.add("xiaosi");
        nameList.add("ooo");

        List<User> userList = mapper.selByNames(nameList);

        for (User s : userList) {
            System.out.println(s);
        }

        sqlSession.close();
    }
}

