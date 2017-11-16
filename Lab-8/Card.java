public class Card {
    private String suit;
    private String face;
    private int value;

    public Card() {
        suit = face = "";
        value = 0;
    }

    public Card(String s, String f) {       
        suit = s;
        face = f;
        value = 0;
        switch(face.toLowerCase()) {
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

    public String getSuit() {
        return suit;
    }

    public String getFace() {
        return face;
    }

    public int getValue() {
        return value;
    }

    public boolean equals(Card card) {
        return ((suit == card.getSuit()) && (face == card.getFace()));  
    }

    public int compareTo(Card card) {
        if(value < card.getValue())
            return -1;
        else if(value == card.getValue())
            return 0;
        else 
            return 1;
    }

    public String toString() {
        return face + " of " + suit + ", value of (" + value + ")";             
    }
}
