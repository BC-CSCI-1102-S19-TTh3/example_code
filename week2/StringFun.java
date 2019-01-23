public class StringFun {

  public static void main (String[] args) {

    // Here are some strings
    String s1 = "Boston";
    String s2 = "College";
    String s3 = "Chestnut Hill";

    // Here are some methods on strings that you might like.

    // length(0)
    System.out.format("%s is %d letters long%n", s1, s1.length());

    // charAt()
    System.out.println(s1.charAt(5));
    if (s2.contains("e")) {
      System.out.println("This word has an e!");
    }

    // split(): separates a string into an array of strings
    // using whatever is the argument of split. Here it's space.
    // Remember: to find the length of an array use the length field.
    // To find the length of a string (not an array) use the length() method.
    String[] letters = s3.split(" ");
    for (int i=0; i<letters.length; i++) {
      System.out.println("The word at position " + i + " is " + letters[i]);
    }

    // equals() (don't use == !)
    if (s1.equals(s2)) {
      System.out.format("%s is the same as %s%n", s1, s2);
    } else {
      System.out.format("%s is not the same as %s%n", s1, s2);
    }

    // compareTo() (don't use < or >)
    if (s1.compareTo(s2) < 0) {
      System.out.format("%s comes before %s%n", s1, s2);
    } else {
      System.out.format("%s comes after %s%n", s1, s2);
    }


  }
}
