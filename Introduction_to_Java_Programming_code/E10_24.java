/*
  The Character class is provided in the Java library. Provide your own
  implementation for this class. Name the new class MyCharacter.
*/

public class E10_24 {
  public static void main(String[] args) {
    MyCharacter a = new MyCharacter('a');
    MyCharacter b = MyCharacter.valueOf('z');
    System.out.println(a);
    System.out.println(b);
    System.out.println(a.charValue());
    System.out.println(MyCharacter.compare('z', 'a'));
    System.out.println(MyCharacter.compare('a', 'a'));
    System.out.println(MyCharacter.compare('a', 'z'));
    System.out.println(a.compareTo(b));
    System.out.println(a.equals(new MyCharacter('a')));
    System.out.println(a.equals(b));
    System.out.println(MyCharacter.isDigit('a'));
    System.out.println(MyCharacter.isDigit('0'));
    System.out.println(MyCharacter.isLetter('a'));
    System.out.println(MyCharacter.isDigit('0'));
    System.out.println(MyCharacter.isLetterOrDigit('0'));
    System.out.println(MyCharacter.isLetterOrDigit('*'));
    System.out.println(MyCharacter.toLowerCase('Z'));
    System.out.println(MyCharacter.toLowerCase('*'));
    System.out.println(MyCharacter.toUpperCase('z'));
    System.out.println(MyCharacter.toUpperCase('*'));
  }
}
