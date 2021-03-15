/*
  A Latin square is an n-by-n array filled with n different Latin letters, each
  occurring exactly once in each row and once in each column. Write a program
  that prompts the user to enter the number n and the array of characters, and
  checks if the input array is a Latin square. The characters are the first n
  characters starting from A.
*/

import java.util.Scanner;

public class E8_36 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    char[][] c = getInput(input);

    if (isLatinSquare(c)) {
      System.out.println("The input array is a Latin square");
    } else {
      System.out.println("The input array is not a Latin square");
    }
  }

  public static boolean isLatinSquare(char[][] c) {
    // get size of square
    int n = c.length;

    // create counting array with the length of c's size
    int[] counts = new int[n];

    // check the rows of c
    for (int i = 0; i < c.length; i++) {
      // increment appropriate index in counts
      for (int j = 0; j < c[i].length; j++) {
        counts[c[i][j] - 97]++;
      }
      // check counts array for any non-1 values
      for (int k = 0; k < counts.length; k++) {
        if (counts[k] != 1) { return false; }
      }
      // clear counts
      clearArray(counts);
    }

    // check the columns of c
    for (int i = 0; i < c[0].length; i++) {
      // increment appropriate index in counts
      for (int j = 0; j < c.length; j++) {
        counts[c[j][i] - 97]++;
      }
      // check counts array for any non-1 values
      for (int k = 0; k < counts.length; k++) {
        if (counts[k] != 1) { return false; }
      }
      // clear counts
      clearArray(counts);
    }

    return true;
  }

  public static char[][] getInput(Scanner input) {
    System.out.print("Enter number n: ");
    int n = input.nextInt();

    System.out.println("Enter 4 rows of letters separated by spaces:");
    char[][] c = new char[n][n];
    for (int i = 0; i < c.length; i++) {
      for (int j = 0; j < c[i].length; j++) {
        c[i][j] = input.next().toLowerCase().charAt(0);
        if (c[i][j] < 97 || c[i][j] >= (97 + n)) {
          System.out.println("Wrong input: the letters must be from " +
            (char)65 + " to " + (char)(65 + n - 1));
          System.exit(1);
        }
      }
    }
    return c;
  }

  public static void clearArray(int[] a) {
    for (int i = 0; i < a.length; i++) {
      a[i] = 0;
    }
  }
}
