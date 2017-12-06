public class Card {
    private int value;
    private String suit;
    private String face;

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
        if(value < card.getValue()) {
            return -1;
        } else if(value > card.getValue()) {
            return 1; 
        }
        
        // hierarchy:
        // 
        // A, K, Q, J
        //
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

    public String toString() {
        return face + " of " + suit + ", value of (" + value + ")";             
    }
}
