public class MyRectangle2D {
  private double x;
  private double y;
  private double width;
  private double height;

  public MyRectangle2D() {
    this(0, 0, 1, 1);
  }

  public MyRectangle2D(double x, double y, double width, double height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public double getArea() {
    return width * height;
  }

  public double getPerimeter() {
    return 2 * (width + height);
  }

  public boolean contains(double x, double y) {
    boolean xValid = x <= (this.x + (width / 2)) &&
                     x >= (this.x - (width / 2));
    boolean yValid = y <= (this.y + (height / 2)) &&
                     y >= (this.y - (height / 2));
    return xValid && yValid;
  }

  public boolean contains(MyRectangle2D r) {
    // check whether all corner points of r lie inside the rectangle.
    double[][] corners = getCornerPoints(r);
    for (int i = 0; i < corners.length; i++) {
      if (!contains(corners[i][0], corners[i][1])) { return false; }
    }
    return true;
  }

  public boolean overlaps(MyRectangle2D r) {
    // check whether each rectangle's bottom edge is above the other's top edge
    // and whether each rectangle's left edge is to the right of the other's
    // right edge.
    if ((getY() + (getHeight() / 2) < r.getY() - (r.getHeight() / 2)) ||
        (getY() - (getHeight() / 2) > r.getY() + (r.getHeight() / 2)) ||
        (getX() + (getWidth() / 2) < r.getX() - (r.getWidth() / 2))   ||
        (getX() - (getWidth() / 2)) > r.getX() + (r.getWidth() / 2)) {
      return false;
    }
    return true;
  }

  private static double[][] getCornerPoints(MyRectangle2D r) {
    double[][] corners = new double[4][2];
    corners[0][0] = r.getX() - (r.getWidth() / 2);
    corners[0][1] = r.getY() + (r.getHeight() / 2);
    corners[1][0] = r.getX() + (r.getWidth() / 2);
    corners[1][1] = r.getY() + (r.getHeight() / 2);
    corners[2][0] = r.getX() + (r.getWidth() / 2);
    corners[2][1] = r.getY() - (r.getHeight() / 2);
    corners[3][0] = r.getX() - (r.getWidth() / 2);
    corners[3][1] = r.getY() - (r.getHeight() / 2);
    return corners;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public double getWidth() {
    return width;
  }

  public double getHeight() {
    return height;
  }
}
