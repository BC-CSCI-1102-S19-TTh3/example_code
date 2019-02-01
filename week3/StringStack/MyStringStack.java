import java.util.ArrayList;

public class MyStringStack implements StringStack{

  ArrayList<String> storage;
  int size;

  MyStringStack() {
    this.storage = new ArrayList<String>();
    this.size = 0;
  }

  public void push(String s) {
    this.storage.add(s);
    this.size++;
  }

  public String pop() {
    if (isEmpty()) {
      return null;
    }
    String returnme = this.storage.get(size-1);
    this.storage.remove(size-1);
    size--;
    return returnme;

  }

  public String peek() {
    if (isEmpty()) {
      return null;
    }
    return this.storage.get(size-1);
  }
  public boolean isEmpty() {
    return (size == 0);
  }
  public String toString() {
    return this.storage.toString();
  }

  public static void main (String args[]) {
    MyStringStack mss = new MyStringStack();
    mss.push("light");
    mss.push("banana");
    mss.push("scarf");
    System.out.println(mss.toString());
    String top = mss.pop();
    System.out.println(top);
    System.out.println(mss.toString());




  }
}
