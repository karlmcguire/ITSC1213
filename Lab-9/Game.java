import java.util.*;

public class Game {
    private Player[] players = new Player[2];
    private Die[]    dice    = new Die[6]; 
    private int[]    faces   = new int[6];
    private int      turn    = 1;

    public Game(Player one, Player two) {
        this.players[0] = one;
        this.players[1] = two;

        for(int i = 0; i < dice.length; i++)
            dice[i] = new Die();
    }

    public String roll() {
        for(int i = 0; i < dice.length; i++) {
            dice[i].roll();
            faces[i] = dice[i].getFace(); 
        }

        Arrays.sort(faces);

        int score = (faces[0] == 1) ? 5 : 0;

        for(int i = 0; i < faces.length; i++) {
            if(i != 0)
                score += (faces[i] == (faces[i-1] + 1)) ? 5 : 0;

                
            if(faces[i] == 1 && i >= 2) {
                if((faces[i-1] == 1) && (faces[i-2] == 1)) {
                    score = 0;
                    break;
                }
            }

        }

        String out = "";

        for(int i = 0; i < faces.length; i++)
            out += faces[i] + "" + ((i == 5) ? ": " : ", ");
        out += score;

        if(score == 0)
            players[turn].setScore(0);
        else
            players[turn].setScore(players[turn].getScore() + score); 

        return out;
    }

    public void play() {
        while(players[turn].getScore() < 100) {
            turn = (turn == 0) ? 1 : 0;
            
            System.out.println(players[turn].getName() + ": " + (turn + 1) + " -> " + roll() + " (total: " + players[turn].getScore() + ")"); 
        
            if(players[turn].getScore() >= 100) {
                System.out.println(players[turn].getName() + " won the game.");
                players[turn].won(); 
            }
        }
    };
}
