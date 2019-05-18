package com.rootbr.cronis.stack.task01;

import static org.assertj.core.api.Assertions.assertThat;

import com.rootbr.cronis.stack.task01.ArrayStack;
import org.junit.jupiter.api.Test;

/*Представьте стопку тарелок. Если она будет слишком высокой, то она обрушится.
Для того, чтобы она не рушилась, нужно делать несколько стопок тарелок.
Напишите программу, которая повторяет это поведение. Другими словами: если
текущий стек полностью заполнен, создается новый стек и заполняется уже он.
При этом функции push и pop для пользователя должны себя вести так, как будто
это обычный стек.*/
public class StackSecondTask {
  @Test
  public void whenAddALotOfElementsThenSizeStack_thenCreateNewStack() {
    final int sizeStask = 2;
    final var stack = new ArrayStack<Integer>(sizeStask);
    assertThat(stack.getStackList()).size().isEqualTo(0);

    for (int i = 0; i < sizeStask; i++) {
      stack.push(0);
    }
    assertThat(stack.getStackList()).size().isEqualTo(1);
    assertThat(stack.getStackList().get(0)).size().isEqualTo(2);

    for (int i = 0; i < sizeStask; i++) {
      stack.push(0);
    }
    assertThat(stack.getStackList()).size().isEqualTo(2);
    assertThat(stack.getStackList().get(1)).size().isEqualTo(2);
  }
}
