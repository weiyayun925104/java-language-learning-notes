/*
  Write a hangman game that randomly generates a word and prompts the user to
  guess one letter at a time. Each letter in the word is displayed as an
  asterisk. When the user makes a correct guess, the actual letter is then
  displayed. When the user finishes a word, display the number of misses and
  ask the user whether to continue to play with another word.
*/

import java.util.Scanner;
import java.util.HashSet;

public class E7_35 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String[] words = {"write", "program", "dance", "xylophone"};

    hangman(words, input);
  }

  public static void hangman(String[] words, Scanner input) {
    // new game loop
    boolean wantsToRetry = false;
    do {
      // current game loop
      String word = getWord(words);
      HashSet<String> guessed = new HashSet<>();
      int missed = 0;
      do {
        // get user guess
        String guess = getInput(word, guessed, input);

        // grade guess
        if (guessed.contains(guess)) {
          System.out.println("\t" + guess + " is already in the word");
        } else if (isInWord(guess, word)) {
          guessed.add(guess);
        } else {
          missed++;
        }
      } while (!isOver(word, guessed));

      // game over condition
      if (isOver(word, guessed)) {
        System.out.println("The word is " + word + ". You missed " +
          missed + (missed > 1 || missed == 0 ? " times" : " time"));
      }

      // retry?
      System.out.print("Do you want to guess another word (y or n)? > ");
      String r = input.nextLine().toLowerCase();
      if (r.equals("y")) { wantsToRetry = true; }
      if (r.equals("n")) { wantsToRetry = false; }
    } while (wantsToRetry);
  }

  public static String getInput(String word, HashSet<String> guessed,
    Scanner input) {

    String wordDisplay = maskLetters(word, guessed);
    System.out.print("(Guess) Enter a letter in word " + wordDisplay + " > ");
    return input.nextLine().toLowerCase();
  }

  public static boolean isOver(String word, HashSet<String> guessed) {
    return word.equals(maskLetters(word, guessed));
  }

  public static boolean isInWord(String guess, String word) {
    boolean inWord = false;
    String[] wordSplit = word.split("");
    for (int i = 0; i < wordSplit.length; i++) {
      if (guess.equals(wordSplit[i])) {
        inWord = true;
        break;
      }
    }
    return inWord;
  }

  public static String maskLetters(String word, HashSet<String> guessed) {
    String[] wordSplit = word.split("");
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < wordSplit.length; i++) {
      if (guessed.contains(wordSplit[i])) {
        s.append(wordSplit[i]);
      } else {
        s.append("*");
      }
    }
    return s.toString();
  }

  public static String getWord(String[] words) {
    return words[(int)(Math.random() * words.length)];
  }
}
