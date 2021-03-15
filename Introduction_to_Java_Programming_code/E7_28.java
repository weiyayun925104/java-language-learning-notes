/*
  Write a program that prompts the user to enter 10 integers and displays all
  combinations of picking two numbers from the 10.
*/

import java.util.Scanner;
import java.util.Arrays;

public class E7_28 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int[] list = eliminateDuplicates(getList(10, input));

    displayCombinations(list);
  }

  public static void displayCombinations(int[] list) {
    int combinations = 0;
    for (int i = 0; i < list.length; i++) {
      for (int j = 0; j < list.length; j++) {
        if (list[i] == list[j] || list[i] > list[j]) { continue; }
        System.out.printf("%d %d\n", list[i], list[j]);
        combinations++;
      }
    }
    System.out.println("The total number of all combinations is " +
      combinations);
  }

  public static int[] getList(int n, Scanner input) {
    System.out.print("Enter ten integers: ");
    int[] list = new int[n];
    for (int i = 0; i < list.length; i++) {
      list[i] = input.nextInt();
    }
    return list;
  }

  public static int[] eliminateDuplicates(int[] list) {
    int[] uniques = new int[list.length];
    int currentIndex = 0;
    for (int i = 0; i < list.length; i++) {
      boolean unique = true;
      for (int j = 0; j <= currentIndex; j++) {
        if (list[i] == uniques[j]) {
          unique = false;
          break;
        }
      }
      if (unique) {
        uniques[currentIndex] = list[i];
        currentIndex++;
      }
    }
    return Arrays.copyOf(uniques, currentIndex);
  }
}
