package com.lutton;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisDataException;

/**
 * @ClassName：Service
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class Service {
    private String id;
    private int num;

    public Service(String id, int num) {
        this.id = id;
        this.num = num;
    }

    public void service(){
        Jedis jedis = JedisUtiles.getJedis();
        String value = jedis.get("USERID:" + this.id);

        try{
            if (value == null){
                jedis.setex("USERID:" + id, 60, Long.MAX_VALUE - num + "");
            }else {
                Long val = jedis.incr("USERID:" + id);
                download(id, val - (Long.MAX_VALUE - num));
            }
        }catch (JedisDataException e){
            System.out.println(Thread.currentThread().getName() + " >>> 下载次数已使用完毕，请升级会员解锁更高下载次数");
            return;

        }finally {
            jedis.close();
        }
    }

    private void download(String id, Long l) {
        System.out.println("用户 " + id + " 下载第 " + l + " 次");
    }
}