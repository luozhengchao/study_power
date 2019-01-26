package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * jedis连接池测试
 */
public class TestRedisPool {

    public static void main(String[] args) {

        //连接池配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(200);

        //创建池对象
        JedisPool jedisPool = new JedisPool(config,"172.16.93.131", 6380);

        //获取jedis对象
        Jedis jedis = jedisPool.getResource();

//        String result = jedis.get("a");
//        System.out.println(result);

        for (int i = 0; i < 10; i++) {
            jedis.set("n" + i, "v" + i);
        }

        //还回连接
        jedisPool.returnResource(jedis);
        jedisPool.close();
    }
}
