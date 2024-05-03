package com.algorithm.sorting;

public class HeapSort {
  public static void main(String[] args) {
    int[] arr = {3, 5, 2, 6, 8, 1, 7, 9, 6};
    sort(arr);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " , ");
    }
  }

  static void sort(int[] arr) {
    int n = arr.length;
    for (int i=n/2-1; i>=0; i--){
      heapify(arr, n, i);
    }

    for(int i=n-1; i>=0; i--){
      swap(arr, 0, i);
      heapify(arr, i, 0);
    }
  }

  static void heapify(int[] arr, int n, int i) {
    int max=arr[i],index=i;
    if((i*2+1)<n && max<arr[i*2+1]) {
      max=arr[i*2+1];
      index=i*2+1;
    }
    if((i*2+2)<n && max<arr[i*2+2]) {
      max=arr[i*2+2];
      index=i*2+2;
    }
    if(max!=arr[i]) {
      swap(arr, i, index);
      heapify(arr, n, index);
    }
  }

  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
