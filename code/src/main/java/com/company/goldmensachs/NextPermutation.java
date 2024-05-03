package com.company.goldmensachs;

import java.util.Arrays;

public class NextPermutation {
  public static void main(String[] args) {
  }

  public void nextPermutation(int[] nums) {
    int[] twoMaxI = findTwoMax(nums);
    if(twoMaxI[0]>twoMaxI[1]) {
      reverse(nums);
    } else {
      swap(nums, twoMaxI[0], twoMaxI[1]);
    }
  }

  int[] findTwoMax(int[] nums) {
    int max = -1, maxI=0;
    int secondMax = -1, secondMaxI=0;
    for(int i=0; i<nums.length; i++) {
      if(max<nums[i]) {
        secondMax = max;
        secondMaxI = maxI;
        max = nums[i];
        maxI = i;
      }
    }
    return new int[] {maxI, secondMaxI};
  }

  void reverse(int[] nums) {
    int i = 0, j = nums.length-1;
    while (i++<j--) {
      swap(nums, i, j);
    }
  }

  void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
