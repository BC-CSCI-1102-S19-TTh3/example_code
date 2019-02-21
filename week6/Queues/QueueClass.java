public class QueueClass<T> implements Queue<T> {
  int size;
  Node front;

  class Node {
    String data;
    Node next;
  }

  void enqueue(String s) {
    Node n = new Node();
    n.data = s;
    if (isEmpty()) {
      front = n;
      tail = n;
    } else {
      tail.next = n;
      tail = n;
    }
    size++;

  }

  String dequeue() {
    if (this.isEmpty()) {
      return null;
    }
    String returnme = front.data;
    front = front.next;
    size--;
    return returnme;
  }

  String getFront() {
    if (this.isEmpty()) {
      return null;
    }
    return front.data;

  }

  boolean isEmpty() {
    return (size == 0);
  }
  int getSize() {
    return this.s;
  }

}
