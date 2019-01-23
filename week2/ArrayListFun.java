// ArrayList doesn't come for free.
// You need to import it from java.util as follows:
import java.util.ArrayList;

// We're also going to use another class called Arrays.
// This has some helper functions for arrays.
import java.util.Arrays;

public class ArrayListFun {

  public static void main (String[] args) {
    // Here's a regular array of integers.
    // You can't make it longer or shorter!
    Integer[] intarray = {1, 4, 2, 6, 10};

    // Here are two ways of creating an ArrayList that
    // has the same elements as the above array.

    // Option 1
    ArrayList<Integer> intarraylist1 = new ArrayList<Integer>();
    for (int i=0; i < intarray.length; i++) {
      intarraylist1.add(intarray[i]);
    }

    // Option 2, using Arrays helper class
    ArrayList<Integer> intarraylist2 = new ArrayList<Integer>(Arrays.asList(intarray));

    // Print them out in two different way.

    // Here's how you could print out the regular array with a for loop.
    // To get the length of an array, you use the length field.
    for (int i=0; i < intarray.length; i++) {
      System.out.println(intarray[i]);
    }

    // Here's how you print out an ArrayList with a regular for loop.
    // To get the length of an ArrayList you use the size() method.
    // To access an element in an ArrayList you use the get() method.
    for (int i=0; i < intarraylist2.size(); i++) {
      System.out.println(intarraylist2.get(i));
    }

    // Here's another way to print out an ArrayList with a "for each" loop
    // which is similar to the "for i in array" syntax in Python.
    for (Integer i : intarraylist1) {
      System.out.println(i);
    }



  }

}
