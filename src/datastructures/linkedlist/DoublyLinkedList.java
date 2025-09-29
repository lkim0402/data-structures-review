package datastructures.linkedlist;

public class DoublyLinkedList {

  private Node head;
  private Node tail;
  private int length;

  public class Node {
    public int value;
    Node next;
    Node prev;

    private Node(int value) {
      this.value = value;
    }
  }

  public DoublyLinkedList(int value) {
    Node newNode = new Node(value);
    head = newNode;
    tail = newNode;
    length = 1;
  }

  public void append(int value) {
    Node newNode = new Node(value);
    if (tail == null) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;
    }
    length++;
  }

  public Node removeLast() {
    if (tail == null) return null;

    Node toRemove = tail;
    if (length == 1) {
      head = null;
      tail = null;
    } else {
      tail = tail.prev;
      tail.next = null;
      toRemove.next = null;
    }
    length--;
    return toRemove;
  }

  public void prepend(int value) {
    Node toAdd = new Node(value);
    if (length == 0) {
      head = toAdd;
      tail = toAdd;
    } else {
      toAdd.next = head;
      head.prev = toAdd;
      head = toAdd;
    }
    length++;
  }

  public Node removeFirst() {
    if (length == 0) return null;

    Node toRemove = head;
    if (length == 1) {
      head = null;
      tail = null;
    } else {
      head = head.next;
      toRemove.next = null;
      head.prev = null;
    }
    length --;
    return toRemove;
  }

  public Node get(int index) {
    if (index < 0 || index >= length) {
      return null;
    }

    int half = length / 2;
    if (index > half) { // start from tail
      index = (length - 1) - index;
      Node runner = tail;
      while (index > 0) {
        runner = runner.prev;
        index--;
      }
      return runner;
    } else {
      Node runner = head;
      while (index > 0) {
        runner = runner.next;
        index--;
      }
      return runner;
    }
  }

  // ========== print methods ==========
  public Node getHead() {
    return head;
  }

  public Node getTail() {
    return tail;
  }

  public int getLength() {
    return length;
  }

  public void printList() {
    Node temp = head;
    while (temp != null) {
      System.out.println(temp.value);
      temp = temp.next;
    }
  }

  public void printAll() {
    if (length == 0) {
      System.out.println("Head: null");
      System.out.println("Tail: null");
    } else {
      System.out.println("Head: " + head.value);
      System.out.println("Tail: " + tail.value);
    }
    System.out.println("Length:" + length);
    System.out.println("\nDoubly Linked List:");
    if (length == 0) {
      System.out.println("empty");
    } else {
      printList();
    }
  }


}
