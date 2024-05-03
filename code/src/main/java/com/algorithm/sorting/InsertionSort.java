package com.algorithm.sorting;

public class InsertionSort {
  public static void main(String[] args) {
    int[] arr = {3, 5, 2, 6, 8, 1, 7, 9, 6};
    sort(arr);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " , ");
    }
  }

  static void sort(int[] arr) {
    for(int i=1;i<arr.length;i++) {
      int j = findInsertionIndex(arr, i);
      swapAndInsert(arr, i ,j);
    }
  }

  static int findInsertionIndex(int[] arr, int start) {
    int i = start-1;
    while(i>=0) {
      if(arr[start]<arr[i]){
        i--;
      } else {
        break;
      }
    }
    return i+1;
  }

  static void swapAndInsert(int[] arr, int i, int j) {
    if(i==j){
      return;
    }
    int temp = arr[i];
    for (int k = i; k>j; k--) {
      arr[k]=arr[k-1];
    }
    arr[j]=temp;
  }
}
