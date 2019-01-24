package redis;

import redis.clients.jedis.Jedis;

/**
 * jedis测试
 */
public class TestRedis {

    public static void main(String[] args) {
        //创建接jedis对象
//        Jedis jedis = new Jedis("172.16.93.131", 6380);

        //docker redis单台测试
        Jedis jedis = new Jedis("172.16.93.134", 7000);

        jedis.set("b", "success2");
        System.out.println(jedis.get("b"));
        jedis.close();
    }
}
