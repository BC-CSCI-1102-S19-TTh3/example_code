
public class BCArrayList implements BCList {

  // The array can't be bigger than 25.
  // Since it is independent of any particular instance, it's static.
  static int MAX_SIZE = 25;

  // Instance variables
  String[] theList;   // array for storing the list
  int size;           // variables for keepting track of size of list

  // contructor to initialize instance variables
  public BCArrayList(){
    this.size = 0;    // size starts off at 0

    // Then you need to initialize the storage array.
    // This means, you need to say how big the array
    // will be, and you need to set each element to null.
    this.theList = new String[MAX_SIZE];
    for (int i=0; i<theList.length; i++) {
      this.theList[i] = null;
    }
  }

  // methods to implement from interface
  public void add(String s) {

    // As long as the size of the list is less than the size of
    // the array, you can add a new element. You know where to
    // add it because you are keeping track of the current list size.
    if (this.size < MAX_SIZE) {
      this.theList[size] = s;
      this.size++;  // don't forget to increment the size variable
    }
    // Otherwise, just tell the client the list is full.
    else {
      System.out.println("The list is full.");
    }
  }


  public String get(int i) {
    // check to see if the client accidentally asked for a null element
    if (i >= size) {
      return null;
    }
    // otherwise, return the element that was asked for
    return this.theList[i];
  }

  public String remove(int i) {
    // if the client asks to remove an element that is null, let them know
    if (i >= this.size) {
      System.out.println("The index exceeds the size of the list.");
      return null;
    }
    // otherwise get the requested element
    String toreturn = this.theList[i];

    // and now you need to move everything after that index back one spot
    // otherwise you will have a random null element in the middle of your
    // list and you won't really have returned anything at all
    for (int j = i; j < size-1; j++) {
      this.theList[j] = this.theList[j+1];
    }
    this.theList[size-1] = null;
    size--;
    return toreturn;
  }

 // isEmpty, easy
  public boolean isEmpty() {
    return (this.size == 0);
  }

  // toString()
  public String toString() {

    // I'm using StringBuilder here because repeatedly appending
    // a String is inefficient.
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < this.size; i++) {
      sb.append(this.theList[i] + " ");
    }
    return sb.toString();
  }

  // main method testing the functionality of the code
  public static void main (String[] args) {
    BCArrayList bcal = new BCArrayList();
    bcal.add("dog");
    bcal.add("fish");
    bcal.add("coffee");
    bcal.add("television");
    bcal.add("orange");
    System.out.format("element at index %d is %s%n", 2, bcal.get(2));
    System.out.println(bcal.toString());
    bcal.remove(3);
    System.out.println(bcal.toString());


  }


}
