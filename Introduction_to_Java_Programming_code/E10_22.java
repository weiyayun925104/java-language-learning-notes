/*
  The String class is provided in the Java library. Provide your own
  implementation for the following methods (name the new class MyString1):

  public MyString1(char[] chars);
  public char charAt(int index);
  public int length();
  public MyString1 substring(int begin, int end);
  public MyString1 toLowerCase();
  public boolean equals(MyString1 s);
  public static MyString1 valueOf(int i);
*/

public class E10_22 {
  public static void main(String[] args) {
    MyString1 a = new MyString1(new char[]{'H', 'A', 'P', 'P', 'Y'});
    System.out.println(a);
    MyString1 b = a.toLowerCase();
    System.out.println(b);
    MyString1 c = b.substring(0, 3);
    System.out.println(c);
    System.out.println(c.length());
    System.out.println(a.equals(b));
    MyString1 d = new MyString1(new char[]{'H', 'A', 'P', 'P', 'Y'});
    System.out.println(a.equals(d));
    MyString1 e = MyString1.valueOf(71367);
    System.out.println(e);
  }
}
