package com.company.amazon;

import java.util.ArrayList;
import java.util.List;

public class SortedBinary {
  public static void main(String[] args) {
    
  }

  static int minSwap(List<Integer> list) {
    List<Integer> list1 = new ArrayList<>();
    list1.addAll(list);
    int start=0;
    int end=list1.size();
    int zeroFirst=0;
    while(start<end){
      if(list1.get(start)==0) {
        int i=start-1;
        while(i>=0 && list1.get(i)==1) {
          zeroFirst++;
        }
        swap(list1, i, start);
        start++;
      }
    }

    start=0;
    int oneFirst=0;
    while(start<end){
      if(list1.get(start)==1) {
        int i=start-1;
        while(i>=0 && list1.get(i)==0) {
          oneFirst++;
        }
        swap(list1, i, start);
        start++;
      }
    }
    return Math.min(zeroFirst, oneFirst);
  }

  static void swap(List<Integer> list, int i, int j) {
    int temp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, temp);
  }
}
