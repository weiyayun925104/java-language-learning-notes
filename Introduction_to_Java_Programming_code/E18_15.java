/*
  Rewrite Programming Exercise 18.10 using a helper method to pass the
  substring high index to the method. The helper method header is:

  public static int count(String str, char a, int high)

  [Almost identical to E18_10, which also uses a recursive helper method to
   avoid creating new strings with the substring method]
*/

import java.util.Scanner;

public class E18_15 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String s = input.nextLine();
    System.out.print("Enter a character: ");
    char c = input.nextLine().charAt(0);

    System.out.println(count(s, c));
  }

  public static int count(String str, char a) {
    return count(str, a, 0);
  }

  private static int count(String str, char a, int high) {
    if (high < str.length()) {
      int match =
        str.toLowerCase().charAt(high) == Character.toLowerCase(a) ? 1 : 0;
      return match + count(str, a, high + 1);
    } else {
      return 0;
    }
  }
}
