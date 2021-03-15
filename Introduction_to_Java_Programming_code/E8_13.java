/*
  Write the following method that returns the location of the largest
  element in a two-dimensional array.

  public static int[] locateLargest(double[][] a)

  The return value is a one-dimensional array that contains two elements. These
  two elements indicate the row and column indices of the largest element in
  the two-dimensional array. Write a test program that prompts the user to
  enter a two-dimensional array and displays the location of the largest
  element in the array.
*/

import java.util.Scanner;

public class E8_13 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    double[][] array = getInput(input);
    int[] largestLocation = locateLargest(array);

    System.out.println("The location of the largest element is at " +
      formatLocation(largestLocation));
  }

  public static String formatLocation(int[] loc) {
    return "(" + loc[0] + ", " + loc[1] + ")";
  }

  public static int[] locateLargest(double[][] a) {
    int[] location = {0, 0};
    double largest = a[0][0];

    for (int i = 1; i < a[0].length; i++) {
      if (a[0][i] > largest) {
        largest = a[0][i];
        location[0] = 0;
        location[1] = i;
      }
    }

    for (int i = 1; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        if (a[i][j] > largest) {
          largest = a[i][j];
          location[0] = i;
          location[1] = j;
        }
      }
    }

    return location;
  }

  public static double[][] getInput(Scanner input) {
    System.out.print("Enter the number of rows and columns in the array: ");
    double[][] array = new double[input.nextInt()][input.nextInt()];
    System.out.println("Enter the array:");
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        array[i][j] = input.nextDouble();
      }
    }
    return array;
  }
}
