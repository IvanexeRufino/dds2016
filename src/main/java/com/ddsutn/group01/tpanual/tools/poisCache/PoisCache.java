package com.ddsutn.group01.tpanual.tools.poisCache;

import redis.clients.jedis.Jedis;

import java.util.HashMap;

public class PoisCache {
    private Jedis jedis = new Jedis("localhost");

    public String get(String searchText, HashMap<String, String> map) {
        if (this.cacheado(map.toString(), searchText)) {
            return jedis.hget(map.toString(), searchText);
        } else {
            return "";
        }
    }

    public Boolean cacheado(String map, String searchText) {
        return jedis.hexists(map, searchText);
    }

    public void put(String searchText, String results, HashMap<String, String> map) {
        jedis.hset(map.toString(), searchText, results);
        jedis.expire(map.toString(), 60);
    }

}
