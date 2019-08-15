package yy.demo.demo1.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author yinmb
 * @Date 2019/1/14 09:19:45
 */
@Service
public class JedisCacheClient {
        @Autowired
        private JedisPool jedisPool;

        /**
         * setVExpire(设置key值，同时设置失效时间 秒
         */
        public void set(String key, String value) {
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                jedis.set(key, value);
                System.out.println(jedis.getDB());

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.close(jedis);
            }

        }

        /**
         * (存入redis数据)
         */
        public void expire(String key, String value, Integer times) {
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                jedis.set(key, value);
                jedis.expire(key, times);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.close(jedis);
            }
        }

        /**
         * 删除redis数据
         */
        public void del(String key) {
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                jedis.del(key);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.close(jedis);
            }
        }
        /**
         * 获取key的值
         */
        public String get(String key) {
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                String s = jedis.get(key);
                return s;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.close(jedis);
            }
            return null;
        }

        /**
         * 释放连接
         * @param jedis
         */
        public void close(Jedis jedis){
            if (jedis != null) {
                jedis.close();
                if (jedis.isConnected()) {
                    try {
                        jedis.disconnect();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

}
