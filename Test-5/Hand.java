public class Hand {
    private Card[] cards = new Card[11];
    private int cardCount = 0;
    private int score = 0;

    public Hand(Card one, Card two) {
        addCard(one);
        addCard(two);
    }

    public void addCard(Card c) {
        cards[cardCount] = new Card(c.getSuit(), c.getFace());
        cardCount++;
        
        if(c.getFace() == "ace")
            score = (score + 11 > 21) ? score + 1 : score + 11; 
        else
            score = score + c.getValue();
    }

    public int getScore() {
        return score;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();

        for(int i = 0; i < cardCount; i++)
            output.append("\t" + cards[i].toString() + "\n");
    
        return output.toString(); 
    }
}
