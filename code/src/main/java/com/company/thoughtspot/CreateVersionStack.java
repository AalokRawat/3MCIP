package com.company.thoughtspot;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CreateVersionStack {
    public static void main(String[] args) {
        VersionStack versionStack = new VersionStack();

        versionStack.push(1);
        versionStack.push(2);
        versionStack.push(3);
        versionStack.push(4);
        versionStack.pop();
        versionStack.pop();
        versionStack.pop();
        versionStack.pop();

        versionStack.print(4);
        versionStack.print(5);
        versionStack.print(6);
        versionStack.print(7);
        versionStack.print(8);
    }
}

class VersionStack {
    int version=0;
    Map<Integer, Integer> versionHistory = new HashMap<>();
    Stack<Integer> myStack = new Stack<>();

    public void push(int value) {
        myStack.push(value);
        versionHistory.put(++version, value);
    }

    public int pop() {
        int value = myStack.pop();
        versionHistory.put(++version, -1);
        return value;
    }

    public void print(int version) {
        int count=0;

        if(!versionHistory.containsKey(version)) {
            return;
        }

        for(int i=version; i>0; i--) {
            int value = versionHistory.get(i);
            if(value!=-1 && count==0) {
                System.out.println(value);
            } else if(value==-1) {
                count++;
            } else {
                count--;
            }
        }
        System.out.println();
    }
}