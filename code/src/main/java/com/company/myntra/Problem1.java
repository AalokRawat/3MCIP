package com.company.myntra;

public class Problem1 {
  public static void main(String[] args) {
    System.out.println(areaSum(4));
  }

  static int areaSum(int n) {
    int sum = 0;
    for (int i=-(n-1)/2; i<=(n-1)/2; i++) {
      for (int j=-(n-1)/2; j<=(n-1)/2; j++) {
        sum += Math.abs(i) + Math.abs(j);
      }
    }
    return sum;
  }
}
