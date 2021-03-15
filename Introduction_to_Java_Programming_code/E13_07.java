/*
  Design an interface named Colorable with a void method named howToColor().
  Every class of a colorable object must implement the Colorable interface.
  Design a class named Square that extends GeometricObject and implements
  Colorable. Implement howToColor to display the message "Color all four sides".

  Write a test program that creates an array of five GeometricObjects. For each
  object in the array, display its area and invoke its howToColor method of it
  is colorable.
*/

import java.util.ArrayList;

public class E13_07 {
  public static void main(String[] args) {
    // Generate an array of five GeometricObject objects
    ArrayList<GeometricObject> list = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      int chooser = (int)(Math.random() * 2);
      int value = (int)(Math.random() * 50);
      if (chooser == 1) {
        list.add(new Circle(value));
      } else {
        list.add(new Square(value));
      }
    }

    // For each object, if it is Colorable, invoke its howToColor method
    for (GeometricObject g: list) {
      if (g instanceof Colorable) {
        ((Colorable)g).howToColor();
      }
    }
  }
}
