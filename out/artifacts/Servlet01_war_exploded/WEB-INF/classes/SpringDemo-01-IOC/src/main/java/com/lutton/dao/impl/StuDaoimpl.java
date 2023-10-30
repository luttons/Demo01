package com.lutton.dao.impl;

import com.lutton.dao.StuDao;
import com.lutton.global.Student;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName：StuDaoimpl
 * @Description： TODO      接口的实现类
 * @Author： Lut_Ton@GitHub
 */

public class StuDaoimpl implements StuDao {
    public StuDaoimpl() {
        System.out.println("StuDaoImpl 对象被创建了");
    }


    public void initMethod(){
        System.out.println("StuDaoImpl  对象初始化 ...");
    }

    public void destroyMethod(){
        System.out.println("StuDaoImpl  对象销毁 ...");
    }

    private String name;
    private int age;
    private float score;

    private List<String> strList;
    private Map<String, Student> stuMap;
    private Properties prop;

    public StuDaoimpl(String name, int age, float score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public void setStuMap(Map<String, Student> stuMap) {
        this.stuMap = stuMap;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getScore() {
        return score;
    }

    public List<String> getStrList() {
        return strList;
    }

    public Map<String, Student> getStuMap() {
        return stuMap;
    }

    public Properties getProp() {
        return prop;
    }

    @Override
    public void show() {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("score = " + score );
        System.out.println("=========================================");
        System.out.println("list = " + strList);
        System.out.println("map = " + stuMap);
        System.out.println("prop = " + prop);
    }
}
