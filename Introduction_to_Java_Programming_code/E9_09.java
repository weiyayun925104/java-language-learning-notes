/*
  In an n-sided regular polygon, all sides have the same length and all angles
  have the same degree (i.e. the polygon is both equilateral and equiangular).
  Design a class named RegularPolygon that contains:

  - A private int data field named n that defines the number of sides in the
    polygon with default value 3.
  - A private double data field named side that stores the length of the side
    with default value 1.
  - A private double data field named x that defines the x-coordinate of the
    polygon's center with default value 0.
  - A private double data field named y that defines the y-coordinate of the
    polygon's center with default value 0.
  - A no-arg constructor that creates a regular polygon with default values.
  - A constructor that creates a regular polygon with the specified number of
    sides and length of side, centered at (0, 0).
  - A constructor that creates a regular polygon with the specified number of
    sides, length of side, and x- and y-coordinates.
  - The accessor and mutator methods for all data fields.
  - The method getPerimeter() that returns the perimeter of the polygon.
  - The method getArea() that returns the area of the polygon.

  Write a test program that creates three RegularPolygon objects, created using
  the no-arg constructor, using RegularPolygon(6, 4), and
  RegularPolygon(10, 4, 5.6, 7.8). For each object, display its periemter and
  area.
*/

public class E9_09 {
  public static void main(String[] args) {
    RegularPolygon a = new RegularPolygon();
    RegularPolygon b = new RegularPolygon(6, 4);
    RegularPolygon c = new RegularPolygon(10, 4, 5.6, 7.8);

    RegularPolygon[] polys = {a, b, c};

    for (int i = 0; i < polys.length; i++) {
      System.out.println("Polygon " + i);
      System.out.println("perimeter: " + polys[i].getPerimeter());
      System.out.println("area: " + polys[i].getArea());
      System.out.println();
    }
  }
}
