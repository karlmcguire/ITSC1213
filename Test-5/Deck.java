import java.util.Random;

public class Deck {
    private Card[] deck = new Card[52];
    private int top = 52;

    public Deck() {
        for(Card.Suit suit : Card.Suit.values())
            for(Card.Face face : Card.Face.values())
                deck[(suit.ordinal()*13)+(face.ordinal()+1)-1] = new Card(suit, face);
    }

    public Card getTopCard() {
        top = (top == 0) ? 51 : top - 1; 
        return new Card(deck[top].getSuit(), deck[top].getFace());
    }

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
}
