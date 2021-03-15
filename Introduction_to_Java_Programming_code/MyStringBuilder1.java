import java.util.ArrayList;

public class MyStringBuilder1 {
  private ArrayList<Character> chars;

  public MyStringBuilder1(String s) {
    chars = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      chars.add(s.charAt(i));
    }
  }

  public MyStringBuilder1 append(MyStringBuilder1 s) {
    for (int i = 0; i < s.length(); i++) {
      chars.add(s.charAt(i));
    }
    return this;
  }

  public MyStringBuilder1 append(int i) {
    String num = String.valueOf(i);
    return append(new MyStringBuilder1(num));
  }

  public int length() {
    return chars.size();
  }

  public char charAt(int index) {
    return chars.get(index).charValue();
  }

  public MyStringBuilder1 toLowerCase() {
    for (int i = 0; i < length(); i++) {
      char c = chars.get(i);
      if (c >= 'A' && c <= 'Z') {
        chars.set(i, (char)(c + 32));
      }
    }

    return this;
  }

  public MyStringBuilder1 substring(int begin, int end) {
    if (begin < 0 || end > length() || begin > end) {
      throw new IndexOutOfBoundsException();
    }
    String original = toString();
    String sub = original.substring(begin, end);
    return new MyStringBuilder1(sub);
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
