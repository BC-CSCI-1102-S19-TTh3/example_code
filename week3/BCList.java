
public interface BCList {

  void add(String s);          // add s to end of list
  String get(int i);           // retrieve element at index i
  String remove(int i);        // removes and retrieves element at index i
  boolean isEmpty();           // return true if list is empty
  String toString();           // return list of elements as a String

}
