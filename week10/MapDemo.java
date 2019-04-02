import java.util.HashMap;

public class MapDemo {

  public static void main (String[] args) {
    // instantiating a HashMap
    HashMap<String,Integer> mymap = new HashMap<String,Integer>();

    // adding key-value pairs to a Map
    mymap.put("dog",2);
    mymap.put("cat", 17);
    mymap.put("hamster", 1);
    mymap.put("houseplant", 5);

    // getting a value using a key
    Integer x = mymap.get("cat");

    // looping through keys in a dictionary
    for (String k : mymap.keySet()) {
      System.out.println(k + " " + mymap.get(k));
    }

    if (mymap.containsKey("cat")) {
      System.out.println("Cat is there!");
    }

  }
}
