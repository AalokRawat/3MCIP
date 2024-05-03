package com.company.oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SumOfDistanceInTree {

    static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        map.put(0, new ArrayList<>());
        map.put(1, new ArrayList<>());
        map.put(2, new ArrayList<>());
        map.put(3, new ArrayList<>());
        map.put(4, new ArrayList<>());
        map.put(5, new ArrayList<>());

        map.get(0).add(1);
        map.get(1).add(0);

        map.get(0).add(2);
        map.get(2).add(0);

        map.get(2).add(3);
        map.get(3).add(2);
        map.get(2).add(4);
        map.get(4).add(2);
        map.get(2).add(5);
        map.get(5).add(2);

        for(int i=0; i<6; i++) {
            System.out.println(dist(i, new HashSet<>(), 0));
        }
    }

    static int dist(Integer i, Set<Integer> visited, int count) {
        if(visited.contains(i)) {
            return 0;
        } else {
            visited.add(i);
        }

        int sol=0;
        for(Integer v : map.get(i)) {
            sol += dist(v, visited, count+1);
        }
        sol+=count;
        return sol;
    }
}