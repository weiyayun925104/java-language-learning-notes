/*
  Write a program that creates an ArrayList and adds a Loan object, a Date
  object, a string, and a Circle object to the list, and use a loop to display
  all the elements in the list by invoking the object's toString() method.
*/

import java.util.Date;
import java.util.ArrayList;

public class E11_06 {
  public static void main(String[] args) {
    ArrayList<Object> objects = new ArrayList<>();
    objects.add(new Loan());
    objects.add(new Date());
    objects.add("blah blah blah");
    objects.add(new Circle(5));

    for (Object o: objects) {
      System.out.println(o);
      System.out.println();
    }
  }
}
