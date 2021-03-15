/*
  Assume letters A, E, I, O, and U as the vowels. Write a program that prompts
  the user to enter a string and displays the number of vowels and consonants
  in the string.
*/

import java.util.Scanner;

public class E5_49 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String entry = input.nextLine().toLowerCase();

    int vowelCount = 0;
    int consonantCount = 0;

    for (int i = 0; i < entry.length(); i++) {
      char c = entry.charAt(i);
      if (isVowel(c)) { vowelCount++; }
      else if (isConsonant(c)) { consonantCount++; }
    }

    System.out.println("The number of vowels is " + vowelCount);
    System.out.println("The number of consonants is " + consonantCount);
  }

  private static boolean isVowel(char c) {
    boolean vowel = false;
    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
      vowel = true;
    }
    return vowel;
  }

  private static boolean isConsonant(char c) {
    boolean consonant = false;
    if (!isVowel(c) && Character.isLetter(c)) {
      consonant = true;
    }
    return consonant;
  }
}
