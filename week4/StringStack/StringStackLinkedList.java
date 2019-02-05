public class StringStackLinkedList implements StringStack {

  Node first;
  int size;

  class Node {
    String item;
    Node next;
  }

  public void push(String s) {
    Node n = new Node();
    n.item = s;
    if (this.size == 0) {
      this.first = n;
    } else {
      n.next = this.first;
      this.first = n;
    }
    this.size++;

  }
  public String pop() {
    if (this.size == 0) {
      return null;
    }
    String returnme = this.first.item;
    this.first = this.first.next;
    this.size--;
    return returnme;
  }


  public String peek() {
    if (this.size == 0) {
      return null;
    }
    String returnme = this.first.item;
    return returnme;

  }

  // easy peasy
  public boolean isEmpty() {
    return (size == 0);
  }

  // toString() - you need to implement this for PS4!
  public String toString() {
    // intentionally left unimplemented for PS4
    return "this is not a stack";
  }

  public static void main (String args[]) {
    StringStack mss = new StringStackLinkedList();
    System.out.println("adding light");
    mss.push("light");
    System.out.println("adding banana");
    mss.push("banana");
    System.out.println("adding scarf");
    mss.push("scarf");
    System.out.println("from bottom to top:");
    System.out.println(mss.toString());
    String top = mss.pop();
    System.out.println("popping top: " + top);
    System.out.println("from bottom to top:");
    System.out.println(mss.toString());
  }

}
