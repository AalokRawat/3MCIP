package com.medium.ArrayString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
  public static void main(String[] args) {
    String[] strs = {"eat","tea","tan","ate","nat","bat"};
    new GroupAnagrams().groupAnagrams(strs);
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> map = new HashMap<>();
    for(String str : strs){
      char[] word = str.toCharArray();
      Arrays.sort(word);
      String key = String.valueOf(word);
      if(!map.containsKey(key)){
        map.put(key, new ArrayList<>());
      }
      map.get(key).add(str);
    }

    List<List<String>> sols = new ArrayList<>();

    for(String key : map.keySet()){
      sols.add(map.get(key));
    }
    return sols;
  }
}
