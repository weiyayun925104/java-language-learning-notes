/*
  In business applications, you are often asked to compute the mean and the
  standard deviation of data. The mean is simply the average of the numbers.
  The standard deviation is a statistic that tells you how tightly all the
  various data are clustered around the mean in a set of data. For example,
  what is the average age of the students in a class? How close are the ages?
  If all the students are the same age, the deviation is 0.

  Write a program that prompts the user to enter ten numbers, and displays the
  mean and standard deviation of these numbers.
*/

import java.util.Scanner;

public class E5_45 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter ten numbers: ");

    double sum = 0.0;
    double sumOfSquares = 0.0;

    for (int i = 0; i < 10; i++) {
      double entry = input.nextDouble();
      sum += entry;
      sumOfSquares += entry * entry;
    }

    double mean = sum / 10;
    double deviation = Math.sqrt((sumOfSquares - ((sum * sum) / 10)) /
      (10 - 1));

    System.out.println("The mean is " + mean);
    System.out.println("The standard deviation is " + deviation);
  }
}
