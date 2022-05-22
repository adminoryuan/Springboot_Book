package com.example.webchat.Untity;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUntity {
        @Autowired
        private StringRedisTemplate redisTemplate;


        @Autowired
        JsonUntity JSON;
        private final String DEFAULT_KEY_PREFIX = "";
        private final int EXPIRE_TIME = 1;
        private final TimeUnit EXPIRE_TIME_TYPE = TimeUnit.DAYS;


        /**
         * 数据缓存至redis
         *
         * @param key
         * @param value
         * @return
         */
        public <K, V> void add(K key, V value) {
            try {
                if (value != null) {
                    redisTemplate
                            .opsForValue()
                            .set(DEFAULT_KEY_PREFIX + key, JSON.Serialize(value));
                }
            } catch (Exception e) {
               // log.error(e.getMessage(), e);
                throw new RuntimeException("数据缓存至redis失败");
            }
        }

        /**
         * 数据缓存至redis并设置过期时间
         *
         * @param key
         * @param value
         * @return
         */
        public <K, V> void add(K key, V value, long timeout, TimeUnit unit) {
            try {
                if (value != null) {
                    redisTemplate
                            .opsForValue()
                            .set(DEFAULT_KEY_PREFIX + key, JSON.Serialize(value), timeout, unit);
                }
            } catch (Exception e) {
               // log.error(e.getMessage(), e);
                throw new RuntimeException("数据缓存至redis失败");
            }
        }

        /**
         * 写入 hash-set,已经是key-value的键值，不能再写入为hash-set
         *
         * @param key    must not be {@literal null}.
         * @param subKey must not be {@literal null}.
         * @param value  写入的值
         */
        public <K, SK, V> void addHashCache(K key, SK subKey, V value) {
            redisTemplate.opsForHash().put(DEFAULT_KEY_PREFIX + key, subKey, value);
        }



        /**
         * 写入 hash-set,并设置过期时间
         *
         * @param key    must not be {@literal null}.
         * @param subKey must not be {@literal null}.
         * @param value  写入的值
         */
        public <K, SK, V> void addHashCache(K key, SK subKey, V value, long timeout, TimeUnit unit) {
            redisTemplate.opsForHash().put(DEFAULT_KEY_PREFIX + key, subKey, value);
            redisTemplate.expire(DEFAULT_KEY_PREFIX + key, timeout, unit);
        }

        /**
         * 获取 hash-setvalue
         *
         * @param key    must not be {@literal null}.
         * @param subKey must not be {@literal null}.
         */
        public <K, SK> Object getHashCache(K key, SK subKey) {
            return  redisTemplate.opsForHash().get(DEFAULT_KEY_PREFIX + key, subKey);
        }

        /**
         * 获取hash长度
         * @param hkey
         * @return
         */
         public int getHashLen(String hkey){
            return redisTemplate.opsForHash().keys(hkey).size();
        }

        /**
         * 获取hash所有键
         * @param hkey
         * @return
         */
        public Set<Object> getHashKeySet(String hkey){
             return redisTemplate.opsForHash().keys(hkey);
        }

        /**
         * 从redis中获取缓存数据，转成对象
         *
         * @param key   must not be {@literal null}.
         * @param clazz 对象类型
         * @return
         */
        public <K, V> V getObject(K key, Class<V> clazz) throws IOException {
            String value = this.get(key);
            V result = null;
            if (value!=null && !value.equals("")) {
                result = JSON.Squence(value, clazz);
            }
            return result;
        }

        /**
         * 从redis中获取缓存数据，转成list
         *
         * @param key   must not be {@literal null}.
         * @param clazz 对象类型
         * @return
         */
        public <K, V> List<V> getList(K key, Class<V> clazz) {
            String value = this.get(key);
            List<V> result = Collections.emptyList();
//            if (!StringUtils.isEmpty(value)) {
//                result = JSONArray.parseArray(value, clazz);
//            }
            return result;
        }

        /**
         * 功能描述：Get the value of {@code key}.
         *
         * @param key must not be {@literal null}.
         * @return java.lang.String
         * @date 2021/9/19
         **/
        public <K> String get(K key) {
            String value;
            try {
                value = redisTemplate.opsForValue().get(DEFAULT_KEY_PREFIX + key);
            } catch (Exception e) {
                //log.error(e.getMessage(), e);
                throw new RuntimeException("从redis缓存中获取缓存数据失败");
            }
            return value;
        }

        /**
         * 删除key
         */
        public void delete(String key) {
            redisTemplate.delete(key);
        }

        /**
         * 批量删除key
         */
        public void delete(Collection<String> keys) {
            redisTemplate.delete(keys);
        }

        /**
         * 序列化key
         */
        public byte[] dump(String key) {
            return redisTemplate.dump(key);
        }

        /**
         * 是否存在key
         */
        public Boolean hasKey(String key) {
            return redisTemplate.hasKey(key);
        }

        /**
         * 设置过期时间
         */
        public Boolean expire(String key, long timeout, TimeUnit unit) {
            return redisTemplate.expire(key, timeout, unit);
        }

        /**
         * 设置过期时间
         */
        public Boolean expireAt(String key, Date date) {
            return redisTemplate.expireAt(key, date);
        }


        /**
         * 移除 key 的过期时间，key 将持久保持
         */
        public Boolean persist(String key) {
            return redisTemplate.persist(key);
        }

        /**
         * 返回 key 的剩余的过期时间
         */
        public Long getExpire(String key, TimeUnit unit) {
            return redisTemplate.getExpire(key, unit);
        }

        /**
         * 返回 key 的剩余的过期时间
         */
        public Long getExpire(String key) {
            return redisTemplate.getExpire(key);
        }
}
