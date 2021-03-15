/*
  Credit card numbers follow certain patterns. A credit card number must have
  between 13 and 16 digits. It must start with:

  - 4 for Visa cards
  - 5 for Master cards
  - 37 for American Express cards
  - 6 for Discover cards

  In 1954, Hans Luhn of IBM proposed an algorithm for validating credit card
  numbers. The algorithm is useful to determine whether a card number is
  entered correctly or whether a credit card is scanned correctly by a scanner.
  Credit card numbers are generated following this validity check, commonly
  known as the Luhn check or the Mod 10 check, which can be described as
  follows.

  1. Double every second digit from right to left. If doubling of a digit
  results in a two-digit number, add up the two digits to get a single-digit
  number.

  2. Now add all the single-digit numbers from Step 1.

  3. Add all digits in the odd places from right to left in the card number.

  4. Sum the results from Step 2 and Step 3.

  5. If the result from Step 4 is divisible by 10, the card number is valid;
  otherwise, it is invalid. For example, the number 4388576018402626 is
  invalid, but the number 4388576018410707 is valid.

  Write a program that prompts the user to enter a credit card number as a
  long integer. Display whether the number is valid or invalid. Design your
  program to use the following methods:

  // Return true if the card number is valid
  public static boolean isValid(long number)

  // Get the result from Step 2
  public static int sumOfDoubleEvenPlace(long number)

  // Return this number if it is a single digit, otherwise, return the
  // sum of the two digits
  public static int getDigit(int number)

  // Return sum of odd-place digits in number
  public static int sumOfOddPlace(long number)

  // Return true if the digit d is a prefix for number
  public static boolean prefixMatched(long number, int d)

  // Return the number of digits in d
  public static int getSize(long d)

  // Return the first k number of digits from number. If the number of digits
  // in number is less than k, return number.
  public static long getPrefix(long number, k)

  (You may also implement this program by reading the input as a string and
  processing the string to validate the credit card.)
*/

import java.util.Scanner;

public class E6_31 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a credit card number as a long integer: ");
    String cc = input.nextLine();

    StringBuilder result = new StringBuilder(cc + " ");
    if (isValid(cc)) {
      result.append("is valid");
    } else {
      result.append("is invalid");
    }

    System.out.println(result);
  }

  public static int sumOfDoubleEvenPlace(String number) {
    int sum = 0;
    for (int i = number.length() - 2; i >= 0; i -= 2) {
      int digit = Character.digit(number.charAt(i), 10);
      sum += getDigit(digit * 2);
    }
    return sum;
  }

  public static int sumOfOddPlace(String number) {
    int sum = 0;
    for (int i = number.length() - 1; i >= 0; i -= 2) {
      int digit = Character.digit(number.charAt(i), 10);
      sum += digit;
    }
    return sum;
  }

  public static int getDigit(int number) {
    String numString = number + "";
    int digit;
    if (numString.length() == 1) {
      digit = number;
    } else {
      int sum = 0;
      for (int i = 0; i < numString.length(); i++) {
        sum += Character.digit(numString.charAt(i), 10);
      }
      digit = sum;
    }
    return digit;
  }

  public static boolean isValid(String number) {
    boolean valid = true;
    if (!isValidLength(number) || !isAllDigits(number) ||
        !hasValidPrefix(number)) {
      valid = false;
    } else {
      int evens = sumOfDoubleEvenPlace(number);
      int odds = sumOfOddPlace(number);
      if ((evens + odds) % 10 != 0) {
        valid = false;
      }
    }
    return valid;
  }

  public static boolean isValidLength(String number) {
    int length = number.length();
    return length >= 13 && length <= 16;
  }

  public static boolean isAllDigits(String number) {
    boolean allDigits = true;
    for (int i = 0; i < number.length(); i++) {
      char c = number.charAt(i);
      if (!Character.isDigit(c)) {
        allDigits = false;
        break;
      }
    }
    return allDigits;
  }

  public static boolean hasValidPrefix(String number) {
    boolean validPrefix = false;
    if (number.startsWith("4") || number.startsWith("5") ||
        number.startsWith("37") || number.startsWith("6")) {
      validPrefix = true;
    }
    return validPrefix;
  }
}
