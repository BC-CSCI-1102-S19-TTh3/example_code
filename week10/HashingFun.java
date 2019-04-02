public class HashingFun {

  public static void main (String[] args) {
    String s = "This is a long example where there might end up being some words that have the same hash code as each other. If we make it long enoughm, it will!";
    String[] words = s.split(" ");
    for (int i=0; i<words.length; i++) {
      int hashy = Math.abs(words[i].hashCode() % 31);
      System.out.println(words[i] + " " + hashy);
    }
    Double d = 10285621.23;
    System.out.println(d.hashCode());
  }
}
