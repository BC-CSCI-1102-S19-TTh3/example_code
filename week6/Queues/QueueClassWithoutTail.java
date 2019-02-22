// Here's an linked list implementation of Queue
// with a pointer only to the front.

public class QueueClassWithoutTail<T> implements Queue<T> {

  // instance variables
  int size;
  Node front;

  // Inner node class
  class Node {
    T data;
    Node next;
  }

  QueueClassWithoutTail() {
      this.size = 0;
      this.front = null;
  }

  // add something to the end of the queue
  public void enqueue(T item) {
    Node n = new Node();
    n.data = item;
    if (isEmpty()) {
      front = n;
    } else {

      // you have to traverse the LL until you gets
      // to a node whose next pointer is null.
      Node traverse = front;
      while (traverse.next != null) {
        traverse = traverse.next;
      }
      traverse.next = n;
    }
    size++;
  }

  // Remove the front of the queue
  public T dequeue() {
    if (this.isEmpty()) {
      return null;
    }
    T returnme = front.data;
    front = front.next;
    size--;
    return returnme;
  }

  // Return but do not remove the front of the queue
  public T getFront() {
    if (this.isEmpty()) {
      return null;
    }
    return front.data;
  }

  // Return whether the queue is empty
  public boolean isEmpty() {
    return (size == 0);
  }

  // return the length of the queue
  public int getSize() {
    return this.size;
  }

  // main
  // note that this main method and the one in
  // QueueClassWithTail are identical except for the
  // declaration of the QueueClassWithoutTail object.
  // This is because we are programming to the interface:
  // we are just using methods in the interface! We don't
  // need to know anything about how it was implemented.
  public static void main(String[] args) {
    Queue<String> q = new QueueClassWithoutTail<String>();
    q.enqueue("Boston");
    System.out.println(q.getSize());
    System.out.println(q.getFront());
    q.enqueue("Cambridge");
    System.out.println(q.getSize());
    System.out.println(q.getFront());
    q.enqueue("Somerville");
    System.out.println(q.getSize());
    System.out.println(q.getFront());
    q.enqueue("Lexington");
    System.out.println(q.getSize());
    System.out.println(q.getFront());
    q.enqueue("Chestnut Hill");
    q.dequeue();
    System.out.println(q.getFront());
    q.dequeue();
    System.out.println(q.getFront());
    q.dequeue();
    System.out.println(q.getFront());
    q.dequeue();
    System.out.println(q.getFront());
    q.dequeue();
    System.out.println(q.getFront());
    q.enqueue("Boston");
    System.out.println(q.getSize());
    System.out.println(q.getFront());
    q.enqueue("Cambridge");
    System.out.println(q.getSize());
    System.out.println(q.getFront());
    q.enqueue("Somerville");
    System.out.println(q.getSize());
    System.out.println(q.getFront());
    q.enqueue("Lexington");
    System.out.println(q.getSize());
    System.out.println(q.getFront());
    q.enqueue("Chestnut Hill");
    q.dequeue();
    System.out.println(q.getFront());
    q.dequeue();
    System.out.println(q.getFront());
    q.dequeue();
    System.out.println(q.getFront());
    q.dequeue();
    System.out.println(q.getFront());
    q.dequeue();
    System.out.println(q.getFront());

  }

}
