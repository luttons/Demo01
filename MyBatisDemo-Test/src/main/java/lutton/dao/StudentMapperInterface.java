package com.lutton.dao;

import com.lutton.domain.Lesson;
import com.lutton.domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapperInterface {
    /**
     *  lesson_id : 相当于从上面拿下来一个外键，将这个外键传给下面的 one，当作查询条件进行二次查询
     *  lesson    : 相当于要展示给用户的列名字
     *  Lesson.class: 这个长远方法的类型，将二次查询的结果 封装到这里
     *  one:        二次查询的语句（注意是一对一的关系，还是一对多的关系）
     */
    @Select("select * from student")
    @Results({
            @Result(column = "stu_id", property = "stu_id"),
            @Result(column = "stu_name", property = "stu_name"),
            @Result(column = "stu_sex", property = "stu_sex"),
            @Result(column = "stu_age", property = "stu_age"),
            @Result(
                    column = "lesson_id",  // 通过外键进行查询，相当于二次查询条件
                    property = "lesson",  // 成员名
                    javaType = Lesson.class, // 成员方法
                    one = @One(select = "com.lutton.dao.LessonMapperInterface.selByID") // 一对一调用的方法
            )
    })
    List<Student> selStuLess();

    @Select("select * from student where lesson_id = #{lesson_id}")
    List<Student> selByLessonID(int lesson_id);


    @Select("select stu_id, stu_name from student")
    @Results({
            @Result(column = "stu_id", property = "stu_id"),
            @Result(column = "stu_name", property = "stu_name"),
            @Result(
                    column = "stu_id",
                    property = "lessonList",
                    javaType = List.class,
                    many = @Many(select = "com.lutton.dao.LessonMapperInterface.selByStuID")
            )
    })
    List<Student> selStudentsSelLessons();
}
