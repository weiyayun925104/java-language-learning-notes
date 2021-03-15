
public class MyPoint
{
    private double x;
    private double y;

    public MyPoint()
    {
        this(0, 0);
    }

    public MyPoint(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    // getters
    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    // instance methods
    public double distance(MyPoint point)
    {
        return distance(point.getX(), point.getY());
    }

    public double distance(double x, double y)
    {
        return Math.sqrt(Math.pow(getX() - x, 2) + Math.pow(getY() - y, 2));
    }
}
