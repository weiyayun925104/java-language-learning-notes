/*
  Write a program that reads an unspecified number of scores and determines
  how many scores are above or equal to the average and how many scores are
  below the average. Enter a negative number to signify the end of the input.
  Assume that the maximum number of scores is 100.
*/

import java.util.Scanner;
import java.util.ArrayList;

public class E7_04 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter scores (negative number ends entry): ");

    int entry = input.nextInt();
    ArrayList<Integer> numArr = new ArrayList<>();
    while (entry >= 0) {
      numArr.add(entry);
      entry = input.nextInt();
    }

    double average = getAverageScore(numArr);

    int aboveOrEqualCount = 0;
    int belowCount = 0;
    for (int n: numArr) {
      if (n >= average) { aboveOrEqualCount++; }
      else { belowCount++; }
    }

    System.out.println("Above (or equal to) average: " + aboveOrEqualCount);
    System.out.println("Below average: " + belowCount);
  }

  private static double getAverageScore(ArrayList<Integer> arr) {
    double sum = 0.0;
    for (int n: arr) {
      sum += n;
    }
    return sum / arr.size();
  }
}
