package redis;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * 分片
 * sudo yum install -y yum-utils
 */
public class TestShardJedis {

    public static void main(String[] args) {

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);

        List<JedisShardInfo> infos = new ArrayList<>();

        //docker reids 分片
        JedisShardInfo info1 = new JedisShardInfo("172.16.93.134", 7000);
        JedisShardInfo info2 = new JedisShardInfo("172.16.93.134", 7001);
        JedisShardInfo info3 = new JedisShardInfo("172.16.93.134", 7002);
        infos.add(info1);
        infos.add(info2);
        infos.add(info3);



        ShardedJedisPool jedisPool = new ShardedJedisPool(config, infos);

        ShardedJedis jedis = jedisPool.getResource();

//        for (int i = 0; i < 10; i++) {
//            jedis.set("k" + i, "v" + i);
//        }

        System.out.println(jedis.get("k5"));
        jedisPool.returnResource(jedis);
        jedisPool.close();
    }
}
