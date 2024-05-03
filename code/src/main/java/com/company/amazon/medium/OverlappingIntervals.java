package com.company.amazon.medium;

import java.util.Arrays;

public class OverlappingIntervals {

  public int[][] overlappedInterval(int[][] Intervals)
  {
    int x = Intervals.length;
    if(x==0) {
      return new int[0][0];
    }
    Arrays.sort(Intervals, (a, b) -> Integer.compare(a[0], b[0]));
    int i=0, j=0;

    while(i<x) {
      int y = i+1;
      Intervals[j][0]=Intervals[i][0];
      Intervals[j][1]=Intervals[i][1];
      while(y<x && Intervals[y][0]<=Intervals[j][1]) {
        if(Intervals[y][1] > Intervals[j][1]) {
          Intervals[j][1]=Intervals[y][1];
        }
        y++;
      }
      i=y;
      j++;
    }
    int[][] sol = new int[j][2];
    for(i=0; i<j; i++) {
      sol[i][0]=Intervals[i][0];
      sol[i][1]=Intervals[i][1];
    }
    return sol;
  }
}


