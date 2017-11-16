import java.util.*;

public class Driver {
    public static void main(String[] args) {
        Die die = new Die(6);
        Scanner keyboard = new Scanner(System.in);
    
        int[] faces = new int[2];
        int sum = 0;
        int point = 0;
        boolean over = false;

        while(true) {
            over = false;
            faces[0] = faces[1] = sum = point = 0;

            for(int i = 0; over == false; i++) {
                die.roll();
                faces[0] = die.getFace();
                die.roll();
                faces[1] = die.getFace();
                sum = faces[0] + faces[1];  

                System.out.println("throw " + i + ": sum = " + sum + ", point = " + point);
                
                if(i == 0) {
                    if(sum == 7 || sum == 11) {
                        win(i, sum);    
                        over = true;
                    } else if(sum == 2 || sum == 3 || sum == 12) {
                        lose(i, sum);   
                        over = true;
                    } else {
                        point = sum;
                    }
                } else {
                    if(sum == point) {
                        win(i, sum);    
                        over = true;    
                    } else if (sum == 7) {
                        lose(i, sum);   
                        over = true;    
                    } else {
                        // throw again
                    }
                }
            }

            System.out.print("Go again (Y/y) or quit (Q/q)? ");
            switch(keyboard.next().charAt(0)) {
                case 'Q':
                case 'q':
                    return;
                case 'Y':
                case 'y':
                default:
                    break;
            }
        }
    }

    private static void win(int tc, int sum) {
        System.out.println("You won with a sum of " + sum + " on throw " + tc);
    }

    private static void lose(int tc, int sum) {
        System.out.println("You lost with a sum of " + sum + " on throw " + tc);
    }
}
