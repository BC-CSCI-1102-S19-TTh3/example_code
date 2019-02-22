// Here's an linked list implementation of Queue
// with a pointer to both front and tail.

public class QueueClassWithTail<T> implements Queue<T> {

  // instance variables
  int size;
  Node front;
  Node tail;

  // Inner node class
  class Node {
    T data;
    Node next;
  }

  // add something to the end of the queue
  public void enqueue(T item) {
    Node n = new Node();
    n.data = item;

    // if the queue is empty, both front and tail
    // will point at the new node
    if (isEmpty()) {
      front = n;
    }
    // otherwise, only tail needs to be reassigned
    else {
      tail.next = n;
    }
    tail = n;
    size++;
  }

  // Remove the front of the queue
  public T dequeue() {
    if (this.isEmpty()) {
      return null;
    }
    // When size == 1, you need to make sure that
    // front and tail both end up pointing at null.
    T returnme = front.data;
    if (this.size == 1) {
      tail = null;
    }
    front = front.next;
    size--;
    return returnme;
  }

  // return but do not remove the front of the queue
  public T getFront() {
    if (this.isEmpty()) {
      return null;
    }
    return front.data;
  }

  // return whether the queue is empty
  public boolean isEmpty() {
    return (size == 0);
  }

  // return the length of the queue
  public int getSize() {
    return this.size;
  }

  // main
  public static void main(String[] args) {
    Queue<String> q = new QueueClassWithTail<String>();
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
