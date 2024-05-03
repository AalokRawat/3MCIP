package com.wss;

import java.util.Scanner;

public class REPLMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String cmd = sc.nextLine();
            try {
                ExpressionEvaluator.eval(cmd);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
