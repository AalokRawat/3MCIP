package com.algorithm.sorting;

public class MergeSort {
  public static void main(String[] args) {
    int[] arr = {3, 5, 2, 6, 8, 1, 7, 9, 6};
    sort(arr,0 , arr.length-1);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " , ");
    }
  }

  static void sort(int[] arr, int i, int j) {
    if(i>=j){
      return;
    }
    if(i+1==j && (arr[i]>arr[j])){
      swap(arr,i,j);
      return;
    }

    int mid = (i+j)/2;
    sort(arr, i, mid);
    sort(arr,mid+1, j);
    merge(arr, i, mid, j);
  }

  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  static void merge(int[] arr, int i, int mid, int j) {
    int x = i;
    int y = mid+1;
    int[] arr1 = new int[j-i+1];
    int z=0;
    while(x<=mid && y<=j) {
      if(arr[x]<=arr[y]){
        arr1[z]=arr[x];
        x++;
      } else {
        arr1[z]=arr[y];
        y++;
      }
      z++;
    }
    if(x<=mid) {
      for (int i1=x; i1<=mid; i1++) {
        arr1[z]=arr[i1];
        z++;
      }
    }

    if(y<=j) {
      for (int i1=y; i1<=j; i1++) {
        arr1[z]=arr[i1];
        z++;
      }
    }
    z=0;
    while(i<=j) {
      arr[i++]=arr1[z++];
    }
  }
}
