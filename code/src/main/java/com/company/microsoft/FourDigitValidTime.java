package com.company.microsoft;

import java.util.HashSet;
import java.util.Set;

public class FourDigitValidTime {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int count = 0;
        for(String time : validTimeCount(arr, 0)) {
            if(isValidTime(time)) {
                count++;
            }
        }
        System.out.println(count);
    }

    static boolean isValidTime(String time) {
        int hour = Integer.parseInt(time.substring(0,2));
        if(hour>23) {
            return false;
        }
        int min = Integer.parseInt(time.substring(2, 4));
        if(min>59) {
            return false;
        }
        return true;
    }

    static Set<String> validTimeCount(int[] arr, int i) {
        if(i== arr.length-1) {
            return Set.of(String.valueOf(arr[i]));
        }
        Set<String> str = new HashSet<>();
        for(int j=i; j<arr.length; j++) {
            swap(arr, i, j);
            for(String s : validTimeCount(arr, i+1)) {
                str.add(arr[i] + s);
            }
        }
        return str;
    }

    static void swap(int[] arr, int i, int j) {
        int v = arr[i];
        arr[i] = arr[j];
        arr[j] = v;
    }

}
