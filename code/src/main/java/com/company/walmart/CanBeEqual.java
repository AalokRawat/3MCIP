package com.company.walmart;

public class CanBeEqual {
  public static void main(String[] args) {
    System.out.println(check("SEEKSFORGEEKS", "GEEKSFORGEEKG"));
  }

  static boolean check(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }
    int i = 0, i1 = -1, i2 = -1;
    while (i < str1.length()) {
      if (str1.charAt(i) != str2.charAt(i)) {
        if (i1 < 0) {
          i1 = i;
        } else if (i2 < 0) {
          i2 = i;
        } else {
          return false;
        }
      }
      i++;
    }
    if(str1.charAt(i1)==str1.charAt(i2) && str2.charAt(i1)==str2.charAt(i2)) {
      return true;
    }
    return false;
  }
}
