package com.medium.TreeGraph;

public class KthSmallest {

  public static void main(String[] args) {

  }

  public int kthSmallest(TreeNode root, int k) {
    int[] arr = new int[1];
    arr[0]=k;
    return kthSmallestUtils(root, arr);
  }

  public int kthSmallestUtils(TreeNode root, int[] k) {
    if(root==null){
      return -1;
    }
    int val = kthSmallestUtils(root.left, k);
    if(val!=-1) {
      return val;
    }
    k[0]--;
    if(k[0]==0){
      return root.val;
    }
    return kthSmallestUtils(root.right, k);
  }
}