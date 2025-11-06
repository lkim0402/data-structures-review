package datastructures.queue;


public class Queue {
  class Node {
    public int value;
    public Node next;
    private Node(int value) {
      this.value = value;
    }
  }

  private Node first;
  private Node last;
  private int length;


  // dequeue from head, enqueue to tail
  // this ensures O(1) on both
  public Queue(int value) {
    Node newNode = new Node(value);
    this.first = newNode;
    this.last = newNode;
    length = 1;
  }

  // enqueue - tail
  public void enqueue(int value) {
    Node newNode = new Node(value);

    if (length == 0) {
      first = newNode;
    } else {
      last.next = newNode;
    }

    last = newNode;
    length++;
  }

  // dequeue - head
  public Node dequeue() {
    if (length == 0) return null;

    Node toRemove = first;
    if (length == 1) {
      first = null;
      last = null;
    } else {
      first = toRemove.next;
      toRemove.next = null;
    }
    length--;
    return toRemove;
  }

  // utility methods
  public void printQueue() {
    Node temp = first;
    while (temp != null) {
      System.out.println(temp.value);
      temp = temp.next;
    }
  }

  public void getFirst() {
    System.out.println("First: " + first.value);
  }
  public void getLast() {
    System.out.println("Last: " + last.value);
  }

  public void getLength() {
    System.out.println("Height: " + length);
  }

}
