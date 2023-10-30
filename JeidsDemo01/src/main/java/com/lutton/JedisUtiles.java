package com.lutton;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * @ClassName：JedisUtiles
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class JedisUtiles {
    private static String host = null;
    private static String port = null;
    private static String maxTotal = null;
    private static String maxIdel = null;
    private static JedisPool jedisPool = null;

    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("redis");

        host = resourceBundle.getString("redis.host");
        port = resourceBundle.getString("redis.port");
        maxTotal = resourceBundle.getString("redis.maxTotal");
        maxIdel = resourceBundle.getString("redis.maxIdle");

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        jedisPoolConfig.setMaxTotal(Integer.parseInt(maxTotal));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(maxIdel));

        jedisPool = new JedisPool(jedisPoolConfig, host, Integer.parseInt(port));
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
