package com.medium.TreeGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZag {

  public static void main(String[] args) {

  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if(root==null) {
      return new ArrayList<>();
    }

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    boolean l2r = true;
    List<List<Integer>> sol = new ArrayList<>();
    while (true) {
      Stack<TreeNode> tempStack = new Stack<>();
      List<Integer> list = new ArrayList<>();

      while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        list.add(node.val);
        if (l2r) {
          if (node.left != null) tempStack.push(node.left);
          if (node.right != null) tempStack.push(node.right);
        } else {
          if (node.right != null) tempStack.push(node.right);
          if (node.left != null) tempStack.push(node.left);
        }
      }
      sol.add(list);
      if(tempStack.isEmpty()){
        break;
      }
      stack = tempStack;
      l2r = !l2r;
    }
    return sol;
  }
}
