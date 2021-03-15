import java.util.ArrayList;

public class MyStringBuilder2 {
  private ArrayList<Character> chars;

  public MyStringBuilder2() {
    this(new char[0]);
  }

  public MyStringBuilder2(char[] chars) {
    this(new String(chars));
  }

  public MyStringBuilder2(String s) {
    chars = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      chars.add(s.charAt(i));
    }
  }

  public MyStringBuilder2 insert(int offset, MyStringBuilder2 s) {
    for (int i = offset, j = 0; j < s.length(); i++, j++) {
      chars.add(i, s.charAt(j));
    }
    return this;
  }

  public MyStringBuilder2 reverse() {
    for (int i = 0, j = length() - 1; i < j; i++, j--) {
      char temp = chars.get(i);
      chars.set(i, chars.get(j));
      chars.set(j, temp);
    }
    return this;
  }

  public MyStringBuilder2 substring(int begin) {
    if (begin < 0 || begin > length()) {
      throw new IndexOutOfBoundsException();
    }
    String original = toString();
    String sub = original.substring(begin, original.length());
    return new MyStringBuilder2(sub);
  }

  public MyStringBuilder2 toUpperCase() {
    for (int i = 0; i < length(); i++) {
      char c = chars.get(i);
      if (c >= 'a' && c <= 'z') {
        chars.set(i, (char)(c - 32));
      }
    }

    return this;
  }

  public int length() {
    return chars.size();
  }

  public char charAt(int index) {
    return chars.get(index).charValue();
  }

  @Override
  public String toString() {
    char[] ch = new char[chars.size()];
    for (int i = 0; i < chars.size(); i++) {
      ch[i] = chars.get(i).charValue();
    }
    return new String(ch);
  }
}
