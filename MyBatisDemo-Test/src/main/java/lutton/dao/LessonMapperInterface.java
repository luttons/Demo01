package com.lutton.dao;

import com.lutton.domain.Lesson;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LessonMapperInterface {

    @Select("select * from lesson")
    @Results({
            @Result(column = "lesson_id", property = "lesson_id"),
            @Result(column = "lesson_name", property = "lesson_name"),
            @Result(column = "lesson_teacher", property = "lesson_teacher"),
            @Result(
                    column = "lesson_id",
                    property = "stuList",
                    javaType = List.class,
                    many = @Many(select = "com.lutton.dao.StudentMapperInterface.selByLessonID")
            )
    })
    List<Lesson> selLesson();

    @Select("select * from lesson where lesson_id=#{lesson_id}")
    Lesson selByID(int lesson_id);


    @Select("select lesson.lesson_id, lesson_name from students_sel_lessons stls, lesson where #{stu_id} = stls.stu_id and lesson.lesson_id = stls.lesson_id ")
    List<Lesson> selByStuID(int stu_id);
}
