package com.medium.TreeGraph;

import java.util.ArrayDeque;

public class PNRPEN {

  public static void main(String[] args) {

  }

  public Node connect(Node root) {
    if (root == null || root.right == null) {
      return root;
    }
    ArrayDeque<Node> queue = new ArrayDeque<>();
    queue.addLast(root.right);
    queue.addLast(root.left);

    while (!queue.isEmpty()) {
      ArrayDeque<Node> tempQueue = new ArrayDeque<>();
      Node r = null;
      Node l = null;
      while (!queue.isEmpty()) {
        l = queue.removeFirst();
        l.next = r;

        if ( l.right!=null ) {
          tempQueue.addLast(l.right);
          tempQueue.addLast(l.left);
        }
        r = l;
      }
      queue = tempQueue;
    }

    return root;
  }
}

class Node {
  public int val;
  public Node left;
  public Node right;
  public Node next;

  public Node() {}

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, Node _left, Node _right, Node _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
};