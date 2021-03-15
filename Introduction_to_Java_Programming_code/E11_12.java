/*
  Write the following method that returns the sum of all numbers in an
  ArrayList:

  public static double sum(ArrayList<Double> list)

  Write a test program that prompts the user to enter 5 numbers, stores them in
  an array list, and displays their sum.
*/

import java.util.Scanner;
import java.util.ArrayList;

public class E11_12 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    ArrayList<Double> list = getNumbers(input);
    double sum = sum(list);

    System.out.println(sum);
  }

  public static double sum(ArrayList<Double> list) {
    double sum = 0.0;
    for (int i = 0; i < list.size(); i++) {
      sum += list.get(i);
    }
    return sum;
  }

  public static ArrayList<Double> getNumbers(Scanner input) {
    System.out.print("Enter five numbers: ");
    ArrayList<Double> list = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      list.add(input.nextDouble());
    }
    return list;
  }
}
