package com.algorithm.shortestpath;

class AllPairShortestPath {
    void floydWarshall(int[][] dist, int V) {
        for(int k=0; k<V; k++) {
            for(int i=0; i<V; i++) {
                for(int j=0; j<V; j++) {
                    if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }
        print(dist, V);
    }

    void print(int[][] dist, int V) {
        for(int i=0; i<V; i++) {
            for(int j=0; j<V; j++) {
                if(dist[i][j]==Integer.MAX_VALUE)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int graph[][] = { { 0, 5, Integer.MAX_VALUE, 10 },
                { Integer.MAX_VALUE, 0, 3, Integer.MAX_VALUE },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1 },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0 } };
        AllPairShortestPath a = new AllPairShortestPath();
        a.floydWarshall(graph, 4);
    }
}

