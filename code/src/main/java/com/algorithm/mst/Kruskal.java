package com.algorithm.mst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kruskal {

    public static void main(String[] args) {
        int n=4;

        List<Edge<Integer>> edges = new ArrayList<>(List.of(
                new Edge<>(0, 1, 10),
                new Edge<>(0, 2, 6),
                new Edge<>(0, 3, 5),
                new Edge<>(1, 3, 15),
                new Edge<>(2, 3, 4)));

        edges = new Kruskal().execute(edges, n);

        for(Edge<Integer> edge : edges) {
            System.out.println(edge.toString());
        }

    }
    int[] parent;
    public <T extends Number> List<Edge<T>> execute(List<Edge<T>> edges, int n) {
        edges.sort(Comparator.comparingInt(a -> a.weight().intValue()));

        parent = new int[n];
        for(int i=0; i<n; i++)
            parent[i]=i;

        List<Edge<T>> mst = new ArrayList<>();
        for(Edge<T> edge : edges) {
            if(union(edge.u(), edge.v())) {
                mst.add(edge);
            }
        }
        return mst;
    }

    private boolean union(int u, int v) {
        u = find(u);
        v = find(v);

        if(u<v) {
            parent[v]=u;
        } else if(v<u) {
            parent[u]=v;
        } else {
            return false;
        }
        return true;
     }

     private int find(int v) {
        if(v!=parent[v]) {
            parent[v]=find(parent[v]);
        }
        return parent[v];
     }
}

record Edge<T extends Number>(int u, int v, T weight) {
}