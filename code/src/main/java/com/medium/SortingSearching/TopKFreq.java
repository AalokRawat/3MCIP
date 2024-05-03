package com.medium.SortingSearching;

import java.util.*;

public class TopKFreq {

  public static void main(String[] args) {
    int[] nums = {1,1,1,2,2,3};
    new TopKFreq().topKFrequent(nums, 2);
  }

  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap();

    for (int num : nums) {
      map.put(num,map.getOrDefault(num,0)+1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
    for (Map.Entry entry : map.entrySet()) {
      priorityQueue.add(entry);
      if(priorityQueue.size()>k) {
        priorityQueue.poll();
      }
    }
    int[] sol = new int[k];
    while (k-->0) {
      sol[k] = priorityQueue.poll().getKey();
    }
    return sol;
  }
}
