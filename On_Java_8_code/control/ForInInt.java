

public class ForInInt
{
    public static void main(String[] args)
    {
        for(int i : range(10)) // 0..9
            System.out.print(i + " ");
        System.out.println();
        for(int i : range(5, 10)) // 5..9
            System.out.print(i + " ");
        System.out.println();
        for(int i : range(5, 20, 3)) // 5..20 step 3
            System.out.print(i + " ");
        System.out.println();
        for(int i : range(20, 5, -3)) // Count down
            System.out.print(i + " ");
        System.out.println();
    }
    public static int[] range(int start, int end, int step)
    {
        if (step == 0)
            throw new IllegalArgumentException("Step could not be 0");
        if (step > 0)
        {
            if (start >= end)
                throw new IllegalArgumentException("Start should be less than End");
            int sz = 1;
            int pos = start + step;
            while (pos < end)
            {
                ++sz;
                pos += step;
            }
            int[] result = new int[sz];
            for(int i = 0; i < sz; i++)
                result[i] = start + (i * step);
            return result;
        }
        else
        {
            if (start <= end)
                throw new IllegalArgumentException("Start should be greater than End");
            int sz = 1;
            int pos = start + step;
            while (pos > end)
            {
                ++sz;
                pos += step;
            }
            int[] result = new int[sz];
            for(int i = 0; i < sz; i++)
                result[i] = start + (i * step);
            return result;
        }
    }
    public static int[] range(int start, int end)
    {
        return range(start, end, 1);
    }
    public static int[] range(int n)
    {
        return range(0, n);
    }

}
