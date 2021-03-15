
public class E6_29
{
    public static void main(String[] args)
    {
        // loop i to 998, because last possible pair would be (998, 1000) in order
        // to keep the results to < 1000
        for (int i = 2; i <= 998; i++)
        {
            if (isPrime(i) && isPrime(i + 2))
            {
                System.out.printf("(%d, %d)\n", i, i + 2);
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
