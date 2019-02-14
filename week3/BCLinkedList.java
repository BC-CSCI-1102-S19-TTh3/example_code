
public class BCLinkedList implements BCList {

  // instance variables
  Node first;  // a pointer to the front of the the list
  Node last;   // a pointer to the end of the list
  int size;    // stores the size of the list

  class Node {
    String item;
    Node next;
  }


  // methods to implement from interface

  // ADD ELEMENT TO END OF LIST
  public void add(String s) {

    // create a new node
    Node n = new Node();
    n.item = s;

    // if the list is empty, first and last will point at new Node n
    if (isEmpty()) {
      first = n;
      last = n;
    }
    // otherwise, make last.next (which is currently null) point at new Node n
    // then make last point at new Node n instead of what it pointed at before
    else {
      last.next = n;
      last = n;
    }
    size++;
  }

  // GET ELEMENT AT POSITION i
  public String get(int i) {
    if (i >= size) {
      return null;
    }
    // create a counter int that keeps track of how many nodes you've visited
    int counter = 0;

    // create a Node that will help you traverse the the list
    Node n = first;
    while (counter < i) {
      n = n.next;
      counter++;
    }
    return n.item;
  }

  // REMOVE ELEMENT AT INDEX i

  public String remove(int i) {
    if (i >= size) {
      return null;
    }
    // create a counter int that keeps track of how many nodes you've visited
    int counter = 0;

    // create a Node that will help you traverse the the list
    Node n = first;
    while (counter < i) {
      n = n.next;
      counter++;
    }
    String returnme = n.item;
    n.next = n.next.next;
    size--;
    return returnme;
  }

 // isEmpty, easy
  public boolean isEmpty() {
    return (this.size == 0);
  }

  // toString()
  public String toString() {

    // I'm using StringBuilder here because repeatedly appending
    // a String is inefficient.
    StringBuilder sb = new StringBuilder();
    for (Node n = first; n != null; n = n.next) {
      sb.append(n.item + " ");
    }
    return sb.toString();
  }

  // main method testing the functionality of the code
  // NOTICE: This main method is exactly like the one in BCArrayList!
  // The client (i.e., the main method in this case) does not need to
  // know that the implementation of BCLinkedLIst and BCArrayList are totally different.
  public static void main (String[] args) {
    BCLinkedList bcal = new BCLinkedList();
    bcal.add("dog");
    bcal.add("fish");
    bcal.add("coffee");
    bcal.add("television");
    bcal.add("orange");
    System.out.format("element at index %d is %s%n", 2, bcal.get(2));
    System.out.println(bcal.toString());
    bcal.remove(3);
    System.out.println(bcal.toString());


  }


}
