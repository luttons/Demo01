import com.lutton.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName：MyBatiesTest
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class MyBatiesTest {


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
//        通过会话对象 执行 XML配置文件中的 namespace.id, 并返回执行结果
        List<User> userList = sqlSession.selectList("userMapper.selAll");

//        输出结果
        for (User user : userList) {
            System.out.println(user);
        }
//        释放资源
        sqlSession.close();
    }

    /**
     *  添加数据
     */
    @Test
    public void test02(){
        User user = new User("1321", "SiXiao", "2");
        int rows = sqlSession.insert("userMapper.add", user);
        System.out.println(rows +  "行数据受相应！~");
        sqlSession.commit();
        sqlSession.close();
    }


    /**
     *  更新
     */
    @Test
    public void test03(){
        User user = new User("1321", "1212", "1");
        int rows = sqlSession.update("userMapper.update", user);
        System.out.println(rows + "行受相应！~");
        sqlSession.commit();
        sqlSession.close();
    }


    /**
     *  根据一个 用户对象 删除
     */
    @Test
    public void test04(){
        User user = new User("1321", "1212", "1");
        int rows = sqlSession.delete("userMapper.deleteByUser", user);
        System.out.println(rows + "行受相应！~");
        sqlSession.commit();
        sqlSession.close();
    }


    /**
     *  根据 用户名 删除
     */
    @Test
    public void test05(){
        int rows = sqlSession.delete("userMapper.deleteByName", "1321");
        System.out.println(rows +  "行数据受相应！~");
        sqlSession.commit();
        sqlSession.close();
    }


    /**
     *  根据 用户 id 删除
     */
    @Test
    public void test06(){
        int rows = sqlSession.delete("userMapper.deleteById", 14);
        System.out.println(rows +  "行数据受相应！~");
        sqlSession.commit();
        sqlSession.close();
    }
}
