package com.medium.ArrayString;

public class LPS {

  public static void main(String[] args) {
    new LPS().longestPalindrome("babad");
  }

  public String longestPalindrome(String s) {
    String str = lpUtil(s);
    if(str.isEmpty() && !s.isEmpty()) {
      return s.substring(0,1);
    }
    return str;
  }

  public String lpUtil(String s) {
    String str="";
    int[][] arr = new int[s.length()][s.length()];

    for(int i=0; i<s.length(); i++){
      arr[i][i]=1;
    }

    for(int l=1; l<s.length(); l++){
      for(int i=0; i<s.length()-l; i++) {
        int j=i+l;
        if(s.charAt(i)==s.charAt(j) && ( i+1>j-1 || arr[i+1][j-1]==1 )){
          arr[i][j]=1;
          String str1 = s.substring(i, j+1);
          if(str1.length()>str.length()){
            str=str1;
          }
        }
      }
    }
    return str;
  }
}
