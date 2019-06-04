package com.rootbr.tree;

import static org.assertj.core.api.Assertions.assertThat;

import com.rootbr.RandomTreeProvider;
import com.rootbr.cronis.tree.Node;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class TreeTask3 {

  @ParameterizedTest
  @ArgumentsSource(RandomTreeProvider.class)
  @DisplayName("первращает дерево в двухсвязный список (количество элементов совпадает и есть все элементы)")
  public void test1(final Node<Integer> tree) {

    LinkedList<Integer> list = tree.toLinkedList();

    final List<Integer> integers = tree.symmetricalTraversal();
    assertThat(list).containsExactlyInAnyOrder(integers.toArray(new Integer[0]));
  }
}
