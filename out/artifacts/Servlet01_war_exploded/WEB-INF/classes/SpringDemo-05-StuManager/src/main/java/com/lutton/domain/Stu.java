package com.lutton.domain;

/**
 * @ClassName：Stu
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class Stu {
    private int id;
    private String name;
    private String sex;
    private int age;
    private float score;
    private String tel;

    @Override
    public String toString() {
        return "Stu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", tel='" + tel + '\'' +
                ", classid='" + classid + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public Stu(String name, String sex, int age, float score, String tel, String classid) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.score = score;
        this.tel = tel;
        this.classid = classid;
    }

    public Stu(int id, String name, String sex, int age, float score, String tel, String classid) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.score = score;
        this.tel = tel;
        this.classid = classid;
    }

    public Stu() {
    }

    private String classid;
}
