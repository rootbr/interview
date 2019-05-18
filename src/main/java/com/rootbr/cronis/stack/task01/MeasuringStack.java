package com.rootbr.cronis.stack.task01;

import java.util.Stack;

public class MeasuringStack<T> extends Stack<T> {
  private int countPush = 0;
  private int countPop = 0;

  @Override
  public synchronized T pop() {
    countPop++;
    return super.pop();
  }

  @Override
  public T push(T item) {
    countPush++;
    return super.push(item);
  }

  public int getCountPush() {
    return countPush;
  }

  public int getCountPop() {
    return countPop;
  }
}
