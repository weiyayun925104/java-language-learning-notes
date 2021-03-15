/*
  Write a program that prints the characters in the ASCII character table from
  ! to ~. Display ten characters per line. Characters are separated by exactly
  one space.
*/

public class E5_15 {
  public static void main(String[] args) {
    int count = 0;
    for (int i = 33; i <= 126; i++) {
      if (count == 10) {
        System.out.println();
        count = 0;
      }
      System.out.print((char)i + " ");
      count++;
    }
    System.out.println();
  }
}
