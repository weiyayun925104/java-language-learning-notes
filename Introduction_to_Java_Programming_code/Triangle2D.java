
public class Triangle2D
{
    // fields
    private MyPoint p1, p2, p3;

    // constructors
    public Triangle2D()
    {
        this(new MyPoint(0, 0), new MyPoint(1, 1), new MyPoint(2, 5));
    }

    public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3)
    {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    // instance methods
    public double getArea()
    {
        double s1 = distance(p1, p2);
        double s2 = distance(p2, p3);
        double s3 = distance(p3, p1);
        double s = (s1 + s2 + s3) / 2.0;
        return Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));
    }

    public double getPerimeter()
    {
        double s1 = distance(p1, p2);
        double s2 = distance(p2, p3);
        double s3 = distance(p3, p1);
        return s1 + s2 + s3;
    }

    public boolean contains(MyPoint p)
    {
        boolean b1 = sign(p1, p2, p) < 0;
        boolean b2 = sign(p2, p3, p) < 0;
        boolean b3 = sign(p3, p1, p) < 0;
        return ((b1 == b2) && (b2 == b3));
    }

    public boolean contains(Triangle2D t)
    {
        return contains(t.getP1()) && contains(t.getP2()) && contains(t.getP3());
    }

    public boolean overlaps(Triangle2D t)
    {
        if (contains(t))
        {
            return true;
        }
        MyPoint[] a = {p1, p2, p3};
        MyPoint[] b = {t.getP1(), t.getP2(), t.getP3()};

        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < b.length; j++)
            {
                int k = i + 1;
                int m = j + 1;
                if (i == a.length - 1)
                {
                    k = 0;
                }
                if (j == b.length - 1)
                {
                    m = 0;
                }
                if (intersect(a[i], a[k], b[j], b[m]))
                {
                    return true;
                }
            }
        }
        return false;
    }

    // getters
    public MyPoint getP1()
    {
        return p1;
    }

    public MyPoint getP2()
    {
        return p2;
    }

    public MyPoint getP3()
    {
        return p3;
    }

    // setters
    public void setP1(MyPoint p1)
    {
        this.p1 = p1;
    }

    public void setP2(MyPoint p2)
    {
        this.p2 = p2;
    }

    public void setP3(MyPoint p3)
    {
        this.p3 = p3;
    }

    // convenience methods
    private static double distance(MyPoint a, MyPoint b)
    {
        double x1 = a.getX();
        double y1 = a.getY();
        double x2 = b.getX();
        double y2 = b.getY();
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private static int sign(MyPoint p1, MyPoint p2, MyPoint p3)
    {
        double x0 = p1.getX();
        double y0 = p1.getY();
        double x1 = p2.getX();
        double y1 = p2.getY();
        double x2 = p3.getX();
        double y2 = p3.getY();
        double res = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
        if (res > 0) { return 1; }
        else if (res < 0) { return -1; }
        return 0;
    }

    public static boolean intersect(MyPoint p1, MyPoint q1, MyPoint p2,
                                    MyPoint q2)
    {
        int o1 = sign(p1, q1, p2);
        int o2 = sign(p1, q1, q2);
        int o3 = sign(p2, q2, p1);
        int o4 = sign(p2, q2, q1);

        if (o1 != o2 && o3 != o4)
            return true;

        return false;
    }
}