package com.medium.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCPN {

  static List<List<Character>> numberToChars = new ArrayList<>();
  static {
    numberToChars.add(0, null);
    numberToChars.add(1, null);
    numberToChars.add(2, Arrays.asList('a', 'b', 'c'));
    numberToChars.add(3, Arrays.asList('d', 'e', 'f'));
    numberToChars.add(4, Arrays.asList('g', 'h', 'i'));
    numberToChars.add(5, Arrays.asList('j', 'k', 'l'));
    numberToChars.add(6, Arrays.asList('m', 'n', 'o'));
    numberToChars.add(7, Arrays.asList('p', 'q', 'r', 's'));
    numberToChars.add(8, Arrays.asList('t', 'u', 'v'));
    numberToChars.add(9, Arrays.asList('w', 'x', 'y', 'z'));
  }

  public static void main(String[] args) {

  }

  public List<String> letterCombinations(String digits) {
    if(digits.isEmpty()){
      return new ArrayList<>();
    }

    List<String> result = new ArrayList<>();
    letterCombinationsUtils(digits, 0, "", result);
    return result;
  }

  public void letterCombinationsUtils(String digits, int i, String str, List<String> result) {
    if(i>=digits.length()){
      result.add(str);
      return;
    }

    List<Character> list = numberToChars.get(digits.charAt(i)-'0');
    for (Character c : list) {
      letterCombinationsUtils(digits, i+1, str+c, result);
    }
  }
}
