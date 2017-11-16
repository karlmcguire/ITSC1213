import java.util.*;

public class Driver {
    public static void main(String[] args) {
        Fraction one;
        int oneNum;
        int oneDen;

        Fraction two;
        int twoNum;
        int twoDen;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("one numerator: ");    
        oneNum = keyboard.nextInt();

        System.out.print("one denominator: ");
        oneDen = keyboard.nextInt();

        System.out.print("two numerator: ");
        twoNum = keyboard.nextInt();

        System.out.print("two denominator: ");
        twoDen = keyboard.nextInt();

        one = new Fraction(oneNum, oneDen);
        two = new Fraction(twoNum, twoDen);

        // addition
        System.out.print(one);
        System.out.print(" + ");
        System.out.print(two);
        System.out.print(" = ");
        System.out.println(one.add(two));

        // subtraction 
        System.out.print(one);
        System.out.print(" - ");
        System.out.print(two);
        System.out.print(" = ");
        System.out.println(one.subtract(two));
    
        // multiplication
        System.out.print(one);
        System.out.print(" * ");
        System.out.print(two);
        System.out.print(" = ");
        System.out.println(one.multiply(two));
    
        // division
        System.out.print(one);
        System.out.print(" / ");
        System.out.print(two);
        System.out.print(" = ");
        System.out.println(one.divide(two));
        
        // comparison
        System.out.print(one);
        System.out.print(" compareTo ");
        System.out.print(two);
        System.out.print(" = ");
        System.out.print(one);
        if(one.compareTo(two) == -1)
            System.out.print(" > ");
        else if(one.compareTo(two) == 0)
            System.out.print(" == ");
        else
            System.out.print(" < ");
        System.out.println(two);

        // random
        Fraction ran = Fraction.random();
        System.out.println("random: " + ran);
        System.out.println("decimal: " + ran.decimal());

    }
}
