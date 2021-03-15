/*
  Write a program that reads integers, finds the largest of them, and counts
  its occurrences. Assume that the input ends with number 0. Suppose that you
  entered 3 5 2 5 5 5 0; the program finds that the largest is 5 and the
  occurrence count for 5 is 4.
*/

import java.util.Scanner;

public class E5_41 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int entry;
    int largest = 0;
    int largestOccurrences = 0;
    System.out.print("Enter an integer (0 ends input): ");
    do {
      entry = input.nextInt();

      if (entry == 0) {
        continue;
      }

      if (entry > largest) {
        largest = entry;
        largestOccurrences = 1;
      } else if (entry == largest) {
        largestOccurrences++;
      }

    } while (entry != 0);

    if (largest == 0) {
      System.out.println("No entries");
    } else {
      System.out.println("largest: " + largest);
      System.out.println("occurrences: " + largestOccurrences);  
    }
  }
}
