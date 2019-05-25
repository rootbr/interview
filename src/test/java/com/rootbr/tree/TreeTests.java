package com.rootbr.tree;

import static org.assertj.core.api.Assertions.assertThat;

import com.rootbr.cronis.tree.Node;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TreeTests {

  @Test
  @DisplayName("после добавление нового элемента, нода находится в дереве и её значение соответствует вставленному")
  public void test1() {
    final var tree = new Node<Integer>();

    tree.put(1);

    assertThat(tree.get(1)).isNotNull();
    assertThat(tree.get(1).value).isEqualTo(1);
  }

  @Test
  @DisplayName("после добавление нескольких элементов, они все находятся в дереве")
  public void test2() {
    final var tree = new Node<Integer>();

    tree.put(2);
    tree.put(3);
    tree.put(1);

    assertThat(tree.get(1)).isNotNull();
    assertThat(tree.get(2)).isNotNull();
    assertThat(tree.get(3)).isNotNull();
  }
}
