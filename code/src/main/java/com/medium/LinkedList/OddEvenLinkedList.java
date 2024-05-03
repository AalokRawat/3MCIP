package com.medium.LinkedList;

public class OddEvenLinkedList {

  public static void main(String[] args) {

  }

  public ListNode oddEvenList(ListNode head) {
    if(head == null) {
      return null;
    }

    ListNode oddNode = head;
    ListNode evenNode = head.next;

    if(evenNode == null) {
      return oddNode;
    }
    ListNode oddStart = oddNode;
    ListNode evenStart = evenNode;

    while (true) {
      if(oddNode.next == null || oddNode.next.next == null) {
        break;
      }
      oddNode.next = oddNode.next.next;
      oddNode = oddNode.next;
      if(evenNode.next == null || evenNode.next.next == null) {
        evenNode.next = null;
        break;
      }
      evenNode.next = evenNode.next.next;
      evenNode = evenNode.next;
    }
    oddNode.next=evenStart;

    while(oddStart!=null){
      System.out.println(oddStart.val);
      oddStart = oddStart.next;
    }
    return oddStart;
  }
}
