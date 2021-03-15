/*
  Write a program that prompts the user to enter three cities and displays
  them in ascending order.
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class E4_24 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the first city: ");
    String city1 = input.nextLine();
    System.out.print("Enter the second city: ");
    String city2 = input.nextLine();
    System.out.print("Enter the third city: ");
    String city3 = input.nextLine();

    ArrayList<String> cities = new ArrayList<>();
    cities.add(city1);
    cities.add(city2);
    cities.add(city3);

    Collections.sort(cities);

    System.out.print("The three cities in alphabetical order are ");
    for (String city: cities) {
      System.out.print(city + " ");
    }
    System.out.println();
  }
}
