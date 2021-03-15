/*
  Programming Exercise 5.45 computes the standard deviation of numbers. This
  exercise uses a different but equivalent formula to compute the standard
  deviation of n numbers.


            (mean and deviation formulae)

  To compute the standard deviation with this formula, you have to store the
  individual numbers using an array, so that they can be used after the mean
  is obtained. Your program should contain the following methods:

  public static double deviation(double[] x)
  public static double mean(double[] x)

  Write a test program that prompts the user to enter ten numbers and displays
  the mean and standard deviation.
*/

import java.util.Scanner;

public class E7_11 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter ten nubmers: ");

    double[] nums = new double[10];
    for (int i = 0; i < 10; i++) {
      nums[i] = input.nextDouble();
    }

    double mean = mean(nums);
    double deviation = deviation(nums);
    System.out.println("The mean is " + mean);
    System.out.println("The standard deviation is " + deviation);
  }

  public static double deviation(double[] x) {
    double sum = 0.0;
    double mean = mean(x);
    for (int i = 0; i < x.length; i++) {
      sum += Math.pow(x[i] - mean, 2);
    }
    return Math.sqrt(sum / (x.length - 1));
  }

  public static double mean(double[] x) {
    double sum = 0.0;
    for (int i = 0; i < x.length; i++) {
      sum += x[i];
    }
    return sum / x.length;
  }
}
