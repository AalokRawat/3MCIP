package com.medium.LinkedList;

public class AddTwoNumber {

  public static void main(String[] args) {

  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode sol = new ListNode();
    ListNode lsum = sol;
    while (true) {
      lsum.val = (l1.val + l2.val + carry) % 10;
      carry = (l1.val + l2.val + carry) / 10;
      l1 = l1.next;
      l2 = l2.next;
      if (l1==null || l2 == null){
        break;
      }
      lsum.next = new ListNode();
      lsum = lsum.next;
    }

    if(l1 == null) {
      while(l2 !=null) {
        lsum.next = new ListNode();
        lsum = lsum.next;
        lsum.val = (l2.val + carry) % 10;
        carry = (l2.val + carry) / 10;
        l2 = l2.next;
      }
    } else {
      while(l1 !=null) {
        lsum.next = new ListNode();
        lsum = lsum.next;
        lsum.val = (l1.val + carry) % 10;
        carry = (l1.val + carry) / 10;
        l1 = l1.next;
      }
    }
    if(carry>0){
      lsum.next = new ListNode();
      lsum = lsum.next;
      lsum.val = carry;
    }
    return sol;
  }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
