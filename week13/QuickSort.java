public class QuickSort {

  // This calls the recursive sort algorithm
  static void sort(int[] arr) {
    sort(arr, 0, arr.length - 1);
  }

  // arguments to sort are the full array and the left and right indices
  // of the currenbt partition
  static void sort(int[] arr, int left, int right) {

    // if your start point and end point are the same or cross, you're done
    // (this will happen if you have an array of size 1)
    if (right <= left) {
      return;
    }

    // Otherwise: call partition (see below) which will return the midpoint
    int j = partition(arr, left, right);

    // Then sort the left subarray and the right subarray
    sort(arr, left, j-1);
    sort(arr, j+1, right);
  }


  // This does the actual moving and comparing.
  static int partition(int[] arr, int left, int right) {

    // Make pointers to the start and end of the current partition.
    // Remember that the first element is the pivot, so it's not included.
    int i = left + 1;
    int j = right;

    // Save out the value of the pivot (the first element)
    int pivot = arr[left];

    // All the break statements are how you get out of this loop.
    // In other words, you will break out of this outer while loop
    // when when i crosses j, when you hit the end of the partition while
    // searching for an element bigger than the pivot, or
    // when you hit the beginning of the partition while searching for an
    // element smaller than the pivot.
    while (true) {

      // move the left pointer until you find a value larger than your pivot
      while (arr[i] < pivot) {
        i++;
        if (i == right) { break; }
      }

      // move the right pointer until you find a value smaller than your pivot
      while (arr[j] > pivot) {
        j--;
        if (j == left) { break; }
      }

      if (i >= j) { break; }

      // Swap the two values you stopped at above.
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }

    // Finally, when i and j have crossed, swap the pivot value
    // with the value at the index where j crossed i
    int temp = arr[j];
    arr[j] = arr[left];
    arr[left] = temp;

    // Return that midpoint to the sort algorithm so it knows
    // where the next two partitions will be.
    return j;
  }

  // main method
  public static void main (String[] args) {

    int[] myarray = new int[]{ 3, 7, 1, 55, 8, 20, 34, 4, 5, 6, 11 };
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
