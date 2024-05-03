package com.algorithm.mst;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {
    private final int n;
    private final List<List<Pair<T>>> adjacentList = new ArrayList<>();

    public Graph(int n) {
        this.n = n;
        for(int i=0; i<n; i++) {
            adjacentList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, T weight) {
        adjacentList.get(u).add(new Pair<>(v, weight));
    }

    public List<Pair<T>> getNeighbours(int u) {
        return adjacentList.get(u);
    }

    public int getN() {
        return n;
    }
}

record Pair<T>(int vertex, T weight) {
}
