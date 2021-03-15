public class MyCharacter {
  private char ch;

  public MyCharacter(char ch) {
    this.ch = ch;
  }

  public char charValue() {
    return ch;
  }

  public static int compare(char x, char y) {
    return Character.valueOf(x).compareTo(Character.valueOf(y));
  }

  public int compareTo(MyCharacter c) {
    return charValue() - c.charValue();
  }

  public static MyCharacter valueOf(char c) {
    return new MyCharacter(c);
  }

  public boolean equals(MyCharacter c) {
    if (compareTo(c) == 0) { return true; }
    return false;
  }

  public static boolean isDigit(char c) {
    if (c >= '0' && c <= '9') { return true; }
    return false;
  }

  public static boolean isLetter(char c) {
    if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) { return true; }
    return false;
  }

  public static boolean isLetterOrDigit(char c) {
    return isDigit(c) || isLetter(c);
  }

  public static char toLowerCase(char ch) {
    if (ch >= 'A' && ch <= 'Z') { return (char)(ch + 32); }
    return ch;
  }

  public static char toUpperCase(char ch) {
    if (ch >= 'a' && ch <= 'z') { return (char)(ch - 32); }
    return ch;
  }

  @Override
  public String toString() {
    return String.valueOf(ch);
  }
}
