package com.rootbr.cronis.tree;

public class Node<T extends Number & Comparable> {
  public Node left;
  public Node right;
  public Node parent;
  public T value;

  public Node(Node parent) {
    this.parent = parent;
  }

  public void put(T v) {
    if (this.value == null) {
      this.value = v;
    }
    final var b = v.compareTo(this.value);
    if (b > 0) {
      if (this.right == null) {
        this.right = new Node(this);
      }
      right.put(v);
    } else if (b < 0) {
      if (this.left == null) {
        this.left = new Node(this);
      }
      left.put(v);
    }
  }

  public Node<T> get(T value) {
    final var b = value.compareTo(this.value);
    if (b > 0) {
      if (this.right == null) {
        return null;
      }
      return right.get(value);
    } else if (b < 0) {
      if (this.left == null) {
        return null;
      }
      return left.get(value);
    } else {
      return this;
    }
  }

  public void delete(T value) {
    final Node<T> node = get(value);

    if (node.parent == null) {
      this.value = null;
    } else if (node.left == null && node.right == null) {
      if (node.parent.right == node) {
        node.parent.right = null;
      } else {
        node.parent.left = null;
      }
    }
  }
}
