import java.util.HashMap;
import java.util.TreeMap;


public class MapFun {

  public static void main (String[] args) {

    // You can see how TreeMap and HashMap behave differently.
    TreeMap<String, Integer> myhm = new TreeMap<String,Integer>();
    //HashMap<String, Integer> myhm = new HashMap<String,Integer>();

    // Add key-value pairs to the Map
    myhm.put("couch", 2);
    myhm.put("dining room table", 1);
    myhm.put("bed", 4);
    myhm.put("tv", 1);

    // Print them out
    for (String s : myhm.keySet()) {
      System.out.println("I have " + myhm.get(s) + " " + s + "s");
    }

    // Check to see if the Map contains some key
    if (myhm.containsKey("bed")) {
      System.out.println("found!");
    }

    // Replace the value of some key's value
    myhm.put("couch", 1);

    // Print them out again
    for (String s : myhm.keySet()) {
      System.out.println("I have " + myhm.get(s) + " " + s + "s");
    }


  }


}
