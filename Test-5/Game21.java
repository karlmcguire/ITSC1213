import java.util.Scanner;

/**
 *
 * Game21 implements a basic blackjack game.
 *
 * @author Karl McGuire
 * @version 12/9/17
 */
public class Game21 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Deck d = new Deck();
        Hand dealer, player;
        boolean playing = true;

        for(;;) {
            d.shuffle();
            dealer = new Hand(d.getTopCard(), d.getTopCard());
            player = new Hand(d.getTopCard(), d.getTopCard());

            while(playing) {
                if(dealer.getScore() <= 16) {
                    dealer.addCard(d.getTopCard());
                }

                if(dealer.getScore() > 21) {
                    System.out.println("Dealer bust with hand: " + dealer.getScore());
                    System.out.println(dealer.toString());
                    playing = false; 
                } else if(dealer.getScore() == 21) {
                    System.out.println("Dealer wins with hand: " + dealer.getScore());   
                    System.out.println(dealer.toString());
                    playing = false; 
                } else {
                    System.out.println("Dealer hand: " + dealer.getScore());
                    System.out.println(dealer.toString());
                }

                if(player.getScore() > 21) {
                    System.out.println("Player bust with hand: " + player.getScore());
                    System.out.println(player.toString());
                    playing = false; 
                } else if(player.getScore() == 21) {
                    System.out.println("Player wins with hand: " + player.getScore());
                    System.out.println(player.toString());
                    playing = false; 
                } else {
                    System.out.println("Player hand: " + player.getScore());
                    System.out.println(player.toString());
                }
                    
                System.out.println("====================");

                if(!playing)
                    break;

                System.out.print("Hit? (Y/N): ");
                
                switch(input.next().charAt(0)) {
                    case 'Y': player.addCard(d.getTopCard());
                        break; 
                    case 'N': playing = false;
                        break; 
                }
            } 
            
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
