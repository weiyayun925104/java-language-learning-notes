/*
  Simplify Listing 3.9 using an array of strings to store the animal names.
*/

import java.util.Scanner;

public class E7_33 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter a year: ");
    int year = input.nextInt();

    String[] animals = {"monkey", "rooster", "dog", "pig", "rat", "ox",
      "tiger", "rabbit", "dragon", "snake", "horse", "sheep"};

    System.out.println(animals[year % 12]);
  }
}
