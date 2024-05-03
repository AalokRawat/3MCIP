package com.medium.TreeGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {

  public static void main(String[] args) {

  }

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> sortedLists = new ArrayList<>();
    inorderTraversalUtils1(root, sortedLists);

    return sortedLists;
  }

  public void inorderTraversalUtils(TreeNode root, List<Integer> sortedLists) {
    if(root==null){
      return;
    }

    inorderTraversalUtils(root.left, sortedLists);
    sortedLists.add(root.val);
    inorderTraversalUtils(root.right, sortedLists);
  }

  public void inorderTraversalUtils1(TreeNode root, List<Integer> sortedLists) {
    if(root==null){
      return;
    }
    Stack<TreeNode> stack = new Stack<>();

    while(true) {
      while(root!=null){
        stack.push(root);
        root = root.left;
      }
      if(stack.isEmpty()){
        break;
      }
      TreeNode value = stack.pop();
      sortedLists.add(value.val);
      if(value.right!=null){
        root=value.right;
      }
    }
  }


}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
       this.val = val;
       this.left = left;
       this.right = right;
     }
}
