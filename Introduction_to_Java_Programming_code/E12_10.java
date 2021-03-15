/*
  Write a program that causes the JVM to throw an OutOfMemoryError and catches
  and handles this error.
*/

public class E12_10 {
  public static void main(String[] args) {
    try {
      throwError();
    } catch (Error e) {
      System.out.println("OutOfMemoryError caught!");
      System.exit(0);
    }
  }

  public static void throwError() {
    throw new OutOfMemoryError();
  }
}
