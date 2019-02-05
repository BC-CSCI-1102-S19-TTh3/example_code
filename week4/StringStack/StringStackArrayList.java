import java.util.ArrayList;

public class StringStackArrayList implements StringStack{

  ArrayList<String> storage;   // ArrayList for storing the stack
  int size;                    // explicitly keeping track of the size

  // Note: the end of the ArrayList will be the top of the stack

  // constructor to initialize instance variables
  StringStackArrayList() {
    this.storage = new ArrayList<String>();
    this.size = 0;
  }

  // push: call add on the ArrayList, increment size
  public void push(String s) {
    this.storage.add(s);
    this.size++;
  }

  // pop: remove and return top element
  public String pop() {
    // check if it's empty
    if (isEmpty()) {
      return null;
    }
    // get the top to return
    String returnme = this.storage.get(size-1);
    // remove the top
    this.storage.remove(size-1);
    // decrement size
    size--;
    return returnme;

  }

  // peek(): return but do not remove top elemnent
  public String peek() {
    if (isEmpty()) {
      return null;
    }
    return this.storage.get(size-1);
  }

  // isEmpty: basic
  public boolean isEmpty() {
    return (size == 0);
  }

  // You can call the toString() method on ArrayList here
  public String toString() {
    return this.storage.toString();
  }

  public static void main (String args[]) {
    StringStackArrayList mss = new StringStackArrayList();
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
