import java.util.*;

public class HashMapExample {

  public static void main (String args[]) {

    // Creating a simple HashMap mapping a String to another String.
    HashMap<String, String> fave = new HashMap<String, String>();
    fave.put("Emily", "cat");
    fave.put("Amanda", "golden retriever");
    fave.put("Eleanor", "bunny");

    // Checking to see if the key is already there.
    // If not, let's add the new key-value pair to the map.
    if (!fave.containsKey("Jane")) {
      fave.put("Jane", "gorilla");
    }

    // Easy to iterate through the map using the for-each syntax.
    for (String k : fave.keySet()) {
      System.out.println(k + "'s favorite animal is " + fave.get(k));
    }

    // Let's say people are allowed to have more than one favorite animal.
    // Here's a HashMap with an ArrayList as the value for each key.
    HashMap<String, ArrayList<String>> allFaves = new HashMap<String, ArrayList<String>>();

    // We'll take the old HashMap, and use that data to create a new HashMap.
    for (String k : fave.keySet()) {
      ArrayList<String> animalList = new ArrayList<String>();
      animalList.add(fave.get(k));
      allFaves.put(k, animalList);
    }

    // Now we can start adding to everyone's list of favorite animals.
    if (allFaves.containsKey("Emily")) {
      ArrayList<String> animalList = allFaves.get("Emily");
      animalList.add("elephant");
      animalList.add("tiger");
    } else {
      ArrayList<String> animalList = new ArrayList<String>();
      animalList.add("elephant");
      animalList.add("tiger");
      allFaves.put("Emily", animalList);
    }

    // We'll take the old HashMap, and use that data to create a new HashMap.
    for (String k : allFaves.keySet()) {
      System.out.format("%s's favorite animals are ", k);
      for (String e : allFaves.get(k)) {
        System.out.format("%s ", e);
      }
      System.out.println();
    }


  }

}
