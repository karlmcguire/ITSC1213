import java.util.Random;

/**
 * Deck object for use in card games.
 *
 * @author Karl McGuire
 * @version 12/10/17
 */
public class Deck {
    // deck contains the collection of card objects 
    private Card[] deck = new Card[52];
    // top is the location in deck array of "top" (current) card
    private int top = 52;

    /**
     * Deck constructor populates fields with Card objects.
     */
    public Deck() {
        // fill each position in deck array with a card object 
        for(Card.Suit suit : Card.Suit.values())
            for(Card.Face face : Card.Face.values())
                deck[(suit.ordinal()*13)+(face.ordinal()+1)-1] = new Card(suit, face);
    }

    /**
     * getTopCard returns a copy of the top card of the deck.
     *
     * @return top Card
     */
    public Card getTopCard() {
        // move top down one (or roll over if at 0) 
        top = (top == 0) ? 51 : top - 1; 
        // return copy of the top card
        return new Card(deck[top].getSuit(), deck[top].getFace());
    }

    /**
     * shuffle randomly sorts the cards in the deck.
     */
    public void shuffle() {
        // random object for randomizing card locations in deck array 
        Random rand = new Random();
        // tmp object for temporarily storing card when moving cards around
        Card tmp;
        // r will be the new random location of cards
        int r;

        // loop over each card in the deck
        for(int i = deck.length; i > 1; i--) {
            // get a random integer with a max value of the cards left
            r = rand.nextInt(i); 
            // swap cards using the random position
            tmp = deck[i-1];
            deck[i-1] = deck[r];
            deck[r] = tmp;
        }

        // reset the top count since the deck is different now
        top = 52;
    }
}
