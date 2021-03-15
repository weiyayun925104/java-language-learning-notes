/*
  Write a method that prints characters using the following header:

  public static void printChars(char ch1, char ch2, int numberPerLine)

  This method prints the characters between ch1 and ch2 with the specified
  numbers per line. Write a test program that prints ten characters per line
  from 1 to Z. Characters are separated by exactly one space.
*/

public class E6_12 {
  public static void main(String[] args) {
    printChars('1', 'Z', 10);
  }

  public static void printChars(char ch1, char ch2, int numberPerLine) {
    int count = 0;
    for (int i = (int)ch1; i <= (int)ch2; i++) {
      System.out.print((char)i + " ");
      count++;
      if (count % numberPerLine == 0) {
        System.out.println();
      }
    }
    System.out.println();
  }
}
