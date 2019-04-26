public class MergeSortTopDown {


  // The merge method
  /* input: arr - the array you want to sort
            aux - the array you'll use for copying
            lo - where the left subarray begins
            mid - where the left subarray ends
            hi - where the right subarray ends
  */
  private static void merge(int[] arr, int[] aux, int lo, int mid, int hi) {

    // copy everything from arr to aux[]
    for (int k = lo; k <= hi; k++) {
      aux[k] = arr[k];
    }

    // merge the two subarrays and copy the sorted result back to arr

    // i keeps track of where we are in the left subarray
    // j keeps track of where we are in the right subarray
    int i = lo;
    int j = mid+1;

    // start at the start index, and go up the final index
    for (int k = lo; k <= hi; k++) {

      // if i is now larger than where the left subarray ends
      // then you've run out of elements in the left subarray,
      // so start copying over the remaining elements from right subarray
      if  (i > mid) {
        arr[k] = aux[j++];
      }

      // if j is now larger than where the right subarray ends
      // then you've run out of elements in the right subarray,
      // so start copying over the remaining elements from left subarray
      else if (j > hi) {
        arr[k] = aux[i++];
      }

      // if neither of those conditions applies, compare the latest
      // elements in the right and left subarrays, and add the
      // smaller of the two to the array
      else if (aux[j] < aux[i]) {
        arr[k] = aux[j++];
      }
      else {
        arr[k] = aux[i++];
      }
    }
  }

  // This is the recursive function that breaks the array down into
  // smaller subarrays and then calls
  private static void sort(int[] arr, int[] aux, int lo, int hi) {

      // if hi <= lo, then you're done sorting the subarray
      if (hi <= lo) return;

      // calculate the midpoint (integer division so round down)
      int mid = lo + (hi - lo) / 2;

      // call sort on the left subarray
      sort(arr, aux, lo, mid);

      // call sort on the right subarray
      sort(arr, aux, mid + 1, hi);

      // merge the two subarrays
      merge(arr, aux, lo, mid, hi);
  }

  // This starts off the sort by calling the recursive algorithm for the first time
  public static void sort(int[] arr) {
      int[] aux = new int[arr.length];
      sort(arr, aux, 0, arr.length-1);
  }

  // main to test it out: create an array, print, sort print
  public static void main (String[] args) {
    int[] myarray = new int[]{ 3, 7, 1, 8, 20, 34, 5, 6 };
    for (int i=0; i<myarray.length; i++) {
      System.out.format("%d, ", myarray[i]);
    }
    System.out.println();

    sort(myarray);

    for (int i=0; i<myarray.length; i++) {
      System.out.format("%d, ", myarray[i]);
    }
    System.out.println();


  }


}
