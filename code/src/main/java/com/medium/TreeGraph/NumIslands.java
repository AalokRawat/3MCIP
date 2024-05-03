package com.medium.TreeGraph;

public class NumIslands {
  public static void main(String[] args) {

  }

  public int numIslands(char[][] grid) {
    int count = 0;
    for(int i=0; i< grid.length; i++) {
      for(int j=0; j< grid[0].length; j++) {
        if(grid[i][j]=='1') {
          numIslandsUtils(grid, i, j);
          count++;
        }
      }
    }
    return count;
  }

  public void numIslandsUtils(char[][] grid, int i, int j) {
    if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0' || grid[i][j]=='2') {
      return;
    }


    grid[i][j]='2';

    numIslandsUtils(grid, i-1, j);
    numIslandsUtils(grid, i+1, j);
    numIslandsUtils(grid, i, j-1);
    numIslandsUtils(grid, i, j+1);
  }
}
