package com.test;

import java.util.HashMap;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.BitOP;
import redis.clients.jedis.DebugParams;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisMonitor;
import redis.clients.jedis.JedisPubSub;

public class JedisTest {

	Logger logger = LoggerFactory.getLogger(JedisTest.class);
	
	@Test
	public void testKey(){
		Jedis jedis = JedisUtil.getJedis();
		logger.info("{}",jedis.del("user"));
		logger.info("{}",jedis.dump("user"));
		logger.info("{}",jedis.exists("user"));
		logger.info("{}",jedis.expire("user", 6000)); //
		logger.info("{}",jedis.expireAt("user", 100));
		logger.info("{}",jedis.keys("user"));
		logger.info("{}",jedis.migrate("127.0.0.1", 6379, "user", 1, 6000));
		logger.info("{}",jedis.move("user", 1));
		logger.info("{}",jedis.objectEncoding("user"));
		logger.info("{}",jedis.persist("user"));
		logger.info("{}",jedis.pexpire("user", 100l));
		logger.info("{}",jedis.pexpireAt("user", 200));
		logger.info("{}",jedis.pttl("user"));
		logger.info("{}",jedis.randomKey());
		logger.info("{}",jedis.rename("user", "user1"));
		logger.info("{}",jedis.renamenx("user", "user2"));
		logger.info("{}",jedis.restore("user", 1, "王五".getBytes()));
		logger.info("{}",jedis.sort("user"));
		logger.info("{}",jedis.ttl("user"));
		logger.info("{}",jedis.type("user"));
		logger.info("{}",jedis.scan("user"));
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
	
	@Test
	public void testHash(){
		Jedis jedis = JedisUtil.getJedis();
		logger.info("{}",jedis.hdel("user"));
		logger.info("{}",jedis.hexists("user", "name"));
		logger.info("{}",jedis.hget("user", "name"));
		logger.info("{}",jedis.hgetAll("user")); //
		logger.info("{}",jedis.hincrBy("user", "name", 100));
		logger.info("{}",jedis.hincrByFloat("user", "name", 100));
		logger.info("{}",jedis.hkeys("user"));
		logger.info("{}",jedis.hlen("user"));
		logger.info("{}",jedis.hmget("user", "name"));
		logger.info("{}",jedis.hmset("user", new HashMap<>()));
		logger.info("{}",jedis.hset("user", "name", "张三"));
		logger.info("{}",jedis.hsetnx("user", "name", "张三"));
		logger.info("{}",jedis.hvals("user"));
		logger.info("{}",jedis.hscan("user", "1"));
	}
	
	@Test
	public void testList(){
		Jedis jedis = JedisUtil.getJedis();
		logger.info("{}",jedis.blpop(1000, "user"));
		logger.info("{}",jedis.brpop("user", "name"));
		logger.info("{}",jedis.brpoplpush("user", "name", 6000));
		logger.info("{}",jedis.lindex("user", 1)); //
		logger.info("{}",jedis.linsert("user", LIST_POSITION.AFTER, "a", "b"));
		logger.info("{}",jedis.llen("user"));
		logger.info("{}",jedis.lpop("user"));
		logger.info("{}",jedis.lpush("user"));
		logger.info("{}",jedis.lpushx("user", "name"));
		logger.info("{}",jedis.lrange("user", 0, 1));
		logger.info("{}",jedis.lrem("user", 1, "张三"));
		logger.info("{}",jedis.lset("user", 1, "张三"));
		logger.info("{}",jedis.ltrim("user", 0, 1));
		logger.info("{}",jedis.rpop("user"));
		logger.info("{}",jedis.rpoplpush("user", "1"));
		logger.info("{}",jedis.rpush("user", "1"));
		logger.info("{}",jedis.rpushx("user", "1"));
	}    
	
	@Test
	public void testSet(){
		Jedis jedis = JedisUtil.getJedis();
		logger.info("{}",jedis.sadd("user", "name"));
		logger.info("{}",jedis.scard("user"));
		logger.info("{}",jedis.sdiff("user", "name"));
		logger.info("{}",jedis.sdiffstore("user", "name"));
		logger.info("{}",jedis.sinter("user", "name"));
		logger.info("{}",jedis.sinterstore("user", "name"));
		logger.info("{}",jedis.sismember("user", "name"));
		logger.info("{}",jedis.smembers("user"));
		logger.info("{}",jedis.smove("user", "user1", "user2"));
		logger.info("{}",jedis.spop("user"));
		logger.info("{}",jedis.srandmember("user"));
		logger.info("{}",jedis.srem("user", "name"));
		logger.info("{}",jedis.sunion("user", "name"));
		logger.info("{}",jedis.sunionstore("user", "name"));
		logger.info("{}",jedis.sscan("user", "name"));
	}  
	
	@Test
	public void testSortedSet(){
		Jedis jedis = JedisUtil.getJedis();
		logger.info("{}",jedis.zadd("user", new HashMap<>()));
		logger.info("{}",jedis.zcard("user"));
		logger.info("{}",jedis.zcount("user", 1, 2));
		logger.info("{}",jedis.zincrby("user", 1, "name"));
		logger.info("{}",jedis.zrange("user", 1, 2));
		logger.info("{}",jedis.zrangeByScore("user", 1, 2));
		logger.info("{}",jedis.zrank("user", "name"));
		logger.info("{}",jedis.zrem("user", "name"));
		logger.info("{}",jedis.zremrangeByRank("user", 1, 2));
		logger.info("{}",jedis.zremrangeByScore("user", 1, 2));
		logger.info("{}",jedis.zrevrange("user", 1, 2));
		logger.info("{}",jedis.zrevrangeByScore("user", 1, 2));
		logger.info("{}",jedis.zrevrank("user", "name"));
		logger.info("{}",jedis.zscore("user", "name"));
		logger.info("{}",jedis.zunionstore("user", "name"));
		logger.info("{}",jedis.zinterstore("user", "name"));
		logger.info("{}",jedis.zscan("user", "name"));
	}   
	
	@Test
	public void testPubSub(){
		Jedis jedis = JedisUtil.getJedis();
		jedis.psubscribe(new JedisPubSub() {}, "");
		logger.info("{}",jedis.publish("user", "name"));
		logger.info("{}",jedis.pubsubChannels("user"));
		logger.info("{}",jedis.pubsubNumSub("user"));
		jedis.subscribe(new JedisPubSub() {}, "user");
		jedis.psubscribe(new JedisPubSub() {}, "user");
	}
	
	@Test
	public void testTransaction(){
		Jedis jedis = JedisUtil.getJedis();
		logger.info("{}",jedis.multi());
		logger.info("{}",jedis.unwatch());
		logger.info("{}",jedis.watch("user"));
	}  
	
	@Test
	public void testScript(){
		Jedis jedis = JedisUtil.getJedis();
		logger.info("{}",jedis.eval("user"));
		logger.info("{}",jedis.evalsha("user"));
		logger.info("{}",jedis.scriptExists("user"));
		logger.info("{}",jedis.scriptFlush());
		logger.info("{}",jedis.scriptKill());
		logger.info("{}",jedis.scriptLoad("user"));
	}

	@Test
	public void testConnection(){
		Jedis jedis = JedisUtil.getJedis();
		logger.info("{}",jedis.auth("user"));
		logger.info("{}",jedis.echo("user"));
		logger.info("{}",jedis.ping());
		logger.info("{}",jedis.quit());
		logger.info("{}",jedis.select(0));
	}   
	
	@Test
	public void testServer(){
		Jedis jedis = JedisUtil.getJedis();
		logger.info("{}",jedis.bgrewriteaof());
		logger.info("{}",jedis.bgsave());
		logger.info("{}",jedis.clientGetname());
		logger.info("{}",jedis.clientKill("user"));
		logger.info("{}",jedis.clientList());
		logger.info("{}",jedis.clientSetname("user"));
		logger.info("{}",jedis.configGet("user"));
		logger.info("{}",jedis.configResetStat());
		logger.info("{}",jedis.bgrewriteaof());
		logger.info("{}",jedis.configSet("user", "name"));
		logger.info("{}",jedis.debug(DebugParams.RELOAD()));
		logger.info("{}",jedis.flushAll());
		logger.info("{}",jedis.flushDB());
		logger.info("{}",jedis.info());
		logger.info("{}",jedis.lastsave());
		jedis.monitor(new JedisMonitor() {
			@Override
			public void onCommand(String command) {
				
			}
		});
		jedis.sync();
		logger.info("{}",jedis.save());
		logger.info("{}",jedis.shutdown());
		logger.info("{}",jedis.slaveof("127.0.0.1", 8080));
		logger.info("{}",jedis.slowlogGet());
		logger.info("{}",jedis.time());
	}
}                                  
                                   