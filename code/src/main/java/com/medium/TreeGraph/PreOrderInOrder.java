package com.medium.TreeGraph;

public class PreOrderInOrder {

  public static void main(String[] args) {

  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    TreeNode root = new TreeNode();
    TreeNode temp = root;
    buildTreeUtil(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, temp);
    return root;
  }

  void buildTreeUtil(int[] preorder, int i1, int j1, int[] inorder, int i2, int j2, TreeNode treeNode) {
    treeNode.val = preorder[i1];

    int index = i2;
    while (inorder[index]!=preorder[i1]) {
      index++;
    }

    if (i1 + 1 <= i1 + (index - i2)) {
      treeNode.left = new TreeNode();
      buildTreeUtil(preorder, i1 + 1, i1 + (index - i2), inorder, i2, index - 1, treeNode.left);
    }

    if (i1 + (index - i2) + 1 <= j1) {
      treeNode.right = new TreeNode();
      buildTreeUtil(preorder, i1 + (index - i2) + 1, j1, inorder, index + 1, j2, treeNode.right);
    }
  }
}
