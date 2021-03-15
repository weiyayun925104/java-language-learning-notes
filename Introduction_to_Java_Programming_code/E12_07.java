/*
  Write the bin2Dec(String binaryString) method to convert a binary string into
  a decimal number. Implement the bin2Dec method to throw a
  NumberFormatException if the string is not a binary string.
*/

public class E12_07 {
  public static void main(String[] args) {
    System.out.println(bin2Dec("11110001F"));
  }

  public static int bin2Dec(String binaryString) {
    for (int i = 0; i < binaryString.length(); i++) {
      char c = binaryString.charAt(i);
      if (c != '0' && c != '1') {
        throw new NumberFormatException();
      }
    }

    int sum = 0;
    int multipleOfTwo = 1;
    for (int i = binaryString.length() - 1; i >= 0; i--) {
      if (binaryString.charAt(i) == '1') {
        sum += multipleOfTwo;
      }
      multipleOfTwo *= 2;
    }

    return sum;
  }
}
