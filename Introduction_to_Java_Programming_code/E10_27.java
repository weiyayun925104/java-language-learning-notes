/*
  The StringBuilder class is provided in the Java library. Provide your own
  implementation for the following methods (name the new class
  MyStringBuilder1):

  public MyStringBuilder1(String s);
  public MyStringBuilder1 append(MyStringBuilder1 s);
  public MyStringBuilder1 append(int i);
  public int length();
  public char charAt(int index);
  public MyStringBuilder1 toLowerCase();
  public MyStringBuilder1 substring(int begin, int end);
  public String toString();
*/

public class E10_27 {
  public static void main(String[] args) {
    MyStringBuilder1 a = new MyStringBuilder1("HAPPY");
    System.out.println(a);
    System.out.println(a.charAt(3));
    a.append(new MyStringBuilder1(" birthday"));
    System.out.println(a);
    a.append(100);
    System.out.println(a);
    a.toLowerCase();
    System.out.println(a);
    MyStringBuilder1 b = a.substring(3, 7);
    System.out.println(b);
  }
}
