import java.util.*;

public class TreeVsHash {

  public static void main (String[] args) {

    System.out.println("HashMap keys are in no particular order.");
    HashMap<String,Integer> hm = new HashMap<String,Integer>();
    hm.put("little", 1);
    hm.put("bigger", 5);
    hm.put("even bigger", 10);
    hm.put("really big!", 100);

    for (String s : hm.keySet()) {
      System.out.println(s + " " + hm.get(s));
    }

    System.out.println("\nLinkedHashMap keys are in order of insertion.");

    LinkedHashMap<String,Integer> lhm = new LinkedHashMap<String,Integer>();
    lhm.put("little", 1);
    lhm.put("bigger", 5);
    lhm.put("even bigger", 10);
    lhm.put("really big!", 100);

    for (String s : lhm.keySet()) {
      System.out.println(s + " " + lhm.get(s));
    }

    System.out.println("\nTreeMap keys in their natural order (alphabetical here).");

    TreeMap<String,Integer> tm = new TreeMap<String,Integer>();
    tm.put("little", 1);
    tm.put("bigger", 5);
    tm.put("even bigger", 10);
    tm.put("really big!", 100);

    for (String s : tm.keySet()) {
      System.out.println(s + " " + tm.get(s));
    }




  }

}
