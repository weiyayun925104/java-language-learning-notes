/*
  Write a program that displays a random uppercase letter using the
  Math.random() method.
*/

public class E4_16 {
  public static void main(String[] args) {
    for (int i = 0; i < 50; i++) {
      System.out.println(getRandomUppercaseLetter());
    }
  }

  private static char getRandomUppercaseLetter() {
    return (char)((Math.random() * 26) + 65);
  }
}
