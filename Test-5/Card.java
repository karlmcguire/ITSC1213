/**
 *
 * Card implements a simple card object
 *
 * @author Karl McGuire
 * @version 12/9/17
 */

public class Card {
    private int value;
    private String suit;
    private String face;

    /**
     *
     * Basic constructor for Card.
     *
     * @param s is the suit
     * @param f is the face
     */
    public Card(String s, String f) {       
        suit = s;
        face = f.toLowerCase();

        switch(face) {
            case "jack":
            case "queen":
            case "king":
                value = 10;
                break;
            case "ace":
                value = 11;
                break;
            default:
                value = Integer.parseInt(face);
                break;
        }
    }

    /**
     * @return suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * @return face
     */
    public String getFace() {
        return face;
    }

    /**
     * @return number value
     */
    public int getValue() {
        return value;
    }

    /**
     *
     * equals checks if the card equals the param card.
     *
     * @param card to be checked
     * @return bool if equal
     */
    public boolean equals(Card card) {
        return ((suit == card.getSuit()) && (face == card.getFace()));  
    }

    /**
     *
     * compareTo is used in sorting.
     *
     * @param card to be compared
     * @return relative value
     */
    public int compareTo(Card card) {
        if(value < card.getValue()) {
            return -1;
        } else if(value > card.getValue()) {
            return 1; 
        }
        
        // hierarchy:
        // 
        // A, K, Q, J
        //
        // (not sure why this is important but it says in the instructions that
        //  this is the order the cards should be sorted in)
        if(face == "ace") {
            if(card.getFace() == "ace") {
                return 0;
            } else {
                return 1;
            }
        } else if(face == "king") {
            if(card.getFace() == "king") {
                return 0;
            } else if(card.getFace() == "ace") {
                return -1;
            } else {
                return 1;
            }
        } else if(face == "queen") {
            if(card.getFace() == "queen") {
                return 0;
            } else if(card.getFace() == "ace" || card.getFace() == "king") {
                return -1;
            } else {
                return 1;
            }
        } else if(face == "jack") {
            if(card.getFace() == "jack") {
                return 0;
            } else {
                return -1;
            }
        }
        
        return 0; 
    }

    /**
     *
     * displays card state in string form.
     *
     * @return card state
     */
    public String toString() {
        return face.substring(0, 1).toUpperCase() + face.substring(1) + " of " + suit;             
    }
}
