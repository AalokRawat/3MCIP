package com.company.nutanix;

import java.util.Stack;

public class SpanOfNoLessAndEqual {
    static int[] arr = {100, 80, 60, 70, 60, 75, 80, 90};

    public static void main(String[] args) {
        int[] sol = new int[arr.length];
        Stack<int[]> stack = new Stack<>();

        sol[0]=1;
        stack.push(new int[] {arr[0], 0});
        for(int i=1; i<arr.length; i++) {
            if(arr[i]<arr[i-1]) {
                stack.push(new int[] {arr[i], i});
                sol[i]=1;
            } else {
                while (!stack.isEmpty() && stack.peek()[0] <= arr[i]) {
                    stack.pop();
                }

                int startIndex = 0;
                if(!stack.isEmpty()) {
                    startIndex=stack.peek()[1]+1;
                }
                sol[i]=i-startIndex+1;
            }
        }

        for(int i=0; i<sol.length; i++) {
            System.out.println(sol[i]);
        }
    }
}
