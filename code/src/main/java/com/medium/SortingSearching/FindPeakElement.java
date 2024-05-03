package com.medium.SortingSearching;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
      return fpeUtils(nums, 0, nums.length-1);
    }

    int fpeUtils(int[] nums, int i, int j) {
      if (i>j) {
        return -1;
      }

      int mid = (i+j)/2;
      if ( (mid==0 || nums[mid] > nums[mid-1]) && ( mid== nums.length-1 || nums[mid] > nums[mid+1]) ) {
        return mid;
      }

      int index = fpeUtils(nums, i, mid-1);
      if (index==-1)
        index = fpeUtils(nums, mid+1, j);
      return index;
    }
}
