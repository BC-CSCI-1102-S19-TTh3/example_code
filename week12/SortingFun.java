public class SortingFun {

  // bubble sort
  static int[] bubble(int[] a) {

    int swaps = -1;

    // if swaps == 0, your array is sorted
    while (swaps != 0) {
      printArray(a);
      swaps = 0;

      // start at the beginning of the array
      for (int i=0; i< a.length-1; i++) {

        // if the next element is smaller, swap
        if (a[i] > a[i+1]) {
          swaps++;
          int temp = a[i+1];
          a[i+1] = a[i];
          a[i] = temp;
        }
      }
    }
    return a;
  }

  // selection sort
  static int[] selection(int[] a) {

    // start at the beginning of the array
    for (int i=0; i< a.length-1; i++) {
      printArray(a);

      // start assuming the minimum is what you're looking at now
      int min = a[i];
      int minindex = i;

      // look at each subsequent element, and reset min to that if necessary
      for (int j=i+1; j< a.length; j++) {
        if (a[j] < min) {
          min = a[j];
          minindex = j;
        }
      }

      // swap values of minindex and current index i
      int temp = a[i];
      a[i] = min;
      a[minindex] = temp;
    }
    return a;
  }

  // insertion sort
  static int[] insertion(int[] a) {

    // start at the second element of the array
    for (int i=1; i< a.length; i++) {
      printArray(a);

      // set aside your current value for insertion behind it
      int current = a[i];

      // look at previous values, and if they
      // are larger, move them forward by one;
      // otherwise, terminate inner loop by setting j to 0
      for (int j=i-1; j >= 0; j--) {
          if (a[j] > current) {
            a[j+1] = a[j];
            a[j] = current;
          } else {
            j = 0;
          }
      }
    }
    return a;
  }


  // function to check whether an array is sorted
  static boolean isSorted(int[] a) {
    for (int i=1; i< a.length; i++) {
        if (a[i] < a[i-1]) {
          return false;
        }
    }
    return true;
  }

  // function to print array nicely
  static void printArray(int[] a) {
    for (int i=0; i< a.length; i++) {
      System.out.format("%d ", a[i]);
    }
    System.out.println();
  }

  // main for testing sort methods
  public static void main (String[] args) {
    int[] myarray = new int[] { 8, 1, 4, 10, 2, 7, 4, 8 };
    printArray(myarray);

    System.out.println("\nBubble sort");
    int[] sortedarray = bubble(myarray.clone());
    printArray(sortedarray);

    System.out.println("\nSelection sort");
    sortedarray = selection(myarray.clone());
    printArray(sortedarray);

    System.out.println("\nInsertion sort");
    sortedarray = insertion(myarray.clone());
    printArray(sortedarray);

  }


}
