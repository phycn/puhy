package cn.puhy.jedis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author puhongyu
 * 2018/5/20 17:14
 */
public class First {
    public static void main(String[] args) throws IOException {

        Jedis jedis = new Jedis("117.48.203.244", 6379);
        jedis.set("puhy", "hello phy");
        System.out.println(jedis.get("puhy"));
        jedis.close();

        //redis集群
        Set<HostAndPort> jedisClusterNodes = new HashSet<>();
        jedisClusterNodes.add(new HostAndPort("117.48.203.244", 6379));
        JedisCluster jc = new JedisCluster(jedisClusterNodes);
        jc.set("foo", "bar");
        String value = jc.get("foo");
        System.out.println(value);
        jc.close();
    }
}
