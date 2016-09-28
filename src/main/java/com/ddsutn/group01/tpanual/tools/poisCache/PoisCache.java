package com.ddsutn.group01.tpanual.tools.poisCache;

import redis.clients.jedis.Jedis;

import java.util.List;

public class PoisCache {
    private Jedis jedis = new Jedis("localhost");

    public List<String> get(String searchText) {
        return jedis.lrange(searchText, 0, 10);
    }

    public void put(String key, List<String> results) {
        results.forEach(string -> jedis.lpush(key, string));
        jedis.expire(key, 60);
    }
}
