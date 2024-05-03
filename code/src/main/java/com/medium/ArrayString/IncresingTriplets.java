package com.medium.ArrayString;

public class IncresingTriplets {

  public static void main(String[] args) {
    int[] nums = {20,100,10,12,5,13};
    System.out.println(new IncresingTriplets().increasingTriplet(nums));
  }

  public boolean increasingTriplet(int[] nums) {
    int vali = Integer.MAX_VALUE, valj = Integer.MAX_VALUE;
    for (int num : nums) {
      if (num<vali) {
        vali = num;
      }
      if(num>vali) {
        valj = Math.min(valj, num);
      }
      if(num>valj) {
        return true;
      }
    }
    return false;
  }
}
