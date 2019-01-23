import java.util.*;

public class WrapperFun {
  public static void main (String[] args) {

    // You can perform operations on wrappers
    int a = 5;
    Integer b = 10;
    int c = a * b; // unboxing: Integer b becomes an int

    // If you wanted a collection (like an ArrayList) of
    // primitives, you would have to use the wrapper instead.
    ArrayList<Integer> myIntList = new ArrayList<Integer>();
    myIntList.add(a); // autoboxing: int a becomes an Integer
    myIntList.add(b);
    myIntList.add(c);

    // Here's how you would turn a String (args[0]) into a integer!
    // You need this for PS2!
    int multiplyme = 5;
    Integer result = multiplyme * Integer.parseInt(args[0]);

    // And this will turn a integer into a string.
    String stringInt = result.toString();
    System.out.format("The first digit in %d is %c%n", result, stringInt.charAt(0));



  }
}
