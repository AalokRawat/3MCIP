package com.medium.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GP {

  public static void main(String[] args) {
  }

  public List<String> generateParenthesis(int n) {
    List<String> list = new ArrayList<>();
    generateParenthesisUtils(n, n, "", list);
    return list;
  }

  public void generateParenthesisUtils(int open, int close, String str, List<String> list) {
    if(close==0){
      list.add(str);
      str="";
      return;
    }
    if(open>0){
      generateParenthesisUtils(open-1, close, str + "(", list);
    }
    if(close>open){
      generateParenthesisUtils(open, close-1, str + ")", list);
    }
  }
}
