package com.rootbr.cronis.stack.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ArrayStack<T> {
  private final int sizeStack;
  private final List<Stack<T>> stackList = new ArrayList<>();

  public ArrayStack(int sizeStack) {
    this.sizeStack = sizeStack;
  }

  public List<Stack<T>> getStackList() {
    return stackList;
  }

  public void push(T i) {
    if (stackList.size() == 0 || stackList.get(stackList.size() - 1).size() >= sizeStack) {
      stackList.add(new Stack<T>());
      stackList.get(stackList.size() - 1).push(i);
    } else {
      stackList.get(stackList.size() - 1).push(i);
    }
  }
}
