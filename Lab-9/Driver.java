import java.util.*;

public class Driver {
    public static void main(String[] args) {
        
   
        Scanner keyboard = new Scanner(System.in);

        Game game;
        Player one;
        Player two;
        boolean play = true;

        System.out.print("Enter player 1 name: ");
        one = new Player(keyboard.nextLine());
        
        System.out.print("Enter player 2 name: ");
        two = new Player(keyboard.nextLine());

        while(play) {
            one.setScore(0);
            two.setScore(0);

            game = new Game(one, two);
            game.play(); 
            System.out.println("Scores: " + one.getName() + " = " + one.getGamesWon() + ", " + two.getName() + " = " + two.getGamesWon());

            System.out.print("Play again? ");
            if(keyboard.nextLine() == "no\n")
                play = false;
        }
    }
}
