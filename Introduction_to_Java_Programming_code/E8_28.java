/*
  The two-dimensional arrays m1 and m2 are strictly identical if their
  corresponding elements are equal. Write a method that returns true if m1 and
  m2 are strictly identical, using the following header:

  public static boolean equals(int[][] m1, int[][] m2)

  Write a test program that prompts the user to enter two 3 x 3 arrays of
  integers and displays whether the two are strictly identical.
*/

import java.util.Scanner;

public class E8_28 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int[][] list1 = getInput("list1", input);
    int[][] list2 = getInput("list2", input);

    if (equals(list1, list2)) {
      System.out.println("The two arrays are strictly identical");
    } else {
      System.out.println("The two arrays are not strictly identical");
    }
  }

  public static boolean equals(int[][] m1, int[][] m2) {
    if (m1.length != m2.length) { return false; }

    for (int i = 0; i < m1.length; i++) {
      for (int j = 0; j < m1[i].length; j++) {
        if (m1[i].length != m2[i].length) { return false; }
        if (m1[i][j] != m2[i][j]) { return false; }
      }
    }

    return true;
  }

  public static int[][] getInput(String name, Scanner input) {
    System.out.print("Enter " + name + ": ");
    int[][] list = new int[3][3];
    for (int i = 0; i < list.length; i++) {
      for (int j = 0; j < list[i].length; j++) {
        list[i][j] = input.nextInt();
      }
    }
    return list;
  }
}
