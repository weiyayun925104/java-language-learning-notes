/*
  The String class is provided by the Java library. Provide your own
  implementation for the following methods (name the new class MyString2):

  public MyString2(String s);
  public int compare(String s);
  public MyString2 substring(int begin);
  public MyString2 toUpperCase();
  public char[] toChars();
  public static MyString2 valueOf(boolean b);
*/

public class E10_23 {
  public static void main(String[] args) {
    MyString2 a = new MyString2("happy");
    System.out.println(a);
    String s = "happy";
    System.out.println(a.compare(s));
    MyString2 b = new MyString2("haz");
    System.out.println(b.compare(s));
    MyString2 c = new MyString2("had");
    System.out.println(c.compare(s));
    MyString2 d = new MyString2("happyyyyyy");
    System.out.println(d.compare(s));
    MyString2 e = new MyString2("ha");
    System.out.println(e.compare(s));
    MyString2 f = a.substring(0);
    System.out.println(f);
    MyString2 g = a.substring(3);
    System.out.println(g);
    MyString2 h = a.toUpperCase();
    System.out.println(h);
    char[] chars = a.toChars();
    for (char ch: chars) {
      System.out.print(ch);
    }
    System.out.println();
    boolean boo = true;
    MyString2 i = MyString2.valueOf(boo);
    System.out.println(i);
    boo = false;
    MyString2 j = MyString2.valueOf(boo);
    System.out.println(j);
  }
}
