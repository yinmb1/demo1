package yy.demo.demo1.redis.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author yinmb
 * @Date 2019/1/14 11:12:40
 */
 @Component
 @EnableCaching
public class RedisConfig {
    private static final Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    /**
     * Redis服务器地址 默认开发机器
     */
    @Value("${spring.redis.host:}")
    private String host;
    /**
     * Redis服务器连接端口
     */
    @Value("${spring.redis.port:}")
    private int port;
    /**
     * 连接超时时间（毫秒)
     */
    @Value("${spring.redis.timeout:}")
    private int timeout;
    /**
     * 最大连接数
     */
    @Value("${spring.redis.pool.max-total:}")
    private int maxTotal;
    /**
     * 连接池中的最大空闲连接
     */
    @Value("${spring.redis.pool.max-idle:20}")
    private int maxIdle;
    /**
     * 连接池最大阻塞等待时间（使用负值表示没有限制）
     */
    @Value("${spring.redis.pool.max-wait:1500}")
    private long maxWaitMillis;
    /**
     * Redis服务器连接密码（默认为空）
     */
    @Value("${spring.redis.password:null}")
    private String password;
    /**
     * 使用几号库
     */
    @Value("${spring.redis.database:}")
    private int database;

    @Value("${testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${blockWhenExhausted}")
    private boolean blockWhenExhausted;
    /**
     * 本地单机模式  主从模式
     * @return
     * @author yinmb
     * @date 2019年1月10日 下午4:39:04
     * @since TODO
     */
    @Bean
    public JedisPool redisPoolFactory() {
        logger.info("JedisPool initialize start  host={},port={},database={}",host ,port,database);
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
        logger.info("JedisPool initialize end ...");
        JedisPool jedisPool  = null ;
        //无密码情况  默认使用1号库
        jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);
        return jedisPool;
    }
}
