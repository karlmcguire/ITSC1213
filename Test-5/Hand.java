/**
 * Hand object for use in card games.
 *
 * @author Karl McGuire
 * @version 12/10/17
 */
public class Hand {
    // cards is the collection of card objects for this hand
    //
    // (i would use an ArrayList but i'm not sure if that's allowed, so i just
    //  assumed that the maximum amount of cards someone would have in their 
    //  hand is 11 and keep cardCount for the current size of the "actual" hand)
    private Card[] cards = new Card[11];
    // cardCount is the current number of card objects in the cards array
    private int cardCount = 0;
    // score is the current sum of all card values
    private int score = 0;

    /**
     * Hand constructor with first two cards (blackjack).
     *
     * @param one Card to add
     * @param two Card to add
     */
    public Hand(Card one, Card two) {
        // add first card to hand
        addCard(one);
        // add second card to hand
        addCard(two);
    }

    /**
     * addCard adds a card to the hand and updates each field accordingly.
     *
     * @param c Card to add
     */
    public void addCard(Card c) {
        // add the card to the cards array (using cardCount since we can't use
        // an ArrayList)
        cards[cardCount] = new Card(c.getSuit(), c.getFace());
        // update cardCount to reflect the new size of cards 
        cardCount++;
       
        // check if an ace was just added, and if so update the score to either
        // +1 or +11 based on whether doing so would bust or not
        if(c.getFace() == Card.Face.ACE)
            score = (score + 11 > 21) ? score + 1 : score + 11; 
        else
            score = score + c.getValue();
    }

    /**
     * getScore gets the current score of the hand.
     *
     * @return sum of all cards
     */
    public int getScore() {
        return score;
    }

    /**
     * toString gets the state of the hand in String form.
     *
     * @return current state of hand
     */
    public String toString() {
        // using StringBuilder because we'll be doing appending
        StringBuilder output = new StringBuilder();

        // for each card append to output
        for(int i = 0; i < cardCount; i++)
            // tab character for prettiness
            output.append("\t" + cards[i].toString() + "\n");
   
        return output.toString(); 
    }
}
