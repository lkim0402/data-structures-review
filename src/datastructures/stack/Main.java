package datastructures.stack;


public class Main {

  public static void main(String[] args) {

    Stack myStack = new Stack(1);
    myStack.push(5);
    myStack.push(7);
    myStack.printStack();

    myStack.pop();
    myStack.push(2);
    myStack.printStack();
  }

}
