package com.medium.SortingSearching;

public class SortColors {
  public static void main(String[] args) {
    int[] nums = {2,0,2,1,1,0,1,0,2};
    new SortColors().sortColors(nums);
  }

  public void sortColors(int[] nums) {
    int[] index = {-1, -1, -1};
    int[] count = {0, 0, 0};

    index[nums[0]]=0;
    count[nums[0]]++;
    for ( int i=1; i<nums.length; i++) {
      index[nums[i]]=i;
      count[nums[i]]++;
      if(nums[i]<nums[i-1]) {
        sort(index, nums, count);
      }
    }
  }

  void sort(int[] index, int[] nums, int[] count) {
    for ( int i=0; i<index.length; i++) {
      for ( int j=i+1; j<index.length; j++) {
        if(index[i]!=-1 && index[j]!=-1 && index[i]>index[j]) {
          swap(nums, index[i], index[j]-count[j]+1);
          int temp = index[j]-count[j]+1;
          index[j] = index [i];
          index[i] = temp;
        }
      }
    }
  }

  void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
