package com.company.thoughtspot;

import java.util.ArrayList;
import java.util.List;

public class ProblemSnakeAndLadder {

    static int[][] board = {{-1, -1, -1, -1, -1, -1},
                     {-1, -1, -1, 5, -1, -1},
                     {-1, -1, -1, -1, -1, -1},
                     {-1, 38, -1, 13, -1, -1},
                     {-1, -1, -1, -1, -1, -1},
                     {-1, -1, -1, -1, -1, -1},
                     {-1, 15, -1, 8, -1, -1}};

    public static void main(String[] args) {
        System.out.println(new SnakeAndLadder().findMin(board));
    }
}

class SnakeAndLadder {
    int[] grid;

    int findMin(int[][] board) {
        grid = new int[board.length * board[0].length];
        int row=0;
        int gridIndex=0;
        for(int i=board.length-1; i>=0; i--) {
            if(row++%2==0) {
                for(int j=0; j<board[0].length; j++) {
                    grid[gridIndex++]=board[i][j];
                }
            } else {
                for(int j=board[0].length-1; j>=0; j--) {
                    grid[gridIndex++]=board[i][j];
                }
            }
        }

        boolean[] visited = new boolean[grid.length];
        Graph g = new Graph();
        g.add(new Vertex(0, 0));

        while(!g.isEmpty()) {
            Vertex v = g.pop();

            if(v.i==grid.length-1) {
                return v.dist;
            }

            visited[v.i]=true;
            for(int i=1; i<=6; i++) {
                int vertex = v.i+i;
                if(vertex>=grid.length) {
                    break;
                }
                if(grid[vertex]!=-1) {
                    vertex = grid[vertex];
                }
                if(!visited[vertex]) {
                    g.add(new Vertex(vertex, v.dist+1));
                }
            }
        }
        return -1;
    }

    class Graph {
        List<Vertex> graphList;

        public Graph() {
            this.graphList = new ArrayList<>();
        }

        public void add(Vertex v) {
            graphList.add(v);
        }

        public Vertex pop() {
            return graphList.remove(0);
        }

        public boolean isEmpty() {
            return graphList.isEmpty();
        }
    }

    class Vertex {
        int i;
        int dist;

        public Vertex(int i, int dist) {
            this.i = i;
            this.dist = dist;
        }
    }
}
