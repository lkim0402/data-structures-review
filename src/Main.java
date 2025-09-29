import datastructures.linkedlist.DoublyLinkedList;
import datastructures.linkedlist.DoublyLinkedList.Node;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        DoublyLinkedList dll = new DoublyLinkedList(7);
        dll.append(1);
        dll.append(6);

        System.out.println(dll.set(0,4));
        dll.printAll();

    }
}