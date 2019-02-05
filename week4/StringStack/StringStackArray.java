import java.util.ArrayList;

public class StringStackArray implements StringStack{

  // static variable:
  static int MAX_SIZE = 25;

  // instance variables
  String[] storage;   // array for storing stack
  int size;           // number of strings currently in the stack

  // Note: the top of the stack corresponds size-1

  // constructor to initialize instance variables
  StringStackArray() {
    this.storage = new String[MAX_SIZE];
    this.size = 0;
  }

  // push: add element to top of stack, increment size
  public void push(String s) {
    if (size < MAX_SIZE) {
      this.storage[size] = s;
      this.size++;
    }
  }

  // pop: remove and return top element
  public String pop() {
    // check if it's empty
    if (isEmpty()) {
      return null;
    }
    // get the top to return
    String returnme = this.storage[size-1];
    this.storage[size-1] = null;
    // decrement size
    this.size--;
    return returnme;

  }

  // peek(): return but do not remove top elemnent
  public String peek() {
    if (isEmpty()) {
      return null;
    }
    return this.storage[size-1];
  }

  // isEmpty: basic
  public boolean isEmpty() {
    return (this.size == 0);
  }

  // You can't call the toString() method on an array! Must for loop
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<size; i++) {
      sb.append(this.storage[i] + " ");
    }
    return sb.toString();

  }

  public static void main (String args[]) {
    StringStackArray mss = new StringStackArray();
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
