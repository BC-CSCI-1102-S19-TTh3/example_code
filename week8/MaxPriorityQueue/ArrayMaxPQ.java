public class ArrayMaxPQ<T extends Comparable<T>> implements MaxPQ<T> {

  // fixed size array with max capacity of 20
  int CAPACITY = 20;

  // instance variables for storing the PQ
  T[] data;
  int n;

  // Helper methods for reheapifying.
  // A bit different from the book -- no exch or less methods.

  // Call swim when you want to move a value up from the bottom.
  private void swim(int k) {

    // While you are not at the top (index 1), and your parent
    // is smaller than you are...
    while (k > 1 && data[k/2].compareTo(data[k]) < 0) {

      // swap yourself with your parent
      T temp = data[k];
      data[k] = data[k/2];
      data[k/2] = temp;

      // and keep trying to swim up from your new location.
      k = k/2;
    }
  }

  // Call sink when you want to move a value down from the top.
  private void sink(int k) {

    // If you have a left child...
    while (2*k <= n) {

      // Look at the left child, but...
      int j = 2*k;

      // ...if you have a right child, and the right child is bigger
      // than the left child, look at the right child instead.
      if (j < n && data[j].compareTo(data[j+1]) < 0) j++;

      // If the child you're looking at is smaller than you, you're all set.
      if (data[k].compareTo(data[j]) > 0) break;

      // Otherwise, swap with the child you're looking at.
      T temp = data[k];
      data[k] = data[j];
      data[j] = temp;

      //and keep trying to sink down from your new location.
      k = j;
    }
  }

  // constructor
  public ArrayMaxPQ() {
    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Comparable[CAPACITY];
    this.data = temp;
    this.n = 0;
  }

  // Interface methods

  // Remove and return the maximum element, which will be
  // at the top of the heap in array index 1.
  public T delMax() {
    if (isEmpty()) {
      throw new java.util.NoSuchElementException("Stack underflow");
    }

    // Set aside the thing to return.
    // Remember: the top element is at index 1, not index 0!
    T toreturn = data[1];

    // Replace the top element with the bottom element.
    // Remember: the top element is at index 1, not index 0!
    data[1] = data[n];

    // Decrement the size of the PQ.
    n--;

    // Sink that new top element down to where it belongs.
    sink(1);

    return toreturn;
  }

  // insert a new element into the correct place in the PQ
  public void insert(T key) {
    if (size() == CAPACITY) {
      throw new RuntimeException("Stack Overflow.");
    }

    // Increase the size of the PQ, and then put the new
    // value at the bottom of the PQ.
    n++;
    data[n] = key;

    // Swim the new value up to where it belongs.
    swim(n);
  }

  public boolean isEmpty() {
    return (n == 0);
  }

  public int size() {
    return n;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i<= n; i++) {
      sb.append(data[i].toString());
    }
    return sb.toString();
  }

  // Main method to test it all out.
  public static void main (String[] args) {
    ArrayMaxPQ<String> ampq = new ArrayMaxPQ<String>();
    ampq.insert("B");
    ampq.insert("R");
    ampq.insert("A");
    ampq.insert("L");
    ampq.insert("Z");
    ampq.insert("F");
    ampq.insert("K");
    ampq.insert("E");
    System.out.println(ampq.toString());
    System.out.println(ampq.delMax());
    System.out.println(ampq.toString());
    System.out.println(ampq.delMax());
    System.out.println(ampq.toString());
    System.out.println(ampq.delMax());
    System.out.println(ampq.toString());
    System.out.println(ampq.delMax());
    System.out.println(ampq.toString());
    System.out.println(ampq.delMax());
    System.out.println(ampq.toString());
    System.out.println(ampq.delMax());
    System.out.println(ampq.toString());
    System.out.println(ampq.delMax());
    System.out.println(ampq.delMax());


  }

}
