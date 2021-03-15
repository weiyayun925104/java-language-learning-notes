/*
  The StringBuilder class is provided in the Java library. Provide your own
  implementation for the following methods (name the new class
  MyStringBuilder2):

  public MyStringBuilder2();
  public MyStringBuilder2(char[] chars);
  public MyStringBuilder2(String s);
  public MyStringBuilder2 insert(int offset, MyStringBuilder2 s);
  public MyStringBuilder2 reverse();
  public MyStringBuilder2 substring(int begin);
  public MyStringBuilder2 toUpperCase();
*/

public class E10_28 {
  public static void main(String[] args) {
    MyStringBuilder2 a = new MyStringBuilder2();
    System.out.println(a);
    MyStringBuilder2 b = new MyStringBuilder2(new char[]{'h', 'a', 'p'});
    System.out.println(b);
    MyStringBuilder2 c = new MyStringBuilder2("birthday");
    System.out.println(c);
    c.insert(3, new MyStringBuilder2("GIFT"));
    System.out.println(c);
    c.reverse();
    System.out.println(c);
    MyStringBuilder2 d = c.substring(3);
    System.out.println(d);
    d.toUpperCase();
    System.out.println(d);
  }
}
