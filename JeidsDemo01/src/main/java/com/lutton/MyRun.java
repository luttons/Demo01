package com.lutton;

/**
 * @ClassName：MyRun
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class MyRun implements Runnable{
    private Service sc = null;

    public MyRun(String id, int num) {
        sc = new Service(id, num);
    }

    public void run() {
        while (true){
            sc.service();
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
