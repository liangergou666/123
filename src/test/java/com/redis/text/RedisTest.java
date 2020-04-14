package com.redis.text;

import com.redis.pojo.Users;
import org.junit.Test;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisCommands;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisAccessor;
import org.springframework.data.redis.core.RedisCommand;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

/**
 * redis测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RedisTest {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Test
    public  void test1() {
        //
        this.redisTemplate.opsForValue().set("1234", "admin123456");
        //Object k1 = this.redisTemplate.opsForValue().get("key1");
        //System.out.println(k1);
    }
    @Test
    public void  test2(){
       // Users users=new Users();
        //users.setAge(30);
        //users.setId(1);
        //users.setName("张三");
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        //redisTemplate.opsForValue().set("users", users);
        System.out.println(redisTemplate.opsForValue().get("users"));
    }
    @Test
    public  void test4(){
//        //Users users=new Users();
//        //users.setAge(34);
//        //users.setId(2);
//        users.setName("张");
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Users> (Users.class));
        System.out.println(redisTemplate.opsForValue().get("usersa"));
    }

}
