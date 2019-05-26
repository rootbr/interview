package com.rootbr.tree;

import static org.assertj.core.api.Assertions.assertThat;

import com.rootbr.cronis.tree.Node;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TreeTests {

  private static final int NODE_PARENT = 5;
  private static final int NODE_WITHOUT_LISTS = 4;
  private static final int NODE_ONLY_RIGHT_NODE = 1;
  private static final int NODE_ONLY_LEFT_NODE = 10;
  private static final int NODE_WITH_BOTH_NODE = 7;
  private static final int ANY_VALUE = 11;

  @Test
  @DisplayName("после добавления нового элемента, нода находится в дереве и её значение соответствует вставленному")
  public void test1() {
    final var tree = defaultTree();

    tree.put(ANY_VALUE);

    assertThat(tree.get(ANY_VALUE)).isNotNull();
    assertThat(tree.get(ANY_VALUE).value).isEqualTo(ANY_VALUE);
  }

  @Test
  @DisplayName("после добавления нескольких элементов, они все находятся в дереве")
  public void test2() {
    final Node<Integer> tree = defaultTree();

    tree.put(123);
    tree.put(321);
    tree.put(231);

    assertThat(tree.get(123)).isNotNull();
    assertThat(tree.get(321)).isNotNull();
    assertThat(tree.get(231)).isNotNull();
  }

  @Test
  @DisplayName("после удаления элемента без листьев, он не находится в дереве")
  public void test3() {
    final Node<Integer> tree = defaultTree();

    tree.delete(NODE_WITHOUT_LISTS);

    assertThat(tree.get(NODE_WITHOUT_LISTS)).isNull();
  }

  @Test
  @DisplayName("после удаления элемента c левым элементом, он не находится в дереве, а левые элемент находится")
  public void test4() {
    final Node<Integer> tree = defaultTree();
    tree.put(NODE_ONLY_LEFT_NODE - 1);

    tree.delete(NODE_ONLY_LEFT_NODE);

    assertThat(tree.get(NODE_ONLY_LEFT_NODE)).isNull();
    assertThat(tree.get(NODE_ONLY_LEFT_NODE - 1)).isNotNull();
  }

  @Test
  @DisplayName("после удаления элемента c правым элементом, он не находится в дереве, а правый элемент находится")
  public void test5() {
    final Node<Integer> tree = defaultTree();
    tree.put(NODE_ONLY_RIGHT_NODE + 1);

    tree.delete(NODE_ONLY_RIGHT_NODE);

    assertThat(tree.get(NODE_ONLY_RIGHT_NODE)).isNull();
    assertThat(tree.get(NODE_ONLY_RIGHT_NODE + 1)).isNotNull();
  }

  private Node<Integer> defaultTree() {
    final var tree = new Node<Integer>(null);
    tree.put(NODE_PARENT);
    tree.put(3);
    tree.put(NODE_ONLY_RIGHT_NODE);
    tree.put(2);
    tree.put(NODE_WITHOUT_LISTS);
    tree.put(NODE_WITH_BOTH_NODE);
    tree.put(NODE_ONLY_LEFT_NODE);
    tree.put(8);
    tree.put(9);
    tree.put(6);
    return tree;
  }
}
