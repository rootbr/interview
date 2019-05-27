package com.rootbr.cronis.tree;

import java.util.List;

public class Node<T extends Comparable> {
  public Node<T> left;
  public Node<T> right;
  public Node<T> parent;
  public T value;

  public Node(Node parent) {
    this.parent = parent;
  }

  public Node<T> put(T v) {
    if (this.value == null) {
      this.value = v;
      return this;
    }
    final var b = v.compareTo(this.value);
    if (b > 0) {
      if (this.right == null) {
        this.right = new Node(this);
      }
      return right.put(v);
    } else if (b < 0) {
      if (this.left == null) {
        this.left = new Node(this);
      }
      return left.put(v);
    } else {
      return this;
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

  public boolean delete(T value) {
    final Node<T> node = get(value);
    if (node == null) {
      return false;
    }

    if (node.left == null && node.right == null) {
      if (node.parent.right == node) {
        node.parent.right = null;
      } else {
        node.parent.left = null;
      }
    } else if ((node.left == null && node.right != null)
        || (node.left != null && node.right == null)) {
      if (node.parent.right == node) {
        node.parent.right = node.left != null ? node.left : node.right;
      } else {
        node.parent.left = node.left != null ? node.left : node.right;
      }
    } else {
      final Node<T> min = min(node.right);
      node.value = min.value;
      min.parent.left = min.right;
    }
    return true;
  }



  public Node<T> min(Node<T> node) {
    if (node.left == null) {
      return node;
    }
    return min(node.left);
  }

  public List<T> perOrderTraversal() {
    return null;
  }
}
