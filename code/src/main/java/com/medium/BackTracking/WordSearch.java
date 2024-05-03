package com.medium.BackTracking;

public class WordSearch {
  public static void main(String[] args) {
    System.out.println();
  }

  public boolean exist(char[][] board, String word) {
    int rows = board.length;
    int columns = board[0].length;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        boolean[][] visited = new boolean[rows][columns];
        if (wordExist(word, 0, board, i, j, visited)) {
          return true;
        }
      }
    }
    return false;
  }

  boolean wordExist(String word, int index, char[][] board, int i, int j, boolean[][] visited) {
    if ( index >= word.length()) {
      return true;
    }
    if (i<0 || i>=board.length || j<0 || j>=board[0].length || visited[i][j] == true || board[i][j] != word.charAt(index)) {
      return false;
    }

    for (int i1 = -1; i1<2; i1++) {
      for (int j1 = -1; j1<2; j1++) {
        visited[i][j] = true;
        if ( Math.abs(i1)!=Math.abs(j1) && wordExist(word, index + 1, board, i + i1, j + j1, visited) )
          return true;
        visited[i][j] = false;
      }
    }
    return false;
  }
}
