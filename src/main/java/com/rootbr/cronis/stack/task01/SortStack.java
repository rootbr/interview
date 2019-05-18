package com.rootbr.cronis.stack.task01;

import java.util.Stack;

public class SortStack {
  public static void sort(final Stack<Integer> stack, final Stack<Integer> temp) {
    final var size = stack.size();
    for (int i = 0; i < size; i++) {
      interation(stack, temp, i);
    }
  }

  private static void interation(Stack<Integer> stack, Stack<Integer> temp, int from) {
    Integer max = max(stack, temp, from, Integer.MIN_VALUE);
    stack.push(max);
    exchange(temp, stack, max);
  }

  private static void exchange(Stack<Integer> stack, Stack<Integer> temp, Integer max) {
    boolean needCopy = false;
    final int size = stack.size();
    for (int i = 0; i < size; i++) {
      final Integer pop = stack.pop();
      if (max.equals(pop) && !needCopy) {
        needCopy = true;
      } else {
        temp.push(pop);
      }
    }
  }

  private static Integer max(final Stack<Integer> stack, Stack<Integer> temp, int from, Integer max) {
    final var size = stack.size();
    for (int i = from; i < size; i++) {
      final Integer integer = stack.pop();
      if (integer >= max) {
        max = integer;
      }
      temp.push(integer);
    }
    return max;
  }
}
