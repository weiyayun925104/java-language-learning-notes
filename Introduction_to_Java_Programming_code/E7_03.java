/*
  Write a program that reads the integers between 1 and 100 and counts the
  occurrences of each. Assume the input ends with 0.
*/

import java.util.Scanner;

public class E7_03 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the integers between 1 and 100: ");

    int entry;
    int[] occurrences = new int[101];
    do {
      entry = input.nextInt();
      occurrences[entry]++;
    } while (entry != 0);

    for (int i = 1; i <= 100; i++) {
      if (occurrences[i] > 0) {
        String output = i + " occurs " + occurrences[i];
        output += occurrences[i] > 1 ? " times" : " time";
        System.out.println(output);
      }
    }
  }
}
