/*
  Rewrite Programming Exercise 7.35. The program reads the words stored in a
  text file named hangman.txt. Words are delimited by spaces.
*/

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;

public class E12_17 {
  public static void main(String[] args) throws Exception {
    // open the hangman.txt word file
    File file = new File("hangman.txt");
    if (!file.exists()) {
      System.out.println("The words file does not exist. Please make a " +
        "hangman.txt file");
      System.exit(1);
    }

    // pull the words out into a list
    ArrayList<String> words = new ArrayList<>();
    try (
      Scanner fileInput = new Scanner(file);
    ) {
      while (fileInput.hasNext()) {
        words.add(fileInput.next());
      }
    }

    // start the game
    Scanner guessInput = new Scanner(System.in);
    hangman(words, guessInput);
  }

  public static void hangman(ArrayList<String> words, Scanner guessInput) {
    // new game loop
    boolean wantsToRetry = false;
    do {
      // current game loop
      String word = getWord(words);

      HashSet<String> guessed = new HashSet<>();
      int missed = 0;
      do {
        // get user guess
        String guess = getInput(word, guessed, guessInput);


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
      String r = guessInput.nextLine().toLowerCase();
      if (r.equals("y")) { wantsToRetry = true; }
      if (r.equals("n")) { wantsToRetry = false; }
    } while (wantsToRetry);
  }

  public static String getInput(String word, HashSet<String> guessed,
    Scanner guessInput) {

    String wordDisplay = maskLetters(word, guessed);
    System.out.print("(Guess) Enter a letter in word " + wordDisplay + " > ");
    return guessInput.nextLine();
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

  public static String getWord(ArrayList<String> words) {
    return words.get((int)(Math.random() * words.size()));
  }
}
