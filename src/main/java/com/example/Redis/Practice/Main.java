package com.example.Redis.Practice;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.ScanParams;
import redis.clients.jedis.resps.ScanResult;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    // get all keys and their values
    public static void main(String[] args) {
        // Connect to the Redis server
        Jedis jedis = new Jedis("localhost", 6379);

        // Authenticate if necessary
        // jedis.auth("yourpassword");

        String cursor = "0";
        ScanParams scanParams = new ScanParams().match("*").count(100);
        do {
            // Get a batch of keys
            ScanResult<String> scanResult = jedis.scan(cursor, scanParams);
            List<String> keys = scanResult.getResult();
            cursor = scanResult.getCursor();

            // Iterate over the keys and fetch their values
            for (String key : keys) {
                String type = jedis.type(key);
                System.out.println("Key: " + key + ", Type: " + type);

                switch (type) {
                    case "string" -> {
                        String stringValue = jedis.get(key);
                        System.out.println("Value: " + stringValue);
                    }
                    case "hash" -> {
                        Map<String, String> hashValue = jedis.hgetAll(key);
                        System.out.println("Value: " + hashValue);
                    }
                    case "list" -> {
                        List<String> listValue = jedis.lrange(key, 0, -1);
                        System.out.println("Value: " + listValue);
                    }
                    case "set" -> {
                        Set<String> setValue = jedis.smembers(key);
                        System.out.println("Value: " + setValue);
                    }
                    case "zset" -> {
                        Set<String> zsetValue = (Set<String>) jedis.zrange(key, 0, -1);
                        System.out.println("Value: " + zsetValue);
                    }
                    default -> System.out.println("Unknown type");
                }
                System.out.println();
            }
        } while (!"0".equals(cursor));

        // Close the connection
        jedis.close();
    }
}
