package datastructures.tree;

public class BinarySearchTree {

  class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
      this.value = value;
    }
  }

  public Node root; // initialized as null

  public boolean insert(int value) {
    Node newNode = new Node(value);

    if (root == null) {
      root = newNode;
      return true;
    }

    Node temp = root;
    while (true) {
      if (temp.value == newNode.value) return false;

      if (newNode.value < temp.value) {
        // null spot
        if (temp.left == null) {
          temp.left = newNode;
          return true;
        }
        //not null
        temp = temp.left;
      } else {
        // null spot
        if (temp.right == null) {
          temp.right = newNode;
          return true;
        }
        //not null
        temp = temp.right;
      }
    }
  }

  public boolean contains(int val) {
    if (root == null) return false;

    Node temp = root;
    while (true) {
      if (val == temp.value) return true;

      if (val < temp.value) {
        if (temp.left == null) return false;
        temp = temp.left;
      } else {
        if (temp.right == null) return false;
        temp = temp.right;
      }
    }
  }

}
