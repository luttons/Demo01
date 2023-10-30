package com.lutton.controller.global;

/**
 * @ClassName：Student
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class Student {
    private String name;
    private String sex;
    private int age;
    private float score;

    public Student(String name, String sex, int age, float score) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.score = score;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
