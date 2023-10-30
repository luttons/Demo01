package com.lutton.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName：Student
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("stu")
public class Student {
    private int id;
    private String name;
    private String sex;
    private int age;
    private float score;
    private String tel;
    private String classid;
}
