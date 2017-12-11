import java.util.Scanner;

/**
 * Game21 simulates a blackjack game between the user and computer.
 *
 * @author Karl McGuire
 * @version 12/10/17
 */
public class Game21 {
    public static void main(String[] args) {
        // scanner object for user input 
        Scanner input = new Scanner(System.in);
        // deck object for the game
        Deck d = new Deck();
        // two hand objects for the dealer (computer) and player
        Hand dealer, player;
        // playing determines if the game should continue
        boolean playing = true;
        // scores contains the number of games won by the dealer and player, 
        // respectively
        int[] scores = {0, 0};

        // loop forever (until user breaks it by "quitting")
        for(;;) {
            // shuffle the deck
            d.shuffle();
            // assign two cards to the dealer
            dealer = new Hand(d.getTopCard(), d.getTopCard());
            // assign two cards to the player 
            player = new Hand(d.getTopCard(), d.getTopCard());

            // while the user wants to keep playing
            while(playing) {
                // the dealer hits if their score is <= 16 (bad strategy btw)
                if(dealer.getScore() <= 16) {
                    dealer.addCard(d.getTopCard());
                }

                // print out the state of dealer's hand
                if(dealer.getScore() > 21) {
                    System.out.println("Dealer bust with hand: " + dealer.getScore());
                    System.out.println(dealer.toString());
                    playing = false; 
                    // add win to player
                    scores[1]++;
                    break;
                } else if(dealer.getScore() == 21) {
                    System.out.println("Dealer wins with hand: " + dealer.getScore());   
                    System.out.println(dealer.toString());
                    playing = false; 
                    // add win to dealer
                    scores[0]++;
                    break;
                } else {
                    System.out.println("Dealer hand: " + dealer.getScore());
                    System.out.println(dealer.toString());
                }

                // print out state of player's hand
                if(player.getScore() > 21) {
                    System.out.println("Player bust with hand: " + player.getScore());
                    System.out.println(player.toString());
                    playing = false; 
                    // add win to dealer
                    scores[0]++;
                    break;
                } else if(player.getScore() == 21) {
                    System.out.println("Player wins with hand: " + player.getScore());
                    System.out.println(player.toString());
                    playing = false; 
                    // add win to player
                    scores[1]++;
                    break;
                } else {
                    System.out.println("Player hand: " + player.getScore());
                    System.out.println(player.toString());
                }
                   
                // print separator for prettiness
                System.out.println("====================");

                // if the game is over, quit
                if(!playing)
                    break;

                // ask prompt for another card
                System.out.print("Hit? (Y/N): ");
                switch(input.next().charAt(0)) {
                    case 'Y': player.addCard(d.getTopCard());
                        break; 
                    case 'N': playing = false;
                        break; 
                }
            } 

            // print the dealer and player win counts
            System.out.println("====================");
            System.out.println("Dealer wins: " + scores[0]);
            System.out.println("Player wins: " + scores[1]);
            System.out.println("====================");

            // prompt to play again
            System.out.print("Play again? (Y/N): ");
            switch(input.next().charAt(0)) {
                case 'Y': playing = true;
                    break; 
                case 'N': 
                    return;
            }
        }
    }
}
