public class MyPoint implements Point {

  double x;
  double y;

  MyPoint(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return this.x;
  }
  public double getY() {
    return this.y;
  }

  public boolean equals(Point p) {
    if ( (this.getY() == p.getY()) && (this.getX() == p.getX())) {
      return true;
    } else {
      return false;
    }

  }
  public String toString() {
    String s = "(" + this.getX() + ", " + this.getY() + ")";
    return s;
  }

  public static void main (String[] args) {
    MyPoint mp = new MyPoint(2.5, 11);
    MyPoint otherpoint = new MyPoint(2.5, 11);
    if (mp.equals(otherpoint)) {
      System.out.println(mp.toString() + " is the same as " + otherpoint.toString());
    } else {
      System.out.println(mp.toString() + " is not the same as " + otherpoint.toString());
    }

    System.out.println(mp.getX() + ", " + mp.getY());
    System.out.println(mp.toString());
  }

}
