public class Deck {
    private Card[] deck = new Card[52];

    private final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private final String[] faces = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    public Deck() {
        System.out.println(suits.length * faces.length);

        int c = 0;
        for(int i = 0; i < suits.length; i++)
            for(int a = 0; a < faces.length; a++, c++)
                deck[c] = new Card(suits[i], faces[a]);
    }

    public String toString() {
        StringBuilder output = new StringBuilder();

        for(int i = 0; i < deck.length; i++)
            output.append((i+1) + ": " +deck[i].toString() + "\n");

        return output.toString();
    }
}
