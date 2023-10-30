package com.lutton;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lutton.domain.Student;
import com.lutton.mapper01.StuMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName：MybatisplusTest
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class MybatisplusTest {

    @Autowired
    private StuMapper stuMapper;

    @Test
    public void test01(){
        List<Student> students = stuMapper.selectList(null);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    /**
     *  插入
     */
    @Test
    public void test02(){
        Student student = new Student();
        student.setName("ChouXiang");
        student. setAge(30);
        student. setSex("0");
        student. setScore(99);
        student. setTel("9980786");
        student. setClassid("211");

        int rows = stuMapper.insert(student);

        System.out.println(rows + "行 受相应！");
    }

    /**
     *  根据学号更新
     *   更新的时候，没设置的值： 引用型数据类型保持不变（String等提示白色的）, 基本数据类型自动填充为 0
     */
    @Test
    // int updateById(@Param("et") T entity);
    public void test03(){
        Student student = new Student();

        student.setId(3);
        student.setName("Third");
        student.setAge(90);

        int rows = stuMapper.updateById(student);

        System.out.println(rows + "行 受相应");
    }


    /**
     *  根据指定条件 修改
     */
    @Test
    // int update(@Param("et") T entity, @Param("ew") Wrapper<T> updateWrapper)
    public void test04(){
        Student student = new Student();

        student.setAge(80);
        student.setScore(88);

        QueryWrapper<Student> sqw = new QueryWrapper<>();
//        相当于 where name = "Third" ;
        QueryWrapper<Student> eq = sqw.eq("name", "Third");

//        sqw.eq("name", "Third").eq("id", "3");  相当于 where name = "Third" and id = 3
        int rows = stuMapper.update(student, eq);

        System.out.println(rows + "行 受相应");
    }

    /**
     *  根据指定条件 修改
     */
    @Test
    // int update(@Param("et") T entity, @Param("ew") Wrapper<T> updateWrapper)
    public void test05(){
        UpdateWrapper<Student> suw = new UpdateWrapper<>();

        suw.set("age", 20).set("score", 99).eq("name", "yi").eq("tel", "12345");


        int rows = stuMapper.update(null, suw);

        System.out.println(rows + "行 受相应");
    }

    /**
     *  指定条件删除
     */
    @Test
    // int delete(@Param("ew") Wrapper<T> wrapper);
    public void test06(){
        Student student = new Student();
        // 根据条件设置成员变量
        student.setScore(101);

        QueryWrapper<Student> sqw = new QueryWrapper<>(student);

        int rows = stuMapper.delete(sqw);

        System.out.println(rows + " 行受响应！~");
    }

    /**
     *  用 map 的形式，根据指定条件删除
     */
    @Test
    // int deleteByMap(@Param("cm") Map<String, Object> columnMap);
    public void test07(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "HuangLaoXie");
        map.put("age", 99);

        int rows = stuMapper.deleteByMap(map);

        System.out.println(rows + " 行受响应！~");
    }

    /**
     *   delete from stu where id in( ?, ?, ?,);
     */
    @Test
    // int deleteBatchIds(@Param("coll") Collection<? extends Serializable> idList)
    public void test08(){
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(100);
        ids.add(101);
        ids.add(102);
        ids.add(103);

        int rows = stuMapper.deleteBatchIds(ids);
        System.out.println(rows + " 行受响应！~");
    }

    /**
     *  根据主键 进行查询
     */
    @Test
    // T selectById(Serializable id);
    public void test09(){
        Student student = stuMapper.selectById(1);

        System.out.println(student);
    }

    /**
     *  查询多个 In ， 场景： 全部选中，批量操作
     */
    @Test
    // List<T> selectBatchIds(@Param("coll") Collection<? extends Serializable> idList)
    public void test10(){
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);

        List<Student> studentList = stuMapper.selectBatchIds(ids);

        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    /**
     *  map 的形式， 根据指定条件查询
     */
    @Test
    // List<T> selectByMap(@Param("cm") Map<String, Object> columnMap);
    public void test11(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Andy");
        map.put("sex", "1");

        List<Student> studentList = stuMapper.selectByMap(map);

        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    /**
     *   stuMapper.selectOne(sqw):
     *    查询结果只能是一条，多条会报错
     */
    @Test
    // T selectOne(@Param("ew") Wrapper<T> queryWrapper);
    public void test12(){
        Student student = new Student();
        student.setName("Andy");
        student.setId(1);
        student.setSex("1");
        student.setClassid("ITLaoXie");
        student.setScore(100);
        student.setTel("12345678901");
        student.setAge(19);

        QueryWrapper<Student> sqw = new QueryWrapper<>(student);

        Student stuRes = stuMapper.selectOne(sqw);

        System.out.println(stuRes);
    }

    /**
     *   统计查询到的结果 的数量： count(？)
     */
    @Test
    // Integer selectCount(@Param("ew") Wrapper<T> queryWrapper)
    public void test13(){
        QueryWrapper<Student> sqw = new QueryWrapper<>();
        sqw.ge("age", 17);

        Integer count = stuMapper.selectCount(sqw);

        System.out.println(count);
    }

    /**
     *  同样
     */
    @Test
    // List<T> selectList(@Param("ew") Wrapper<T> queryWrapper)
    public void test14(){
        QueryWrapper<Student> sqw = new QueryWrapper<>();
        sqw.le("age", 19);

        List<Student> studentList = stuMapper.selectList(sqw);

        for (Student student : studentList) {
            System.out.println(student);
        }
    }


    /**
     *  分页操作
     */
    @Test
// <E extends IPage<T>> E selectPage(E page, @Param("ew") Wrapper<T> queryWrapper);
    public void test15() {
        Page<Student> studentPage = new Page<>(1, 2); // 第一页，两条数据

        QueryWrapper<Student> sqw = new QueryWrapper<>();   //查询条件对象
        sqw.eq("sex", "1"); // 设置查询条件

//        根据指定条件查询，并得到分页的数据（总页数，当前页数.........）
        Page<Student> stuPage = stuMapper.selectPage(studentPage, sqw);

        System.out.println("结果数量：" + stuPage.getTotal());
        System.out.println("数据总页数：" + stuPage.getPages());
        System.out.println("当前页：" + stuPage.getCurrent());

//        获取当前页数的 所有数据；  具体的页数可以在第一条语句处设置
        List<Student> stuList = studentPage.getRecords();

        for (Student student : stuList) {
            System.out.println(student);
        }
    }

//
//        Page<Student> page = new Page<>(1, 2); // 第一页，两条数据
//
//        QueryWrapper<Student> sqw = new QueryWrapper<>();
//        sqw.eq("sex", "1");
//
//        IPage<Student> stuPage = stuMapper.selectPage(page, sqw);
//
//        System.out.println("结果数量：" + stuPage.getTotal());
//        System.out.println("数据总页数：" + stuPage.getPages());
//        System.out.println("当前页：" + stuPage.getCurrent());
//
//        List<Student> stuList = stuPage.getRecords();
//
//        for (Student student : stuList) {
//            System.out.println(student);
//        }
//    }

}
