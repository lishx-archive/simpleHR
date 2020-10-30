package com.xian.config;


import com.xian.entities.MessageEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class MyRedisConfig {

    @Bean
    public RedisTemplate<Object, MessageEntity> messageRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, MessageEntity> template = new RedisTemplate<Object, MessageEntity>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<MessageEntity> ser = new Jackson2JsonRedisSerializer<MessageEntity>(MessageEntity.class);
        template.setDefaultSerializer(ser);
        return template;
    }


}
