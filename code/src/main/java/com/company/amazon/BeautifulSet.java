package com.company.amazon;

import java.util.Arrays;

public class BeautifulSet {

  public static void main(String[] args) {
    System.out.println("Expected: 1, Actual: " + minimumCoinFlips("HTHTTT"));
    System.out.println("Expected: 2, Actual: " + minimumCoinFlips("THHTTTH"));
    System.out.println("Expected: 2, Actual: " + minimumCoinFlips("HHHTHTH"));
    System.out.println("Expected: 0, Actual: " + minimumCoinFlips("HHHHTT"));
    // edge conditions
    System.out.println("Expected: 0, Actual: " + minimumCoinFlips("H"));
    System.out.println("Expected: 0, Actual: " + minimumCoinFlips("T"));
    System.out.println("Expected: 1, Actual: " + minimumCoinFlips("TTTTTHTTTT"));

  }

  public static int minimumCoinFlips(String coins) {
    int start=0;
    int end=coins.length()-1;
    int totalHead=0, totalTails=0;
    int count=0;

    for (char coin : coins.toCharArray()) {
      if(coin=='H') {
        totalHead++;
      }
    }
    totalTails = coins.length()-totalHead;

    while(start<end){
      while(start<coins.length() && coins.charAt(start)=='H'){
        start++;
      }
      while(end>=0 && coins.charAt(end)=='T'){
        end--;
      }
      if(start+1==end) {
        count++;
      } else if (start<end) {
        count+=2;
      }
      start++;
      end--;
    }
    return Math.min(count, Math.min(totalHead, totalTails));
  }
}
