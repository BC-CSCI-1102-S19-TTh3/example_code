public class CircularArrayDeque<T> implements Deque<T> {

  // static variables
  // Here we're saying the maximum size of the deque is 10.
  int CAPACITY = 10;

  // instance variables
  T[] storage;    // you need an array to store the deque
  int front;      // index of the front of the deque
  int tail;       // index of the tail of the deque
  int size;       // size of the deque

  // constructor
  public CircularArrayDeque () {
    // You want to create an array, but you aren't allowed to
    // create an array of a generic type, so this is a way around that.
    // Create an array of Objects that you then cast to type T
    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Object[CAPACITY];
    this.storage = temp;
    this.size = 0;
  }

  // Interface methods

  // NOTE: Some of the "wrap around" syntax can be made much simpler using
  // the modulus operator %. I am being explicit here so you can
  // see exactly what is happening. Feel free to use % for PS6.

  // add to the front
  public void addFront (T item) {
    if (size == CAPACITY) throw new RuntimeException("Stack Overflow.");

    // If the current front index is 0, then add to the final index,
    // i.e., wrap around backwards.
    if (front == 0) {
      storage[CAPACITY-1] = item;
      front = CAPACITY-1;
    }
    // Otherwise, add the element to the index before the current front index.
    else {
      storage[front-1] = item;
      front--;
    }
    // don't forget, if you're adding to an empty list,
    // front and tail will be the same
    if (size == 0) {
      tail = front;
    }
    size++;
  }

  // add to the tail
  public void addTail(T item) {
    if (size == CAPACITY) throw new RuntimeException("Stack Overflow.");

    // If the current tail index is CAPACITY-1, then add to index 0,
    // i.e., wrap around forwards.
    if (tail == CAPACITY-1) {
      storage[0] = item;
      tail = 0;
    }
    // Otherwise, add the element to the index before the current front index.
    else {
      storage[tail+1] = item;
      tail++;
    }

    // don't forget, if you're adding to an empty list,
    // front and tail will be the same
    if (size == 0) {
      front = tail;
    }
    size++;
  }

  // remove from tail
  public T removeTail() {
    if (isEmpty()) return null;

    T returnme = storage[tail];

    // if size is 1, reset tail and front to 0
    if (size == 1) {
      tail = 0;
      front = 0;
    }
    // otherwise, decrement tail
    // or if it's zero, set it to CAPACITY-1
    else {
      tail--;
      if (tail < 0) {
        tail = CAPACITY-1;
      }
    }

    size--;
    return returnme;

  }

  // remove from front
  public T removeFront() {
    if (isEmpty()) return null;

    T returnme = storage[front];

    // if size is 1, reset tail and front to 0
    if (size == 1) {
      tail = 0;
      front = 0;
    }
    // otherwise, increment front,
    // and if it exceeds CAPACITY, set to 0
    else {
      front++;
      if (front >= CAPACITY) {
        front = 0;
      }
    }

    size--;
    return returnme;

  }

  // peekFront, easy
  public T peekFront() {
    if (isEmpty()) {
      return null;
    }
    return storage[front];
  }

  // peekTail, easy
  public T peekTail() {
    if (isEmpty()) {
      return null;
    }
    return storage[tail];
  }

  // getSize, easy
  public int getSize() {
    return size;
  }

  // isEmpty, easy
  public boolean isEmpty() {
    return (size ==0);
  }

  // print out the deque from front to tail
  public void printDeque() {
    System.out.println();
    for (int i = 0; i < size; i++) {
      System.out.println(storage[(i+front)%CAPACITY]);
    }
  }


  // main()
  public static void main(String[] args) {
    CircularArrayDeque<String> mydeque = new CircularArrayDeque<String>();
    mydeque.addFront("dog");
    mydeque.printDeque();
    mydeque.addFront("tree");
    mydeque.printDeque();
    mydeque.addTail("elephant");
    mydeque.printDeque();
    mydeque.addFront("animal");
    mydeque.addFront("piano");
    mydeque.printDeque();
    mydeque.removeFront();
    mydeque.printDeque();
    mydeque.removeTail();
    mydeque.removeTail();
    mydeque.printDeque();
    mydeque.addFront("piano1");
    mydeque.addFront("piano2");
    mydeque.addFront("piano3");
    mydeque.addFront("piano4");
    mydeque.addFront("piano5");
    mydeque.printDeque();
    mydeque.addTail("piano6");
    mydeque.printDeque();
    mydeque.addTail("piano7");
    mydeque.printDeque();
  
  }
}
