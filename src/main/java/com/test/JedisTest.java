package com.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.BitOP;
import redis.clients.jedis.Jedis;

public class JedisTest {

	Logger logger = LoggerFactory.getLogger(JedisTest.class);
	
	@Test
	public void testKey(){
		Jedis jedis = JedisUtil.getJedis();
		logger.info("{}",jedis.del("user"));
		logger.info("{}",jedis.dump("user"));
		logger.info("{}",jedis.exists("user"));
		logger.info("{}",jedis.expire("user", 6000)); //
		logger.info("{}",jedis.decrBy("user", 1));
		logger.info("{}",jedis.get("user"));
		logger.info("{}",jedis.getbit("user", 1));
		logger.info("{}",jedis.getrange("user", 2, 3));
		logger.info("{}",jedis.getSet("user", "张三"));
		logger.info("{}",jedis.incr("user"));
		logger.info("{}",jedis.incrBy("user", 1));
		logger.info("{}",jedis.incrByFloat("user", 2));
		logger.info("{}",jedis.mget("user"));
		logger.info("{}",jedis.mset("user"));
		logger.info("{}",jedis.msetnx("user"));
		logger.info("{}",jedis.psetex("user", 6000l, "王五"));
		logger.info("{}",jedis.set("user", "麻子"));
		logger.info("{}",jedis.setbit("user", 1, "小二"));
		logger.info("{}",jedis.setex("user", 6000, "栗子"));
		logger.info("{}",jedis.setnx("user", "狗蛋"));
		logger.info("{}",jedis.setrange("user", 1, "绳子"));
		logger.info("{}",jedis.strlen("user"));
	}
	
	@Test
	public void testString(){
		Jedis jedis = JedisUtil.getJedis();
		logger.info("{}",jedis.append("user", "张三"));
		logger.info("{}",jedis.bitcount("user"));
		logger.info("{}",jedis.bitop(BitOP.AND, "user", "李四"));
		logger.info("{}",jedis.decr("user"));
		logger.info("{}",jedis.decrBy("user", 1));
		logger.info("{}",jedis.get("user"));
		logger.info("{}",jedis.getbit("user", 1));
		logger.info("{}",jedis.getrange("user", 2, 3));
		logger.info("{}",jedis.getSet("user", "张三"));
		logger.info("{}",jedis.incr("user"));
		logger.info("{}",jedis.incrBy("user", 1));
		logger.info("{}",jedis.incrByFloat("user", 2));
		logger.info("{}",jedis.mget("user"));
		logger.info("{}",jedis.mset("user"));
		logger.info("{}",jedis.msetnx("user"));
		logger.info("{}",jedis.psetex("user", 6000l, "王五"));
		logger.info("{}",jedis.set("user", "麻子"));
		logger.info("{}",jedis.setbit("user", 1, "小二"));
		logger.info("{}",jedis.setex("user", 6000, "栗子"));
		logger.info("{}",jedis.setnx("user", "狗蛋"));
		logger.info("{}",jedis.setrange("user", 1, "绳子"));
		logger.info("{}",jedis.strlen("user"));
	}
}
