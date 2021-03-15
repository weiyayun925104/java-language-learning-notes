
import java.math.BigInteger;

public class E5_26
{
    public static void main(String[] args)
    {
        for (int i = 10_000; i <= 100_000; i += 10_000)
        {
            double e = 1.0;
            double item = 1.0;
            for (int n = 1; n <= i; n++)
            {
                item /= n;
                e += item;
            }
            System.out.println("i = " + i + ": " + e);
        }
    }
}
