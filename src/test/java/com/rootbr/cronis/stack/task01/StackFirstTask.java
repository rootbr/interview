package com.rootbr.cronis.stack.task01;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Stack;
import org.junit.jupiter.api.Test;

//Задача 1
//    Напишите программу, которая сортирует стек по возрастанию: минимальный
//    элемент будет на вершине стека, максимальный на дне. Можно использовать
//    только один дополнительный стек для сортировки исходного стека. Нельзя
//    использовать массив или другие структуры данных.
//    Пример
//    input: stack = {1, 5, 0, -60, 20}
//    output: stack = {-60, 0, 1, 5, 20}
public class StackFirstTask {
  @Test
  public void sortStack() {
    System.out.println("***my***");
    final MeasuringStack stack = new MeasuringStack<Integer>();
    final MeasuringStack temp = new MeasuringStack<Integer>();
    stack.push(1);
    stack.push(5);
    stack.push(-59);
    stack.push(0);
    stack.push(0);
    stack.push(-60);
    stack.push(20);

    System.out.println(Arrays.toString(stack.toArray()));
    SortStack.sort(stack, temp);
    System.out.println("pop:" + stack.getCountPop());
    System.out.println("push:" + stack.getCountPush());
    System.out.println("temp pop:" + temp.getCountPop());
    System.out.println("temp push:" + temp.getCountPush());
    System.out.println(Arrays.toString(stack.toArray()));
    System.out.println(Arrays.toString(temp.toArray()));

    assertThat(stack.pop()).isEqualTo(-60);
    assertThat(stack.pop()).isEqualTo(-59);
    assertThat(stack.pop()).isEqualTo(0);
    assertThat(stack.pop()).isEqualTo(0);
    assertThat(stack.pop()).isEqualTo(1);
    assertThat(stack.pop()).isEqualTo(5);
    assertThat(stack.pop()).isEqualTo(20);
  }

  @Test
  public void sortStackAnswer() {
    System.out.println("***answer***");
    final MeasuringStack stack = new MeasuringStack<Integer>();
    final MeasuringStack temp = new MeasuringStack<Integer>();
    stack.push(1);
    stack.push(5);
    stack.push(-59);
    stack.push(0);
    stack.push(0);
    stack.push(-60);
    stack.push(20);

    System.out.println(Arrays.toString(stack.toArray()));
    new SortStackAnswer().sort(stack,temp);
    System.out.println("pop:" + stack.getCountPop());
    System.out.println("push:" + stack.getCountPush());
    System.out.println("temp pop:" + temp.getCountPop());
    System.out.println("temp push:" + temp.getCountPush());
    System.out.println(Arrays.toString(stack.toArray()));

    assertThat(stack.pop()).isEqualTo(-60);
    assertThat(stack.pop()).isEqualTo(-59);
    assertThat(stack.pop()).isEqualTo(0);
    assertThat(stack.pop()).isEqualTo(0);
    assertThat(stack.pop()).isEqualTo(1);
    assertThat(stack.pop()).isEqualTo(5);
    assertThat(stack.pop()).isEqualTo(20);
  }
}
