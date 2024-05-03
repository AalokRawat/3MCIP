package com.company.thoughtspot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateMyCache {
    public static void main(String[] args) {
        int[][] arr = new int[10][2];
        int i=0,j=0;
        List<int[]> list= new ArrayList<>();
        list.add(new int[] {i, j});
        list.get(0);

        Arrays.sort(arr, (x, y) -> x[1]-y[1]);

        MyCache myCache = new MyCache(3);

        myCache.put(1, 'a');
        myCache.put(2, 'b');
        myCache.put(3, 'c');

        Node l = myCache.head;
        while (l!=null) {
            System.out.println(l.key + " : " + l.value);
            l=l.next;
        }

        System.out.println();

        myCache.put(4, 'd');

        l = myCache.head;
        while (l!=null) {
            System.out.println(l.key + " : " + l.value );
            l=l.next;
        }

        System.out.println(myCache.get(2));

        l = myCache.head;
        while (l!=null) {
            System.out.println(l.key + " : " + l.value );
            l=l.next;
        }
    }
}

class MyCache {
    int size=0;
    Node head =null, tail = null, prevOfTail = null;

    Map<Integer, Node> map = new HashMap<>();

    public MyCache(int size) {
        this.size = size;
    }

    public void put(int k, char v) {
        if(map.keySet().size()==size) {
            int key = head.key;
            head = head.next;
            head.pre=null;

            map.remove(key);
        }

        if(head == null) {
            head = new Node();
            tail = head;
        } else {
            tail.next = new Node();
            prevOfTail = tail;
            tail = tail.next;
        }

        tail.key = k;
        tail.value = v;
        map.put(k, tail);
        tail.pre = prevOfTail;
    }

    public char get(int k) {
        Node node = map.get(k);

        if(node.pre == null) {
            head = node.next;
            head.pre = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        tail.next = node;
        node.pre = tail;
        node.next=null;
        tail=node;
        return node.value;
    }

    public boolean delete(int k) {
        Node node = map.get(k);
        node.pre.next = node.next;
        node.pre = null;
        node.next = null;
        map.remove(k);
        return true;
    }
}

class Node {
    Node pre;
    int key;
    char value;
    Node next;
}
