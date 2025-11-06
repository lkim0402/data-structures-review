package datastructures.stack;

public class Stack {
  class Node {
    public int value;
    Node next;

    private Node(int value) {
      this.value = value;
    }
  }

  private Node top;
  private int height;

  public Stack(int value) {
    Node newNode = new Node(value);
    this.top = newNode;
    height = 1;
  }

  // similar to prepend
  public void push(int value) {
    Node newNode = new Node(value);

    if (top != null) {
      newNode.next = top;
    }
    top = newNode;
    height++;
  }

  public Node pop() {
    if (top == null) return null;

    Node toPop = top;
    top = toPop.next;

    toPop.next = null;
    height--;
    return toPop;
  }


  // utility methods
  public void printStack() {
    Node temp = top;
    while (temp != null) {
      System.out.println(temp.value);
      temp = temp.next;
    }
  }

  public void getTop() {
    System.out.println("Top: " + top.value);
  }

  public void getHeight() {
    System.out.println("Height: " + height);
  }

}
