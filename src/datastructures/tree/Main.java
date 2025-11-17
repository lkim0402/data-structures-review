package datastructures.tree;

public class Main {

  public static void main(String[] args) {
    BinarySearchTree myBST = new BinarySearchTree();
//    System.out.println(myBST.root);
    myBST.rInsert(2);
    myBST.rInsert(4);
    myBST.rInsert(1);
    System.out.println(myBST.contains(2));
    System.out.println(myBST.contains(5));
  }

}
