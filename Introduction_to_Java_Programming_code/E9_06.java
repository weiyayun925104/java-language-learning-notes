/*
  Design a class named Stopwatch. The class contains:

  - Private data fields startTime and endTime with getter methods.
  - A no-arg constructor that initializes startTime with the current time.
  - A method named start() that resets the startTime to the current time.
  - A method named stop() that sets the endTime to the current time.
  - A method named getElapsedTime() that returns the elapsed time for the
    stopwatch in milliseconds.

  Write a test program that measures the execution time of sorting 100,000
  numbers using selection sort.
*/

public class E9_06 {
  public static void main(String[] args) {
    double[] nums = getRandomNumArray(100_000);
    Stopwatch sw = new Stopwatch();

    sw.start();
    selectionSort(nums);
    sw.stop();

    System.out.println("selection sort on 100,000 doubles executed in " +
      sw.getElapsedTime() + "ms");
  }

  public static double[] getRandomNumArray(int count) {
    double[] nums = new double[count];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = Math.random() * count;
    }
    return nums;
  }

  public static void selectionSort(double[] nums) {
    for (int i = nums.length - 1; i >= 0; i--) {
      double largest = nums[0];
      int index = 0;
      for (int j = 0; j <= i; j++) { // find largest and its index
        if (nums[j] > largest) {
          largest = nums[j];
          index = j;
        }
      }
      // swap largest with value in index i
      double temp = nums[i];
      nums[i] = nums[index];
      nums[index] = temp;
    }
  }
}
