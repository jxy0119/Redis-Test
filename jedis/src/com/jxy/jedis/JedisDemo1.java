package com.jxy.jedis;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;;

public class JedisDemo1 {
@Test
	
	
	public void demo1(){
		Jedis jedis = new Jedis("192.168.80.132",6379);
		jedis.set("name", "xiaoyu");
		String name = jedis.get("name");
		System.out.println(name);
		jedis.close();
	}

    @Test
    public void demo2(){
    	JedisPoolConfig config = new JedisPoolConfig();
    	config.setMaxTotal(30);
    	config.setMaxIdle(10);
    	JedisPool jedispool = new JedisPool(config,"192.168.80.132",6379);
    	Jedis jedis = null;
    	try{
    	      
    		  jedis = jedispool.getResource();
    		  jedis.set("name", "JXY");
    		  String name = jedis.get("name");
    		  System.out.print(name);
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		if(jedis!=null){
    		  jedis.close();
    		}
    		if(jedispool!=null){
    			jedispool.close();
    		}
    	}
    }
}
