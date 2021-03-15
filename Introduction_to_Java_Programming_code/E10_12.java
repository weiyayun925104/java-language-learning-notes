
public class E10_12
{
    public static void main(String[] args)
    {
        Triangle2D t1 = new Triangle2D(new MyPoint(0, 0), new MyPoint(5, 0),
                                       new MyPoint(5, 4));
        System.out.println("area: " + t1.getArea());
        System.out.println("perimeter: " + t1.getPerimeter());
        System.out.println("t1.contains(3, 1): " + t1.contains(new MyPoint(3, 1)));
        System.out.println("t1.contains(3, 3): " + t1.contains(new MyPoint(3, 3)));
        Triangle2D t2 = new Triangle2D(new MyPoint(3, 1), new MyPoint(4, 1),
                                       new MyPoint(4, 2));
        System.out.println("t1.contains(t2): " + t1.contains(t2));
        Triangle2D t3 = new Triangle2D(new MyPoint(2, 3), new MyPoint(3, 3),
                                       new MyPoint(3, 4));
        System.out.println("t1.contains(t3): " + t1.contains(t3));
        System.out.println("t1.overlaps(t3): " + t1.overlaps(t3));
        System.out.println("t1.overlaps(t2): " + t1.overlaps(t2));
        Triangle2D t4 = new Triangle2D(new MyPoint(5, -1), new MyPoint(6, 2),
                                       new MyPoint(2, 4));
        System.out.println("t1.overlaps(t4): " + t1.overlaps(t4));
        Triangle2D t5 = new Triangle2D(new MyPoint(2, 5), new MyPoint(6, 2),
                                       new MyPoint(6, 6));
        System.out.println("t1.overlaps(t5): " + t1.overlaps(t5));
        Triangle2D t6 = new Triangle2D(new MyPoint(2, 5), new MyPoint(6, 5),
                                       new MyPoint(3, 6));
        System.out.println("t1.overlaps(t6): " + t1.overlaps(t6));
    }
}
