package com.medium.ArrayString;

public class SetMatrixZeros {

  public static void main(String[] args) {

  }

  public void setZeroes(int[][] matrix) {
    int i_length=1, j_width=1;
    for(int i=0; i<matrix.length; i++){
      if(matrix[i][0]==0)
        i_length=0;
    }
    for(int j=0; j<matrix[0].length; j++){
      if(matrix[0][j]==0)
        j_width=0;
    }

    for(int i=0; i<matrix.length; i++){
      for(int j=0; j<matrix[0].length; j++){
        if(matrix[i][j]==0){
          matrix[i][0]=0;
          matrix[0][j]=0;
        }
      }
    }

    for(int i=matrix.length-1; i>0; i--){
      if(matrix[i][0]==0){
        for(int j=1; j<matrix[0].length; j++){
          matrix[i][j]=0;
        }
      }
    }
    for(int j=matrix[0].length-1; j>0; j--){
      if(matrix[0][j]==0){
        for(int i=1; i<matrix.length; i++){
          matrix[i][j]=0;
        }
      }
    }

    if(i_length==0){
      for(int i=0; i<matrix.length; i++){
        matrix[i][0]=0;
      }
    }
    if(j_width==0){
      for(int j=0; j<matrix[0].length; j++){
        matrix[0][j]=0;
      }
    }
  }
}
