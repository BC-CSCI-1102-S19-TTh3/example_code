public class BinSearch {

  // iterative binary search
  static boolean bsearchIt(int[] a, int target) {

    // we start with hi pointing at the last element
    // and lo pointing at the first element
    int hi = a.length - 1;
    int lo = 0;

    // We're going to be moving hi and lo depending on
    // whether the middle is < or > than the target.
    // If lo gets to be greater than hi, then we've searched
    // the whole array without finding anything.
    while (lo <= hi) {

      // Calcualte mid each time you change hi or lo.
      int mid = (lo+hi)/2;

      // If you find a match, return true!
      if (a[mid] == target) {
        return true;
      }
      // Otherwise you need to adjust hi if the target is
      // less than the middle, or adjust lo if target is
      // greater than the middle.
      if (target < a[mid]) {
        hi = mid-1;
      } else {
        lo = mid+1;
      }
    }
    // If you got all the way through the while loop without
    // finding a match, the target was not found, so return false.
    return false;
  }

  // Recursive binary search.
  // Because you call the method on itself, the parameters
  // need to include both lo and hi.
  static boolean bsearchRe(int[] a, int target, int lo, int hi) {
    // Everytime it's called, lo or hi will be different, so
    // you need to calculate mid.
    int mid = (lo+hi)/2;

    // Base case 1: lo crosses hi; return false.
    if (lo > hi) {
      return false;
    }
    // Base case 2: you found a match; return true.
    else if (a[mid] == target) {
      return true;
    }
    // Recursive call in two parts.
    else {

      // If the target is smaller than the middle, call the
      // method on the lower half of the array.
      if (target > a[mid]) {
        return bsearchRe(a, target, mid+1, hi);
      }

      // Otherwise, the target is larger than the middle,
      // so call the method on the upper half of the array.
      else {
        return bsearchRe(a, target, lo, mid-1);
      }
    }

  }

  // Main method for testing.
  public static void main (String[] args) {

    // we'll be searching in the array q
    int[] q = {1, 2, 6, 8, 10, 24, 47, 67};

    // Let's search for each of the elements below
    // in the array, q.
    int[] lookfor = {0, 2, 6, 9, 10, 24, 47, 67, 100};
    for (int i=0; i<lookfor.length; i++) {
      boolean b = bsearchRe(q, lookfor[i], 0, q.length-1);
      if (b==true) {
        System.out.println("Found: " + lookfor[i]);
      } else {
        System.out.println("Not found: " + lookfor[i]);
      }

    }

  }

}
