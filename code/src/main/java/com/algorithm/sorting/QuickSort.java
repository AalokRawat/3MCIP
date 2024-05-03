package com.algorithm.sorting;

public class QuickSort {
  public static void main(String[] args) {
    int[] arr = {3, 5, 2, 6, 8, 1, 7, 9, 6};
    sort(arr, 0, arr.length-1);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " , ");
    }
  }

  static void sort(int[] arr, int i, int j) {
    if(i>=j){
      return;
    }

    int pi = partition(arr, i, j);
    sort(arr, i, pi-1);
    sort(arr, pi+1, j);
  }

  static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int pIndex = low-1;

    for (int i=low; i< high; i++) {
      if(arr[i]<pivot) {
        pIndex++;
        swap(arr, pIndex, i);
      }
    }
    swap(arr, pIndex+1, high);
    return pIndex+1;
  }

  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
