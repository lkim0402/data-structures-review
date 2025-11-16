package datastructures.tree;

public class Main {

  public static void main(String[] args) {
    BinarySearchTree myBST = new BinarySearchTree();
//    System.out.println(myBST.root);
    myBST.insert(2);
    myBST.insert(4);
    myBST.insert(1);
    System.out.println(myBST.contains(2));
    System.out.println(myBST.contains(5));


  }

}
