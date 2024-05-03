package com.wss;

import java.util.HashMap;
import java.util.Map;

public class InMemory {
    Map<String, String> map;

    public InMemory() {
        map = new HashMap<>();
    }

    public InMemory(InMemory memory) {
        map = new HashMap<>();
        map.putAll(memory.map);
    }

    public void write(String key, String value) {
        map.put(key, value);
    }

    public String read(String key) {
        String value = map.get(key);
        if (null == value) {
            throw new RuntimeException("Key not found");
        }
        return value;
    }

    public void delete(String key) {
        map.put(key, null);
    }
}
