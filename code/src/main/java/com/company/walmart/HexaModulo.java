package com.company.walmart;

public class HexaModulo {
  public static void main(String[] args) {
    System.out.println(mod("3E8", "13"));
  }

  static String mod(String a, String b) {
    int a1 = hexaToDec(a);
    int b1 = hexaToDec(b);
    int c = a1%b1;
    return decToHexa(c);
  }

  static int hexaToDec(String a) {
    int i = a.length()-1;
    int pow=0, decimalNo=0;
    while(i>=0) {
      decimalNo+=toInt(a.charAt(i))*Math.pow(16,pow++);
      i--;
    }
    return decimalNo;
  }

  static String decToHexa(int c) {
    String hexa="";
    while(c>0){
      hexa+=toHexa(c%16);
      c=c/16;
    }
    return hexa;
  }

  static int toInt(char c) {
    if (c>='A') {
      return 10+(c-'A');
    }
    return c-'0';
  }

  static char toHexa(int c) {
    if (c>9) {
      return (char) (c-10+'A');
    }
    return (char) ('0'+c);
  }
}
