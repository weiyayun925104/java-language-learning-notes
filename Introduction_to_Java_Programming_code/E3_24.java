/*
  Write a program that simulates picking a card from a deck of 52 cards. Your
  program should display the rank and suit of the card.
*/

public class E3_24 {
  public static void main(String[] args) {
    System.out.println("The card you picked is " + getCard());
  }

  private static String getCard() {
    StringBuilder s = new StringBuilder();
    s.append(getRank() + " of " + getSuit());
    return s.toString();
  }

  private static String getRank() {
    int rank = (int)(Math.random() * 13) + 1;
    StringBuilder s = new StringBuilder();
    if (rank == 1 || rank == 11 || rank == 12 || rank == 13) {
      switch (rank) {
        case 1: s.append("Ace"); break;
        case 11: s.append("Jack"); break;
        case 12: s.append("Queen"); break;
        case 13: s.append("King");
      }
    } else {
      s.append(rank);
    }
    return s.toString();
  }

  private static String getSuit() {
    int suit = (int)(Math.random() * 4);
    StringBuilder s = new StringBuilder();
    switch (suit) {
      case 0: s.append("Clubs"); break;
      case 1: s.append("Diamonds"); break;
      case 2: s.append("Hearts"); break;
      case 3: s.append("Spades");
    }
    return s.toString();
  }
}
