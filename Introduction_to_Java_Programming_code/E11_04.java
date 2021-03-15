/*
  Write the following method that returns the maximum value in an ArrayList of
  integers. The method returns null if the list is null or the list size is 0.

  public static Integer max(ArrayList<Integer> list)

  Write a test program that prompts the user to enter a sequence of numbers
  ending with 0, and invokes this method to return the largest number in the
  input.
*/

import java.util.Scanner;
import java.util.ArrayList;

public class E11_04 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    ArrayList<Integer> list = getInput(input);

    System.out.println(max(list));
  }

  public static Integer max(ArrayList<Integer> list) {
    int maxValue = list.get(0);
    for (int i = 1; i < list.size(); i++) {
      int elem = list.get(i);
      if (elem > maxValue) { maxValue = elem; }
    }
    return maxValue;
  }

  public static ArrayList<Integer> getInput(Scanner input) {
    System.out.println("Enter a list of integers terminated by 0:");
    ArrayList<Integer> list = new ArrayList<>();
    while (true) {
      int element = input.nextInt();
      if (element == 0) { break; }
      list.add(element);
    }
    return list;
  }
}
