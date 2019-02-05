
class StackLinkedList<T> implements Stack<T>{

  Node first;
  int size;

  class Node {
    T item;
    Node next;
  }

  public void push(T s) {
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
  public T pop() {
    if (this.size == 0) {
      return null;
    }
    T returnme = this.first.item;
    this.first = this.first.next;
    this.size--;
    return returnme;
  }

  public T peek() {
    if (this.size == 0) {
      return null;
    }
    T returnme = this.first.item;
    return returnme;
  }

  public boolean isEmpty() {
    return (size == 0);
  }
  public String toString() {
    // intentionally left unimplemented for PS4
    return "this is not a stack";
  }

  public static void main (String args[]) {
    Stack<String> mss = new StackLinkedList<String>();
    mss.push("light");
    mss.push("banana");
    mss.push("scarf");
    String top = mss.pop();
    System.out.println("popping top: " + top);
    System.out.println("from bottom to top:");
    System.out.println(mss.toString());
  }
}
