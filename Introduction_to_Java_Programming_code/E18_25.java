/*
  Write a recursive method to print all the permutations of a string. For
  example, for the string abc, the permutation is

  abc
  acb
  bac
  bca
  cab
  cba

  Write a program that lets the user enter a string and displays all its
  permutations.
*/

import java.util.Scanner;

public class E18_25 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String s = input.nextLine();

    displayPermutation(s);
  }

  public static void displayPermutation(String s) {
    displayPermutation("", s);
  }

  public static void displayPermutation(String s1, String s2) {
    if (s2.length() == 0) {
      System.out.println(s1);
    }

    for (int i = 0; i < s2.length(); i++) {
      // first loop of recursive calls sets up the three simple cases of
      // permutations that begin with each character in the initial string.
      // e.g. (a, bc) (b, ac) (c, ab)

      // recursive calls spawned by each of those yield their respective
      // permutations
      // e.g. abc, acb; bac, bca; cab, cba
      displayPermutation(
        s1 + s2.charAt(i), s2.substring(0, i) + s2.substring(i + 1));
    }
  }
}
