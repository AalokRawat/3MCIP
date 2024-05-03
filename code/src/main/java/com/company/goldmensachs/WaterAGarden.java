package com.company.goldmensachs;

public class WaterAGarden {
  public static void main(String[] args) {
  }

  static int minTaps(int n, int[] ranges) {
    int[] finalRange = new int[n + 1];
    int start = 0;
    for (int i = 0; i <= n; i++) {
      start = Math.max(0, i - ranges[i]);
      finalRange[start] = Math.max(finalRange[i], i + ranges[i]);
    }

    int till = 0;
    int maxReachSoFar = 0;
    int count = 0;
    for (int i = 0; i <= n; i++) {
      till = Math.max(till, finalRange[i]);
      if (i == maxReachSoFar) {
        count++;
        maxReachSoFar = till;
        if (maxReachSoFar >= n) {
          return count;
        }
      }
    }
    return maxReachSoFar >= n ? count : -1;
  }
}