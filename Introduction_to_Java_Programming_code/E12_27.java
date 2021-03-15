
import java.io.File;

public class E12_27
{
    public static void main(String[] args)
    {
        for (String s : args)
        {
            File file = new File(s);
            StringBuilder sb = new StringBuilder(s);
            if (s.matches("Exercise\\d_\\d"))
            {
                sb.insert(8, "0");
                sb.insert(11, "0");
            }
            else if (s.matches("Exercise\\d_\\d+"))
            {
                sb.insert(8, "0");
            }
            else if (s.matches("Exercise\\d+_\\d"))
            {
                int index = s.indexOf("_");
                sb.insert((index + 1), "0");
            }
            File newName = new File(sb.toString());
            file.renameTo(newName);
        }
    }
}
