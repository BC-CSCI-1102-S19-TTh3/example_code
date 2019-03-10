public class ArrayBinaryTree<T> {

  // fixed size array with max capacity of 20
  int CAPACITY = 20;

  // instance variables for storing the PQ
  T[] data;
  int size;

  // constructor -uses trick to initialie array of T
  public ArrayBinaryTree() {
    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Object[CAPACITY];
    this.data = temp;
    this.size = 0;
  }

  // adds another item to bottom of tree
  public void insert(T item) {
    if (size == CAPACITY) {
      System.out.println("Tree is full!");
    } else {
      data[size+1] = item;
      size++;
    }
  }

  // removes and returns item from bottom of tree
  public T remove() {
    if (isEmpty()) {
      System.out.println("Tree is empty!");
      return null;
    } else {
      size--;
      return data[size];
    }
  }

  // isEmpty()
  public boolean isEmpty() {
    return (size == 0);
  }

  // size()
  public int size() {
    return size;
  }

  // returns a string in level-order (breadth first)
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i<= size; i++) {
      sb.append(data[i].toString());
    }
    return sb.toString();
  }

  // recursive preOrder traversal
  public String preOrder(int k) {
    if (k > size) {
      return "";
    }
    return data[k] + preOrder(k*2) + preOrder((k*2)+1);
  }

  // recursive inOrder traversal
  public String inOrder(int k) {
    if (k > size) {
      return "";
    }
    return inOrder(k*2) + data[k] + inOrder((k*2) + 1);
  }

  // recursive postOrder traversal
  public String postOrder(int k) {
    if (k > size) {
      return "";
    }
    return postOrder(k*2) + postOrder((k*2)+1) + data[k];
  }

  // Main method to test it all out.
  public static void main (String[] args) {
    ArrayBinaryTree<String> bt = new ArrayBinaryTree<String>();
    bt.insert("B");
    bt.insert("R");
    bt.insert("A");
    System.out.println(bt.toString());
    bt.insert("L");
    bt.insert("Z");
    System.out.println(bt.toString());
    bt.insert("F");
    bt.insert("K");
    bt.insert("E");

    // four different traverals
    System.out.println("Level order: " + bt.toString());
    System.out.println("Pre order: " +bt.preOrder(1));
    System.out.println("In order: " +bt.inOrder(1));
    System.out.println("Post order: " +bt.postOrder(1));

    // Making sure it works when I remove something
    bt.remove();
    bt.remove();

    System.out.println("Level order: " + bt.toString());
    System.out.println("Pre order: " +bt.preOrder(1));
    System.out.println("In order: " +bt.inOrder(1));
    System.out.println("Post order: " +bt.postOrder(1));
  }

}
