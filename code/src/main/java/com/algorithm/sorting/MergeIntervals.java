package com.algorithm.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        List<Interval> list = new ArrayList<>();
        for (int i=0; i<intervals.length; i++) {
            list.add(new Interval(intervals[i][0], true));
            list.add(new Interval(intervals[i][1], false));
        }
        Collections.sort(list, Comparator.comparingInt(o -> o.value));

        list = removeRepetative(list);

        List<List<Integer>> sol = new ArrayList<>();
        int start = list.get(0).value;
        int count = 1;
        for ( int i = 1; i< list.size(); i++) {
            if (list.get(i).start) {
                if(count ==0)
                    start = list.get(i).value;
                count++;
            } else {
                count--;
            }
            if(count==0) {
                sol.add(Arrays.asList(start, list.get(i).value));
            }
        }

        int[][] sols = new int[sol.size()][2];
        int j = 0;
        for (List<Integer> val : sol) {
            sols[j][0] = val.get(0);
            sols[j++][1] = val.get(1);
        }
        return sols;
    }

    List<Interval> removeRepetative(List<Interval> list) {
        List<Integer> repeated = new ArrayList<>();
        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i).value == list.get(i+1).value) {
                repeated.add(list.get(i).value);
            }
        }
        list.removeIf(interval -> repeated.contains(interval.value));
        return list;
    }
}

class Interval {
    int value;
    boolean start;

    public Interval(int value, boolean start) {
        this.value = value;
        this.start = start;
    }
}