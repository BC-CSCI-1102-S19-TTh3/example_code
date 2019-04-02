public class HashCodeFun {

  public static void main (String[] args) {
    String s = "This is a reasonably long sentence with some words in it, and if we include enough we might get some collisions.";

    String[] words = s.split(" ");
    for (int i=0; i< words.length; i++) {
      int myhash = Math.abs(words[i].hashCode() % 13);
      System.out.println(words[i] +  " " + myhash);
    }

  }


}
