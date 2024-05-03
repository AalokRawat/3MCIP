package com.company.walmart;

//TODO
public class MinCostGraph {
  public static void main(String[] args) {
    int city1[][] = {
        {0, 1, 2, 3, 4},
        {1, 0, 5, 0, 7},
        {2, 5, 0, 6, 0},
        {3, 0, 6, 0, 0},
        {4, 7, 0, 0, 0}};
    System.out.println(find(city1));
  }

  static int find(int[][] arr) {
    boolean[] visited = new boolean[arr.length];
    visited[0] = true;
    return findUtils(arr, 0, visited);
  }

  static int findUtils(int[][] arr, int i, boolean[] visited) {
    if(allVisited(visited)) {
      return 0;
    }
    int minCost = 1000;
    for(int j = 0; j < arr.length; j++) {
      if(visited[j]==false && arr[i][j]!=0) {
        visited[j]=true;
        minCost = Math.min(minCost,arr[i][j] + findUtils(arr, j, visited));
        visited[j]=false;
      }
    }
    return minCost;
  }

  static boolean allVisited(boolean[] visited) {
    for(int i=0; i< visited.length; i++) {
      if(!visited[i]) {
        return false;
      }
    }
    return true;
  }
}
