package com.rootbr.cronis.tree;

import java.util.ArrayList;
import java.util.List;

public class Node<T extends Comparable<T>> {
  private Node<T> left;
  private Node<T> right;
  private T value;

  public Node(T value) {
    this.value = value;
  }

  public Node<T> getLeft() {
    return left;
  }

  public void setLeft(Node<T> left) {
    this.left = left;
  }

  public Node<T> getRight() {
    return right;
  }

  public void setRight(Node<T> right) {
    this.right = right;
  }


  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public Node<T> put(T v) {
    if (this.value == null) {
      this.value = v;
      return this;
    }
    final var b = v.compareTo(this.value);
    if (b > 0) {
      if (this.right == null) {
        this.right = new Node<>(v);
      }
      return right.put(v);
    } else if (b < 0) {
      if (this.left == null) {
        this.left = new Node<>(v);
      }
      return left.put(v);
    } else {
      return this;
    }
  }

  public Node<T> get(T value) {
    final var b = value.compareTo(this.value);
    if (b > 0) {
      if (notExist(this.right)) {
        return null;
      }
      return right.get(value);
    } else if (b < 0) {
      if (notExist(this.left)) {
        return null;
      }
      return left.get(value);
    } else {
      return this;
    }
  }

  public void delete(T value) {
    final Node<T> node = get(value);
    if (node == null) {
      return;
    }

    if (node.left == null || node.right == null) {
      Node<T> child = getChildOrNull(node);
      moveNode(child, node);
    } else {
      final Node<T> min = min(node.right);
      node.value = min.value;
    }
  }

  private Node<T> getChildOrNull(Node<T> node) {
    return node.left != null && node.left.value != null ? node.left : node.right;
  }

  private boolean notExist(Node<T> node) {
    return node == null || node.value == null;
  }

  private void moveNode(final Node<T> from, final Node<T> to) {
    if (from != null && from.value != null) {
      to.value = from.value;
      to.right = from.right;
      to.left = from.left;
    } else {
      to.value = null;
      to.right = null;
      to.left = null;
    }
  }

  public T min() {
    Node<T> min = min(this);
    return min != null ? min.value : null;
  }

  private Node<T> min(Node<T> node) {
    if (node.left == null) {
      return node;
    }
    return min(node.left);
  }

  public T max() {
    Node<T> max = max(this);
    return max != null ? max.value : null;
  }

  private Node<T> max(Node<T> node) {
    if (node.right == null) {
      return node;
    }
    return min(node.right);
  }

  public List<T> symmetricalTraversal() {
    List<T> result = new ArrayList<>();
    symmetricalTraversal(this, result);
    return result;
  }

  private void symmetricalTraversal(Node<T> node, List<T> result) {
    if (node == null) {
      return;
    }
    symmetricalTraversal(node.left, result);
    result.add(node.value);
    symmetricalTraversal(node.right, result);
  }

  public List<T> preOrderTraversal() {
    List<T> result = new ArrayList<>();
    preOrderTraversal(this, result);
    return result;
  }

  private void preOrderTraversal(Node<T> node, List<T> result) {
    if (node == null) {
      return;
    }
    result.add(node.value);
    preOrderTraversal(node.left, result);
    preOrderTraversal(node.right, result);
  }
}
