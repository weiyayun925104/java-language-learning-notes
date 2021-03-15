
public class MyString2
{
    private char[] chars;

    public MyString2(String s)
    {
        chars = s.toCharArray();
    }

    public MyString2(char[] chars)
    {
        this.chars = chars;
    }

    public int compare(String s)
    {
        MyString2 a; // holds smaller string, or (this) if both are equal length
        MyString2 b; // holds the larger string, or (arg) if both are equal length
        boolean flag = false;
        if (length() <= s.length())
        {
            a = new MyString2(chars);
            b = new MyString2(s);
        }
        else
        {
            a = new MyString2(s);
            b = new MyString2(chars);
            flag = true;
        }

        // compare a and b, tying the loop to the smaller of the two in order to
        // avoid out of bounds exceptions, returning the integer difference of the
        // of the first unequal char comparison
        for (int i = 0; i < a.length(); i++)
        {
            if (a.charAt(i) != b.charAt(i))
            {
                return flag ? (int)(b.charAt(i) - a.charAt(i)) : (int)(a.charAt(i) - b.charAt(i));
            }
        }

        // if no difference was found by this point, and the strings are of
        // different lengths, return the length difference of the original objects
        // (this.length - arg.length)
        if (length() < s.length() || length() > s.length())
        {
            return length() - s.length();
        }

        // otherwise, they must be equal
        return 0;
    }

    public MyString2 substring(int begin)
    {
        if (begin < 0 || begin > length() - 1)
        {
            throw new IndexOutOfBoundsException();
        }
        char[] sub = new char[length() - begin];
        for (int i = 0, j = begin; j < length(); i++, j++)
        {
            sub[i] = charAt(j);
        }
        return new MyString2(sub);
    }

    public MyString2 toUpperCase()
    {
        char[] replacement = new char[length()];
        for (int i = 0; i < length(); i++)
        {
            char c = charAt(i);
            if (c >= 'a' && c <= 'z')
            {
                replacement[i] = (char)(c - 32);
            }
            else
            {
                replacement[i] = c;
            }
        }
        return new MyString2(replacement);
    }

    public char[] toChars()
    {
        return chars;
    }

    public static MyString2 valueOf(boolean b)
    {
        return new MyString2(b ? "true" : "false");
    }

    public int length()
    {
        return chars.length;
    }

    public boolean equals(String s)
    {
        if ( compare(s) != 0 )
        {
            return false;
        }
        return true;
    }

    public char charAt(int index)
    {
        if (index < 0 || index > length() - 1)
        {
            throw new IndexOutOfBoundsException();
        }
        return chars[index];
    }

    @Override
    public String toString()
    {
        return new String(chars);
    }
}
