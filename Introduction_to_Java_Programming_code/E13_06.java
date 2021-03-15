/*
  Define a class named ComparableCircle that extends Circle and implements
  Comparable. Write a test class to find the larger of two instances of
  ComparableCircle objects.
*/

public class E13_06 {
  public static void main(String[] args) {
    ComparableCircle c1 = new ComparableCircle(10);
    ComparableCircle c2 = new ComparableCircle(5);

    if (c1.compareTo(c2) == 1) {
      System.out.println("c1 is larger");
    } else if (c1.compareTo(c2) == -1) {
      System.out.println("c2 is larger");
    } else {
      System.out.println("c1 and c2 are equal");
    }
  }
}
