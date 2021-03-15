public class MyString1 {
  private char[] chars;

  public MyString1(char[] chars) {
    this.chars = chars;
  }

  public char charAt(int index) {
    if (index < 0 || index > length() - 1) {
      throw new IndexOutOfBoundsException();
    }
    return chars[index];
  }

  public int length() {
    return chars.length;
  }

  public MyString1 substring(int begin, int end) {
    if (begin < 0 || end > length() || begin > end) {
      throw new IndexOutOfBoundsException();
    }
    char[] sub = new char[end - begin];
    for (int i = 0, j = begin; j < end; i++, j++) {
      sub[i] = chars[j];
    }
    return new MyString1(sub);
  }

  public MyString1 toLowerCase() {
    char[] replacement = new char[length()];
    for (int i = 0; i < length(); i++) {
      char c = charAt(i);
      if (c >= 'A' && c <= 'Z') {
        replacement[i] = (char)(c + 32);
      } else {
        replacement[i] = c;
      }
    }
    return new MyString1(replacement);
  }

  public boolean equals(MyString1 s) {
    if (s.length() != length()) { return false; }
    for (int i = 0; i < length(); i++) {
      if (charAt(i) != s.charAt(i)) { return false; }
    }
    return true;
  }

  public static MyString1 valueOf(int i) {
    // find the number of digits in i
    int count = 0;
    int n = i;
    while (n != 0) {
      n /= 10;
      count++;
    }

    // put digits of i into new char array
    char[] num = new char[count];
    for (int idx = num.length - 1; idx >= 0; idx--) {
      num[idx] = (char)((i % 10) + 48);
      i /= 10;
    }

    return new MyString1(num);
  }

  @Override
  public String toString() {
    return new String(chars);
  }
}
