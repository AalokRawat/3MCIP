package com.algorithm.sorting;

public class SelectionSort {
  public static void main(String[] args) {
    int[] arr = {3, 5, 2, 6, 8, 1, 7, 9, 6};
    sort(arr);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " , ");
    }
  }

  static void sort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int j = findMinIndex(arr, i);
      swap(arr, i, j);
    }
  }

  static int findMinIndex(int[] arr, int start) {
    int min = Integer.MAX_VALUE;
    int minIndex = 0;
    for (int i = start; i < arr.length; i++) {
      if (min > arr[i]) {
        min = arr[i];
        minIndex = i;
      }
    }
    return minIndex;
  }

  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
