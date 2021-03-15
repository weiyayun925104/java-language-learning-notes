/*
  Write a program that reads in ten numbers and displays the number of distinct
  numbers and the distinct numbers separated by exactly one space (ie if a
  number appears multiple times, it is displayed only once).
*/

import java.util.Scanner;
import java.util.HashSet;

public class E7_05 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter ten numbers: ");

    HashSet<Integer> nums = new HashSet<>();
    for (int i = 0; i < 10; i++) {
      nums.add(input.nextInt());
    }

    System.out.println("The number of distinct numbers is " + nums.size());
    System.out.print("The distinct numbers are: ");
    for (int num: nums) {
      System.out.print(num + " ");
    }
    System.out.println();
  }
}
