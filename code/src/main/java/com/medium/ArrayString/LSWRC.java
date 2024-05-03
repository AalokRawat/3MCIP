package com.medium.ArrayString;

import java.util.HashMap;

public class LSWRC {
  public static void main(String[] args) {
    System.out.println(new LSWRC().lengthOfLongestSubstring("dvdf"));
  }

  public int lengthOfLongestSubstring(String s) {
    char[] letters = s.toCharArray();
    HashMap<Character, Integer> map = new HashMap<>();

    if (letters.length==1){
      return 1;
    }

    int i=0,j=0, max=0;
    while(j<letters.length){
      if(map.containsKey(letters[j])){
        if(max<j-i)
          max=j-i;
        i=map.get(letters[j])+1;
        j=i;
        map.clear();
      }
      map.put(letters[j], j);
      j++;
    }

    if(max<j-i)
      max=j-i;

    return max;
  }
}
