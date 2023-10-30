package com.lutton;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName：JedisTest
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class JedisTest {

    @Test
    public void test01(){
//        连接 Jedis
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.set("infoFromJava", "Jedis");

        String info = jedis.get("infoFromJava");

        System.out.println("infoFromJava = " + info);

//        关闭 Jedis
        jedis.close();
    }

    @Test           // String类型的测试
    public void test02(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        Long infoFromJava = jedis.strlen("infoFromJava");
        System.out.println("infoFromJava的长度：" + infoFromJava);

        Long append = jedis.append("infoFromJava", "Andappend");
        System.out.println("追加：" + append);

        String age = jedis.setex("age", 10, "20");
        System.out.println("age:" + jedis.get("age"));

    }

    @Test  // hash 类型的测试
    public void test03(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.hset("test01", "name", "zhangsan");
        System.out.println("test01:name: " + jedis.hget("test01", "name"));

        HashMap<String, String> hash = new HashMap<String, String>();
        hash.put("age", "20");
        hash.put("sex", "boy");
        hash.put("money", "99995468");
        jedis.hmset("test01", hash);
        System.out.println("后来批量添加的几个：" + jedis.hmget("test01", "age", "sex", "money"));

        String getAll = jedis.hgetAll("test01").toString();
        System.out.println("一次性获取全部: " + getAll);

        jedis.hdel("test01", "money");
        System.out.println("删除money： " + jedis.hgetAll("test01").toString());

        jedis.hsetnx("test01", "money", "1000w");
        System.out.println("如果不存在money就设置： " + jedis.hgetAll("test01").toString());

        System.out.println("test01的长度：" + jedis.hlen("test01"));

        System.out.println("判断money是否存在： " + jedis.hexists("test01", "money"));
        System.out.println("判断wife是否存在： " + jedis.hexists("test01", "wife"));

        System.out.println("获取所有字段: " + jedis.hkeys("test01"));

        System.out.println("获取所有值: " + jedis.hvals("test01"));


        jedis.close();
    }

    @Test  // list 的测试
    public void test04(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.lpush("test04",  "2", "2", "2", "1", "2", "3", "4", "5");
        jedis.rpush("test04", "6", "7", "8", "9", "0");

        System.out.println("从左到右输出： " + jedis.lrange("test04", 0, -1));

        System.out.println("获取索引为 5 对应的数据： " + jedis.lindex("test04", 5) );

        System.out.println("列表的长度： " + jedis.llen("test04"));

        jedis.lpop("test04");
        System.out.println("从左边移出一个数据： " + jedis.lrange("test04", 0, -1));

        jedis.rpop("test04");
        System.out.println("从右边移出一个数据：" + jedis.lrange("test04", 0, -1));

        jedis.lrem("test04", 2, "2");
        System.out.println("删除两个 2 ：" + jedis.lrange("test04", 0, -1));

        jedis.close();
    }

    @Test  // set 的测试
    public void test05() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.sadd("test05", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "zero");
        System.out.println("获取全部数据： " + jedis.smembers("test05"));

        jedis.srem("test05", "three");
        System.out.println("删除 three ：" + jedis.smembers("test05"));

        System.out.println("获取set集合中数据的个数： " + jedis.scard("test05"));

        System.out.println("判断集合中是否存在 three： " + jedis.sismember("test05", "three"));
        System.out.println("判断集合中是否存在 zero： " + jedis.sismember("test05", "zero"));

        System.out.println("随机获取 3 个： " + jedis.srandmember("test05", 3));

        String r = jedis.spop("test05");
        System.out.println("随机获取一个并删除： " + "随机获取到的是：" + r);
        System.out.println("现在所有的值：" + jedis.smembers("test05"));

        jedis.sadd("test051", "two", "three", "four", "ten");
        Set<String> sinter = jedis.sinter("test05", "test051");
        System.out.println("求交集： " + sinter);

        Set<String> sunion = jedis.sunion("test05", "test051");
        System.out.println("求并集： " + sunion);

        Set<String> sdiff = jedis.sdiff("test051", "test05");
        System.out.println("求差集：" + sdiff);


        jedis.sinterstore("inter","test05", "test051" );
        System.out.println("交集存到新集合里： " + jedis.smembers("inter"));


        jedis.close();
    }

    @Test  //sorted-set 的测试
    public void test06() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        Long aLong = jedis.dbSize();
        System.out.println(aLong);

        jedis.close();
    }

}
