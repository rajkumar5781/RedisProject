package com.redis;

import redis.clients.jedis.UnifiedJedis;

public class RedisConnection {
//		public  UnifiedJedis jedis;
//		static {
//			 UnifiedJedis jedis = new UnifiedJedis("redis://localhost:6379");
//		}
	
		public UnifiedJedis getInstance() {
			return new UnifiedJedis("redis://localhost:6379");
		}
}
