public class MergeSortBottomUp {


  // The merge method - same as for top down!
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

  // sort method: not recursive for bottom-up
  public static void sort(int[] arr) {

    // create your aux array for copying
    int n = arr.length;
    int[] aux = new int[n];

    // outer loop indicates how long the subarrays to merge will be
    // starting with subarrays of size 1, then size 2, then size 4 etc.
    for (int len = 1; len < n; len *= 2) {

      // merge needs to know lo, mid, and hi indices
      // when len=1, lo starts at 0, then goes to 2, then 4, then 6...
      // when len=2, lo starts at 0, then goes to 4, then 8, then 12...
      for (int lo = 0; lo < n-len; lo += len+len) {

        // easy to calculate mid
        int mid  = lo+len-1;

        // hi will be the smaller of (1) n-1 (the last array element)
        // or (2) the lo plus the lengths of both arrays minus 1
        // this is to account for arrays where the length is not a power of 2
        int hi = Math.min(lo+len+len-1, n-1);

        // call merge to merge the two indicated subarrays
        merge(arr, aux, lo, mid, hi);
      }
    }
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
