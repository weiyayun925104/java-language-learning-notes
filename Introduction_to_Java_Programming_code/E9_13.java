/*
  Design a class named Location for locating a maximal value and its location
  in a two-dimensional array. The class contains public data fields row,
  column, and maxValue that store the maximal value and its indices in a
  two-dimensional array with row and column as int types and maxValue as a
  double type.

  Write the following method that returns the location of the largest element
  in a two-dimensional array:

  public static Location locateLargest(double[][] a)

  The return value is an instance of Location. Write a test program that
  prompts the user to enter a two-dimensional array and displays the location
  of the largest element in the array.
*/

import java.util.Scanner;

public class E9_13 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    double[][] nums = getInput(input);
    Location largest = locateLargest(nums);

    System.out.println("The location of the largest element is " +
      largest.maxValue + " at (" + largest.row + ", " + largest.column + ")");
  }

  public static double[][] getInput(Scanner input) {
    System.out.print("Enter the number of rows and columns in the array: ");
    double[][] arr = new double[input.nextInt()][input.nextInt()];
    System.out.println("Enter the array: ");
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = input.nextDouble();
      }
    }
    return arr;
  }

  public static Location locateLargest(double[][] a) {
    Location loc = new Location();
    loc.row = 0;
    loc.column = 0;
    loc.maxValue = a[0][0];

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        if (a[i][j] > loc.maxValue) {
          loc.row = i;
          loc.column = j;
          loc.maxValue = a[i][j];
        }
      }
    }

    return loc;
  }
}
