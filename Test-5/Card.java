/**
 * Card object for use in card games.
 *
 * @author Karl McGuire
 * @version 12/10/17
 */
public class Card {
    // value holds the numerical value of the card 
    private int value;
    // suit holds the suit enum
    private Suit suit;
    // face holds the face enum
    private Face face;

    // Suit contains all the suit enums (static by default)
    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES };
    // Face contains all the face enums (static by default)
    public enum Face { ACE, KING, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN };

    /**
     * Card constructor with suit and face parameters.
     *
     * @param s suit enum
     * @param f face enum
     */
    public Card(Suit s, Face f) {  
        suit = s;
        face = f;
        // if face is ACE then value is 11
        // if face is KING, JACK, QUEEN then value is 10
        // if face is 2-9 then value is the number itself
        value = (f == Face.ACE) ? 11 : (f == Face.JACK || f == Face.QUEEN || f == Face.KING) ? 10 : f.ordinal();
    }

    /**
     * getSuit gets the suit enum of the card.
     *
     * @return suit enum
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * getFace gets the face enum of the card.
     *
     * @return face enum
     */
    public Face getFace() {
        return face;
    }

    /**
     * getValue gets the value int of the card.
     *
     * @return value int
     */
    public int getValue() {
        return value;
    }

    /**
     * equals determines if the card equals another card.
     *
     * @param card to compare
     * @return boolean
     */
    public boolean equals(Card card) {
        return suit == card.getSuit() && face == card.getFace();  
    }

    /**
     * compareTo compares the card to another card.
     *
     * @param card to compare
     * @return int of comparison
     */
    public int compareTo(Card card) {
        // compare the card values first to see if face & suit comparisons are
        // needed
        if(value < card.getValue()) {
            // card is less than param card 
            return -1;
        } else if(value > card.getValue()) {
            // card is more than param card 
            return 1; 
        }

        // since the values are the same we know that it's some type of special
        // face card, so now we need to compare them based on this order:
        //
        // ace > king > queen > jack
        //
        // (not sure why this is important but it says in the instructions that
        //  this is the order the cards should be sorted in, so here it is)
        if(face == Face.ACE) {
            return (card.getFace() == Face.ACE) ? 0 : 1;
        } else if(face == Face.KING) {
            return (card.getFace() == Face.KING) ? 0 : (card.getFace() == Face.ACE) ? -1 : 1; 
        } else if(face == Face.QUEEN) {
            return (card.getFace() == Face.QUEEN) ? 0 : (card.getFace() == Face.ACE || card.getFace() == Face.KING) ? -1 : 1; 
        } else if(face == Face.JACK) {
            return (card.getFace() == Face.JACK) ? 0 : -1; 
        }
       
        // card is equal to param card 
        return 0; 
    }

    /**
     * toString gets the card state in String form.
     *
     * @return card state
     */
    public String toString() {
        // convert card face to string with first letter capitalized 
        String f = face.name().substring(0, 1) + face.name().substring(1).toLowerCase();
        // convert card suit to string with first letter capitalized 
        String s = suit.name().substring(0, 1) + suit.name().substring(1).toLowerCase();
        // return string "Face of Suit (Value#)"
        return f + " of " + s + " (" + value + ")";
    }
}
