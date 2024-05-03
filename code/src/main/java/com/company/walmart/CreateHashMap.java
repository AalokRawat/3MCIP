package com.company.walmart;

public class CreateHashMap {
  public static void main(String[] args) {
    MyMap map = new MyHashMap<Integer, String>();
    map.put(16, "Test");
    map.put(2, "Map");
    System.out.println(map.get(16));
    System.out.println(map.get(2));
  }
}

interface MyMap<U, V> {
  int DEFAULT_LENGTH = 16;

  void put(U key, V value);

  V get(U key);
}

class MyHashMap<U extends Object, V extends Object> implements MyMap<U, V> {
  Object[] map;

  public MyHashMap() {
    map = new Object[DEFAULT_LENGTH];
  }

  public void put(U key, V value) {
    int i = getHash(key);
    if (i < map.length) {
      map[i] = value;
    } else {
      map = newMap(map);
      map[i] = value;
    }
  }

  public V get(U key) {
    return (V) map[getHash(key)];
  }

  Object[] newMap(Object[] map) {
    Object[] newMap = new Object[map.length * 2];
    for (int i = 0; i < map.length; i++) {
      newMap[i] = map[i];
    }
    return newMap;
  }

  int getHash(U key) {
    return key.hashCode();
  }
}
