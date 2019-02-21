public class QueueClassFixedArray<T> implements Queue<T> {

  // static variables
  // Here we're saying the maximum size of the queue is 10.
  int CAPACITY = 10;

  // instance variables
  // you need an array to store the queue!
  T[] storage;
  int size;

  // constructor
  public QueueClassFixedArray () {
    // You want to create an array, but you aren't allowed to
    // create an array of a generic type, so this is a way around that.
    // Create an array of Objects that you then cast to type T
    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Object[CAPACITY];
    this.storage = temp;
    this.size = 0;
  }

  // Interface methods
  // add to end: easy
  public void enqueue (T item) {
    if (size == CAPACITY) {
      throw new RuntimeException("Stack Overflow.");
    }

    // Easy: add the item to the next available place.
    storage[size] = item;
    size++;

  }

  // remove from beginning: more complicated
  public T dequeue() {
    if (isEmpty()) {
      return null;
    }
    // It gets ugly here because you need to create new array
    // that does not include the first element and starts
    // at the second element.
    T toreturn = storage[0]; // save out the item you'll return

    // trick to let you create an array of a reference type
    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Object[CAPACITY];

    // Starting from the second element of your storage array,
    // copy each item over to the new temp array.
    for (int i = 1; i < size; i++) {
      temp[i-1] = storage[i];
    }

    // Decrement size.
    size--;

    // Make your storage instance variable point at temp.
    storage = temp;
    return toreturn;

  }

  // getFront, easy
  public T getFront() {
    if (isEmpty()) {
      return null;
    }
    return storage[0];
  }

  // getSize, easy
  public int getSize() {
    return size;
  }

  // isEmpty, easy
  public boolean isEmpty() {
    return (size ==0);
  }

  // main
  // note that this main method and the one in
  // QueueClassWithTail are identical except for the
  // declaration of the QueueClassWithoutTail object.
  // This is because we are programming to the interface:
  // we are just using methods in the interface! We don't
  // need to know anything about how it was implemented.
  public static void main(String[] args) {
    Queue<String> q = new QueueClassFixedArray<String>();
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
