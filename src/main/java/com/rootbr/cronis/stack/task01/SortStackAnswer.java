package com.rootbr.cronis.stack.task01;

import java.util.Stack;

public class SortStackAnswer {
  void moveElementsBiggerTemp(Stack<Integer> unsortedStack, Stack<Integer> sortedStack, int temp) {
    while (!sortedStack.isEmpty() && sortedStack.peek() > temp) {
      unsortedStack.push(sortedStack.pop());
    }
  }

  void sort(Stack<Integer> unsortedStack, Stack<Integer> sortedStack) {
    while (!unsortedStack.isEmpty()) {
      int temp = unsortedStack.pop();
      moveElementsBiggerTemp(unsortedStack, sortedStack, temp);
      sortedStack.push(temp);
    }
    while (!sortedStack.isEmpty()) {
      unsortedStack.push(sortedStack.pop());
    }
  }
}
