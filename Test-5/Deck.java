import java.util.Random;

public class Deck {
    private Card[] deck = new Card[52];
    private final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private final String[] faces = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private int top = 52;

    /**
     *
     * Basic no-args constructor for populating the array.
     */
    public Deck() {
        int c = 0;
        for(int i = 0; i < suits.length; i++)
            for(int a = 0; a < faces.length; a++, c++)
                deck[c] = new Card(suits[i], faces[a]);
    }

    // returns a copy of the top card 
    public Card getTopCard() {
        top = (top == 0) ? 51 : top - 1; 
        return new Card(deck[top].getSuit(), deck[top].getFace());
    }

    // shuffle randomly
    public void shuffle() {
        Random rand = new Random();
        Card tmp;
        int r;

        for(int i = deck.length; i > 1; i--) {
            r = rand.nextInt(i); 
            tmp = deck[i-1];
            deck[i-1] = deck[r];
            deck[r] = tmp;
        }

        top = 52;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();

        for(int i = 0; i < deck.length; i++)
            output.append((i+1) + ": " +deck[i].toString() + "\n");

        return output.toString();
    }
}
