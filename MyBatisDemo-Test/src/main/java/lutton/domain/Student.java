package com.lutton.domain;

import java.util.List;

/**
 * @ClassName：Student
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class Student {
    private int stu_id;
    private String stu_name;
    private String stu_sex;
    private int stu_age;
//    private int lesson_id;
    private Lesson lesson;
    private List<Lesson> lessonList;

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id=" + stu_id +
                ", stu_name='" + stu_name + '\'' +
                ", stu_sex='" + stu_sex + '\'' +
                ", stu_age=" + stu_age +
                ", lesson=" + lesson +
                ", lessonList=" + lessonList +
                '}';
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    public Student(int stu_id, String stu_name, String stu_sex, int stu_age, Lesson lesson, List<Lesson> lessonList) {
        this.stu_id = stu_id;
        this.stu_name = stu_name;
        this.stu_sex = stu_sex;
        this.stu_age = stu_age;
        this.lesson = lesson;
        this.lessonList = lessonList;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_sex() {
        return stu_sex;
    }

    public void setStu_sex(String stu_sex) {
        this.stu_sex = stu_sex;
    }

    public int getStu_age() {
        return stu_age;
    }

    public void setStu_age(int stu_age) {
        this.stu_age = stu_age;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Student(String stu_name, String stu_sex, int stu_age, Lesson lesson) {
        this.stu_name = stu_name;
        this.stu_sex = stu_sex;
        this.stu_age = stu_age;
        this.lesson = lesson;
    }

    public Student() {
    }

    public Student(int stu_id, String stu_name, String stu_sex, int stu_age, Lesson lesson) {
        this.stu_id = stu_id;
        this.stu_name = stu_name;
        this.stu_sex = stu_sex;
        this.stu_age = stu_age;
        this.lesson = lesson;
    }
}
