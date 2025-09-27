package datastructures.linkedlist;

public class LinkedList {

  private Node head;
  private Node tail;
  private int length;

  public LinkedList(int value) {
    Node newNode = new Node(value);
    newNode.next = null;
    head = newNode;
    tail = newNode;
    length = 1;
  }

  public void append(int value) {
    Node newNode = new Node(value);

    // if linked list was empty
    if (length < 1) {
      head = newNode;
      tail = newNode;
    } else {
      // if linked list was not empty
      tail.next = newNode;
      tail = newNode;
    }
    length++;
  }

  public Node removeLast() {
    if (length < 1) { // empty linked list
      return null;
    }

    if (length == 1){ // 1 element
      Node node = head;
      head = null;
      tail = null;
      length--;
      return node;
    }

    // remaining cases
    Node temp = head;
    while (temp.next != tail) {
      temp = temp.next;
    }
    Node nodeToRemove = temp.next;
    temp.next = null;
    tail = temp;
    length--;
    return nodeToRemove;
  }

  public void prepend(int value) {
    Node newNode = new Node(value);
    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
    length++;
  }

  public Node removeFirst() {
    if (length == 0) return null;
    if (length == 1) {
      Node nodeToRemove = head;
      head = null;
      tail = null;
      length--;
      return nodeToRemove;
    } else {
      Node nodeToRemove = head;
      head = head.next;
      nodeToRemove.next = null;
      length--;
      return nodeToRemove;
    }
  }

  public Node get(int index) {
    if (index < 0 || index > length) {
      System.out.println("Invalid index");
      return null;
    }

    int num = 0;
    Node temp = head;
    while(num < index) {
      temp = temp.next;
      num++;
    }
    return temp;
  }

  public boolean set(int index, int value) {
    Node temp = get(index);
    if (temp == null) return false;
    temp.value = value;
    return true;
  }

  public boolean insert(int index, int value) {
    if (index < 0 || index > length) {
      return false;
    }

    if (index == 0) {
      prepend(value);
    } else if (index == length) {
      append(value);
    } else {
      Node temp = get(index - 1);
      Node newNode = new Node(value);
      newNode.next = temp.next;
      temp.next = newNode;
      length++;
    }
    return true;
  }

  public Node remove(int index){
    if (index < 0 || index > length) {
      return null;
    }
    if (index == 0) {
      return removeFirst();
    } else if (index == length) {
      return removeLast();
    } else {
      Node before = get(index - 1);
      Node toRemove = get(index);

      before.next = get(index + 1);
      toRemove.next = null;
      length--;
      return toRemove;
    }
  }

  public void reverse() {
    // flipping the head and tail
    Node temp = head;
    head = tail;
    tail = temp;

    // starting the operation
    Node after = temp.next;
    Node before = null;
    for (int i = 0; i < length; i++) {
      after = temp.next;
      temp.next = before;
      before = temp;
      temp = after;
    }
  }

  // ========= utility methods =========
  public void printLength() {
    System.out.println("Length: " + length);
  }

  public void printHead() {
    System.out.println("Head: " + head);
  }

  public void printTail() {
    System.out.println("Tail: " + tail);
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
    System.out.println("Linked List:");
    if (length == 0) {
      System.out.println("empty");
    } else {
      printList();
    }
  }
}
