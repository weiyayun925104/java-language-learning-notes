
import java.util.Random;

public class E4_06
{
    public static void main(String[] args)
    {
        Random r = new Random();

        double ab, bc, ca;
        do
        {
            Point a = getPointOnCircle(40, getRandomAngle(r));
            Point b = getPointOnCircle(40, getRandomAngle(r));
            Point c = getPointOnCircle(40, getRandomAngle(r));

            ab = distance(a, b);
            bc = distance(b, c);
            ca = distance(c, a);
        }
        while ( !triangleIsValid(ab, bc, ca) );

        double cosA = ((ca * ca) + (ab * ab) - (bc * bc)) / (2 * ca * ab);
        double cosB = ((ab * ab) + (bc * bc) - (ca * ca)) / (2 * ab * bc);
        double cosC = ((bc * bc) + (ca * ca) - (ab * ab)) / (2 * bc * ca);
        double A = (Math.acos(cosA) * (180 / Math.PI));
        double B = (Math.acos(cosB) * (180 / Math.PI));
        double C = (Math.acos(cosC) * (180 / Math.PI));
        System.out.println("The three angles are " +
                           Math.round(A * 100) / 100.0 + " " +
                           Math.round(B * 100) / 100.0 + " " +
                           Math.round(C * 100) / 100.0);
    }

    private static double getRandomAngle(Random r)
    {
        return Math.toRadians(r.nextDouble() * 360);
    }

    private static Point getPointOnCircle(double radius, double angle)
    {
        return new Point(radius * Math.cos(angle), radius * Math.sin(angle));
    }

    private static double distance(Point a, Point b)
    {
        double x1 = a.getX();
        double y1 = a.getY();
        double x2 = b.getX();
        double y2 = b.getY();
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private static boolean triangleIsValid(double a, double b, double c)
    {
        return (a + b > c) && (b + c > a) && (c + a > b);
    }

    private static class Point
    {
        private double x;
        private double y;

        public Point(double x, double y)
        {
            this.x = x;
            this.y = y;
        }

        public double getX()
        {
            return x;
        }

        public double getY()
        {
            return y;
        }

        public String toString()
        {
            return String.format("(%f, %f)", x, y);
        }
    }
}
