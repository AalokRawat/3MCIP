package com.medium.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

  public static void main(String[] args) {

  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> lists = new ArrayList<>();
    permuteUtils(nums, 0, nums.length-1, lists);
    return lists;
  }

  void permuteUtils(int[] nums, int i, int j, List<List<Integer>> lists) {
    if (i == j) {
      lists.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
      return;
    }

    for (int k = i; k <= j; k++) {
      swap(nums, i, k);
      permuteUtils(nums, i+1, j, lists);
      swap(nums, i, k);
    }
  }

  void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
