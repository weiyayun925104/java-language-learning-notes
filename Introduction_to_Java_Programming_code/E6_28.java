
public class E6_28
{
    public static void main(String[] args)
    {
        System.out.println("p     2^p-1");
        for (int i = 2; i <= 31; i++)
        {
            int m = (int)(Math.pow(2, i) - 1);
            if (isPrime(m))
            {
                System.out.printf("%-2d    %-5d\n", i, m);
            }
        }
    }


    public static boolean isPrime(int n)
    {
        if (n < 2)
        {
            return false;
        }
        if (n == 2)
        {
            return true;
        }
        if (n % 2 == 0)
        {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2)
        {
            if (n % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}
