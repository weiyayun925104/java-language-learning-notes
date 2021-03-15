
public class E7_24
{
    public static void main(String[] args)
    {
        boolean hasAllSuits = false;
        int[] cards = new int[4];
        int count = 0;
        while (!hasAllSuits)
        {
            // get cards
            pickFourCards(cards);
            count++;

            // test cards for all suits
            hasAllSuits = hasAllSuits(cards);
        }

        // display cards
        for (int card : cards)
        {
            System.out.println(getRankString(card) + " of " + getSuitString(card));
        }
        System.out.println("Number of picks: " + count);
    }

    public static boolean hasAllSuits(int[] cards)
    {
        int[] suits = new int[4];
        for (int i = 0; i < cards.length; i++)
        {
            suits[getSuit(cards[i])]++;
        }

        boolean allSuits = true;
        for (int i = 0; i < suits.length; i++)
        {
            if (suits[i] == 0)
            {
                allSuits = false;
                break;
            }
        }

        return allSuits;
    }

    public static String getRankString(int card)
    {
        StringBuilder s = new StringBuilder();
        switch (getRank(card))
        {
        case 0:
            s.append("Ace");
            break;
        case 1:
            s.append("2");
            break;
        case 2:
            s.append("3");
            break;
        case 3:
            s.append("4");
            break;
        case 4:
            s.append("5");
            break;
        case 5:
            s.append("6");
            break;
        case 6:
            s.append("7");
            break;
        case 7:
            s.append("8");
            break;
        case 8:
            s.append("9");
            break;
        case 9:
            s.append("10");
            break;
        case 10:
            s.append("Jack");
            break;
        case 11:
            s.append("Queen");
            break;
        case 12:
            s.append("King");
        }
        return s.toString();
    }

    public static String getSuitString(int card)
    {
        StringBuilder s = new StringBuilder();
        switch (getSuit(card))
        {
        case 0:
            s.append("Spades");
            break;
        case 1:
            s.append("Hearts");
            break;
        case 2:
            s.append("Clubs");
            break;
        case 3:
            s.append("Diamonds");
        }
        return s.toString();
    }

    public static void pickFourCards(int[] cards)
    {
        for (int i = 0; i < cards.length; i++)
        {
            cards[i] = getRandomCard();
        }
    }

    public static int getRandomCard()
    {
        return (int)(Math.random() * 52);
    }

    public static int getRank(int card)
    {
        return card % 13;
    }

    public static int getSuit(int card)
    {
        return card / 13;
    }
}
