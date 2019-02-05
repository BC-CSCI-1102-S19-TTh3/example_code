class Cookie implements Comparable<Cookie> {

  String name;

  Cookie (String name) {
    this.name = name;
  }

  // chocolate chip cookies are better than peanut butter cookies
  // peanut butter cookies are better than gingersnaps
  public int compareTo(Cookie c) {
    if (this.name.equals(c.name)) {
      return 0;
    }
    if (this.name.equals("chocolate chip")) {
      return 1;
    }
    if (this.name.equals("peanut butter")) {
      if (c.name.equals("gingersnaps")) {
        return 1;
      }
    }
    return -1;
  }

  public static void main (String[] args) {
    Cookie c1 = new Cookie("chocolate chip");
    Cookie c2 = new Cookie("peanut butter");
    Cookie c3 = new Cookie("gingersnaps");

    System.out.println(c1.compareTo(c2));
    System.out.println(c1.compareTo(c3));
    System.out.println(c2.compareTo(c1));
    System.out.println(c3.compareTo(c1));
    System.out.println(c1.compareTo(c1));
    System.out.println(c2.compareTo(c3));
    System.out.println(c3.compareTo(c2));



  }

}
