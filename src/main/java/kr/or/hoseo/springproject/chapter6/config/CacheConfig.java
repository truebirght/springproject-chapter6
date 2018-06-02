package kr.or.hoseo.springproject.chapter6.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@EnableCaching
public class CacheConfig {
	@Value("${redis.host}")
	private String host;

	@Value("${redis.port}")
	private int port;
	
	@Bean
	public CacheManager cacheManager() {
		return new RedisCacheManager(redisTemplate());
	}
	
	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setHostName(host);
		factory.setPort(port);
		factory.setUsePool(true);
		
		return factory;
	}
	
	@Bean
	public RedisTemplate<Object, Object> redisTemplate(){
		RedisTemplate<Object, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}
}
