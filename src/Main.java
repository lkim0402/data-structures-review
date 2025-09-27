import datastructures.linkedlist.DoublyLinkedList;
import datastructures.linkedlist.DoublyLinkedList.Node;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        DoublyLinkedList dll = new DoublyLinkedList(7);
        Node removed = dll.removeLast();
        System.out.println("removing: " + removed.value);
        dll.printAll();

        Node removed2 = dll.removeLast();
        dll.printAll();
    }
}