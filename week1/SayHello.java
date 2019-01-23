public class SayHello {

  static void sayHi() {
    System.out.println("Hi there!");
  }

  static void sayHiWithName(String s) {
    System.out.format("Hi there, %s!\n", s);
  }

  static double take_average(double d1, double d2, double d3) {
    double result = (d1+d2+d3) / 3;
    return result;
  }

  public static void main (String[] args) {
    sayHi();
    sayHiWithName(args[0]);
    System.out.println(take_average(3.0, 4.2, 89.340));

    int x = 12;
    String y = "seltzer";
    double z = 3.14;
    System.out.format("My favorite drink is %s, my favorite number is %d, ", y, x);
    System.out.format("and my favorite truncation of pi is %.2f%n", z);

  }

}
