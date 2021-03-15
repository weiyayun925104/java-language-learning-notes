/*
  Assume a vehicle plate number consists of three uppercase letters followed
  by four digits. Write a program to generate a plate number.
*/

public class E4_25 {
  public static void main(String[] args) {

    System.out.println(generatePlateNumber());
  }

  private static String generatePlateNumber() {
    StringBuilder plateNumber = new StringBuilder();
    for (int i = 0; i < 3; i++) {
      plateNumber.append(getRandomUppercaseLetter());
    }
    for (int i = 0; i < 4; i++) {
      plateNumber.append(getRandomDigit());
    }
    return plateNumber.toString();
  }

  private static char getRandomUppercaseLetter() {
    return (char)((Math.random() * 26) + 65);
  }

  private static int getRandomDigit() {
    return (int)(Math.random() * 10);
  }
}
