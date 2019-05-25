package com.rootbr.cronis;

public class Main {
//  https://github.com/donbeave/interview

  public static void main(String[] args) {
    f(Integer.MAX_VALUE);
  }

  private static int f(int i) {
    if (i == 0) {
      return 1;
    }
    try {
      return i * f(i - 1);
    } finally {
      System.out.println(Integer.MAX_VALUE-i);
    }
  }
}
