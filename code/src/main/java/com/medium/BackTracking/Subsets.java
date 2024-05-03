package com.medium.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

  public static void main(String[] args) {
    int[] nums = {1,2,3};
    System.out.println(new Subsets().subsets(nums));
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> lists = new ArrayList<>();
    subsetsUtils(nums, 0, new ArrayList<>(), lists);
    return lists;
  }

  void subsetsUtils(int[] nums, int i, List<Integer> list, List<List<Integer>> lists) {
    if(i==nums.length){
      lists.add(new ArrayList<>(list));
      return;
    }

    subsetsUtils(nums, i+1, list, lists);
    list.add(nums[i]);
    subsetsUtils(nums, i+1, list, lists);
    list.remove(list.indexOf(nums[i]));
  }
}
