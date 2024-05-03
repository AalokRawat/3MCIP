package com.algorithm.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFord {
    Graph graph;
    int n;

    BellmanFord(Graph graph) {
        this.graph = graph;
        this.n = graph.n;
    }

    void calculateShortestPath(int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;

        for(int i=1; i<n; i++) {
            for(int j=0; j<n; j++) {
                for(Vertex vertex : graph.getNeighbour(j)) {
                    int u = j;
                    int v = vertex.getToVertex();
                    int weight = vertex.getWeight();

                    if(dist[u]!=Integer.MAX_VALUE && dist[v]> dist[u]+weight) {
                        dist[v] = dist[u]+weight;
                    }
                }
            }
        }

        for(int j=0; j<n; j++) {
            for(Vertex vertex : graph.getNeighbour(j)) {
                int u = j;
                int v = vertex.getToVertex();
                int weight = vertex.getWeight();

                if(dist[u]!=Integer.MAX_VALUE && dist[v]> dist[u]+weight) {
                    System.out.println(
                            "Graph contains negative weight cycle");
                    return;
                }
            }
        }

        for (int i=0; i<n; i++) {
            System.out.print(dist[i] +" ");
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1, -1);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 2);
        g.addEdge(1, 4, 2);
        g.addEdge(3, 2, 5);
        g.addEdge(3, 1, 1);
        g.addEdge(4, 3, -3);

        BellmanFord bf = new BellmanFord(g);
        bf.calculateShortestPath(0);
    }
}

class Graph {
    private List<List<Vertex>> vertices = new ArrayList<>();
    int n;

    Graph(int n) {
        this.n = n;
        for(int i=0; i<n; i++) {
            vertices.add(new ArrayList());
        }
    }

    public void addEdge(int u, int v, int weight) {
        getNeighbour(u).add(new Vertex(v, weight));
    }

    public List<Vertex> getNeighbour(int vertex) {
        return vertices.get(vertex);
    }
}

class Vertex {
    private int toVertex;
    private int weight;

    Vertex(int toVertex, int weight) {
        this.toVertex = toVertex;
        this.weight = weight;
    }

    public int getToVertex() {
        return toVertex;
    }

    public int getWeight() {
        return weight;
    }
}

