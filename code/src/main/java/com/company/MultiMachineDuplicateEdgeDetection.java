package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class MultiMachineDuplicateEdgeDetection {

    public static void main(String[] args) {
        int[][] edges = new int [1000][2];
        Random r = new Random();
        for(int i=0; i<1000; i++) {
            edges[i][0] = r.nextInt(4800, 5001);
            edges[i][1] = r.nextInt(4800, 5001);
            System.out.println(edges[i][0] + " " + edges[i][1]);
        }

        Master master = new Master();
        System.out.println(master.findDuplicateEdges(edges));
    }
}

class Master {

    Map<String, Machine> machines = new HashMap();

    int findDuplicateEdges(int[][] edges) {

        Arrays.sort(edges, (a, b) -> {
            if(a[0]!=b[0]) return a[0]-b[0]; else return a[1]-b[1];
        });

        for(int i=0; i<10; i++) {
            machines.put(edges[100*i][0]+"_"+edges[i*100+99][1], new Machine());
            for(int j=100*i; j<=(100*i+99); j++) {
                machines.get(edges[100*i][0]+"_"+edges[i*100+99][1]).addEdge(edges[j][0], edges[j][1]);
            }
        }

        int duplicateCount=0;
        for(int[] edge : edges) {
            int[] reverseEdge = getReverseEdge(edge);
            for(Map.Entry<String, Machine> entry : machines.entrySet()) {
                if(inRange(entry.getKey(), reverseEdge) && containsEdge(entry.getValue(), reverseEdge)) {
                    System.out.println(edge[0] + " " + edge[1]);
                    duplicateCount++;
                }
            }
        }
        return duplicateCount*2;
    }

    private int[] getReverseEdge(int[] edge) {
        int[] reverseEdge = new int[2];
        reverseEdge[0] = edge[1];
        reverseEdge[1] = edge[0];
        return reverseEdge;
    }

    boolean inRange(String key, int[] edge) {
        int fromEdge = edge[0];
        int toEdge = edge[1];

        String[] range = key.split("_");
        int startRange = Integer.parseInt(range[0]);
        int endRange = Integer.parseInt(range[1]);

        if(startRange>=fromEdge && endRange<=toEdge) {
            return true;
        }
        return false;
    }

    boolean containsEdge(Machine machine, int[] edge) {
        return machine.contains(edge[0], edge[1]);
    }
}


class Machine {
    private final Map<Integer, Set<Integer>> map = new HashMap<>();

    void addEdge(int fromEdge, int toEdge) {
        map.computeIfAbsent(fromEdge, k -> new HashSet<>());
        map.get(fromEdge).add(toEdge);
    }

    boolean contains(int fromEdge, int toEdge) {
        return map.containsKey(fromEdge) && map.get(fromEdge).contains(toEdge);
    }
}
