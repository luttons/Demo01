package com.lutton;

/**
 * @ClassName：TestMain
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class TestMain {
    public static void main(String[] args) {
        Thread user01 = new Thread(new MyRun("游客", 5));
        Thread user02 = new Thread(new MyRun("普通用户", 15));
        Thread user03 = new Thread(new MyRun("VIP会员", 50));

        user01.start();
        user02.start();
        user03.start();
    }
}
