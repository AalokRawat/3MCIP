package com.medium.LinkedList;

public class LinkedListIntersection {
  public static void main(String[] args) {
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    ListNode tempA = headA;
    ListNode tempB = headB;
    while(tempA!=null && tempB!=null){
      tempA=tempA.next;
      tempB=tempB.next;
    }
    if(tempA==null){
      while(tempB!=null){
        headB=headB.next;
        tempB=tempB.next;
      }
    }
    if(tempB==null){
      while(tempA!=null){
        headA=headA.next;
        tempA=tempA.next;
      }
    }

    while(true) {
      if(headA == null && headB == null) {
        return null;
      }

      if(headA == headB){
        return headA;
      }
      headA = headA.next;
      headB = headB.next;
    }
  }
}
