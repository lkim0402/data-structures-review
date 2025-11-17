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
//    if (root == null) return false;
//
//    Node temp = root;
//    while (true) {
//      if (val == temp.value) return true;
//
//      if (val < temp.value) {
//        if (temp.left == null) return false;
//        temp = temp.left;
//      } else {
//        if (temp.right == null) return false;
//        temp = temp.right;
//      }
//    }
    return rContains(root, val);
  }

  private boolean rContains(Node currentNode, int val) {
    if (currentNode == null) return false;

    if (currentNode.value == val) return true;

    if (val < currentNode.value) {
      return rContains(currentNode.left, val);
    } else {
      return rContains(currentNode.right, val);
    }
  }

  public void rInsert(int val) {
    if (root == null) root = new Node(val);
    rInsert(root, val);
  }

  private Node rInsert(Node curNode, int val) {
    if (curNode == null) return new Node(val);

    if (val < curNode.value) {
      curNode.left = rInsert(curNode.left, val);
    } else if (val > curNode.value) {
      curNode.right = rInsert(curNode.right, val);
    }
    return curNode;
  }

  private int minValue(Node curNode) {
    while (curNode.left != null) {
      curNode = curNode.left;
    }
    return curNode.value;
  }

  public void deleteNode(int value) { root = deleteNode(root, value); }

  private Node deleteNode(Node curNode, int val) {
    if (curNode == null) return null; // tree is empty or value doesn't exist

    // traversing
    if (val < curNode.value) {
      curNode.left = deleteNode(curNode.left, val);
    } else if (val > curNode.value) {
      curNode.right = deleteNode(curNode.right, val);
    } else { // value found
      if (curNode.left == null && curNode.right == null) { // leaf
        curNode = null;
      } else if (curNode.left == null) { // only right
        curNode = curNode.right;
      } else if (curNode.right == null) { // only left
        curNode = curNode.left;
      } else { // both right and left
        int min = minValue(curNode.right);
        curNode.value = min;
        curNode.right = deleteNode(curNode.right, min);
      }
    }
    return curNode;
  }
}
