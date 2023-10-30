package com.lutton.domain;

import java.util.List;

/**
 * @ClassName：Lesson
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class Lesson {
    private int lesson_id;
    private String lesson_name;
    private String lesson_teacher;
    private List<Student> stuList;

    @Override
    public String toString() {
        return "Lesson{" +
                "lesson_id=" + lesson_id +
                ", lesson_name='" + lesson_name + '\'' +
                ", lesson_teacher='" + lesson_teacher + '\'' +
                ", studentList=" + stuList +
                '}';
    }

    public List<Student> getStudentList() {
        return stuList;
    }

    public void setStudentList(List<Student> studentList) {
        this.stuList = studentList;
    }

    public Lesson(int lesson_id, String lesson_name, String lesson_teacher, List<Student> studentList) {
        this.lesson_id = lesson_id;
        this.lesson_name = lesson_name;
        this.lesson_teacher = lesson_teacher;
        this.stuList = studentList;
    }

    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }

    public String getLesson_name() {
        return lesson_name;
    }

    public void setLesson_name(String lesson_name) {
        this.lesson_name = lesson_name;
    }

    public String getLesson_teacher() {
        return lesson_teacher;
    }

    public void setLesson_teacher(String lesson_teacher) {
        this.lesson_teacher = lesson_teacher;
    }

    public Lesson(String lesson_name, String lesson_teacher) {
        this.lesson_name = lesson_name;
        this.lesson_teacher = lesson_teacher;
    }

    public Lesson() {
    }

    public Lesson(int lesson_id, String lesson_name, String lesson_teacher) {
        this.lesson_id = lesson_id;
        this.lesson_name = lesson_name;
        this.lesson_teacher = lesson_teacher;
    }
}
