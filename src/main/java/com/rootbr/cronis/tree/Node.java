package com.rootbr.cronis.tree;

import java.util.ArrayList;
import java.util.List;

public class Node<T extends Comparable> {
  private Node<T> left;
  private Node<T> right;
  private Node<T> parent;
  private T value;

  public Node(Node<T> parent) {
    this.parent = parent;
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

  public Node<T> getParent() {
    return parent;
  }

  public void setParent(Node<T> parent) {
    this.parent = parent;
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
        this.right = new Node<>(this);
      }
      return right.put(v);
    } else if (b < 0) {
      if (this.left == null) {
        this.left = new Node<>(this);
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

  public void delete(T value) {
    final Node<T> node = get(value);
    if (node == null) {
      return;
    }

    if (node.left == null && node.right == null) {
      setParent(node, null);
    } else if (node.left == null || node.right == null) {
      setParent(node, node.left != null ? node.left : node.right);
    } else {
      final Node<T> min = min(node.right);
      node.value = min.value;
      min.parent.left = min.right;
    }
  }

  private void setParent(Node<T> node, Node<T> newNode) {
    if (node.parent.right == node) {
      node.parent.right = newNode;
    } else {
      node.parent.left = newNode;
    }
    if (newNode != null) {
      newNode.setParent(node.parent);
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

  public List<T> perOrderTraversal() {
    List<T> result = new ArrayList<>();
    perOrderTraversal(this, result);
    return result;
  }

  private void perOrderTraversal(Node<T> node, List<T> result) {
    if (node.left != null) {
      perOrderTraversal(node.left, result);
    }
    result.add(node.value);
    if (node.right != null) {
      perOrderTraversal(node.right, result);
    }
  }
}
