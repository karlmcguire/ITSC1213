import java.util.*;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    public Fraction(int num, int den) {
        numerator = num;
        denominator = den;
        
        if(den == 0)
            denominator = 1;
    }

    public Fraction subtract(Fraction frac) {
        int newDen;
        int newNum;

        if(denominator == frac.getDenominator()) {
            newDen = denominator;
            newNum = numerator - frac.getNumerator();
        } else {
            newDen = denominator * frac.getDenominator(); 
            newNum = (numerator * frac.getDenominator()) - 
                     (frac.getNumerator() * denominator);
        }
        
        Fraction out = new Fraction(newNum, newDen);
        out.simplify();
        return out;
    }

    public Fraction add(Fraction frac) {
        int newDen;
        int newNum;

        if(denominator == frac.getDenominator()) {
            newDen = denominator;
            newNum = numerator + frac.getNumerator();
        } else {
            newDen = denominator * frac.getDenominator(); // 30
            newNum = (numerator * frac.getDenominator()) + 
                     (frac.getNumerator() * denominator);
        }
        
        Fraction out = new Fraction(newNum, newDen);
        out.simplify(); 
        return out;
    }

    public Fraction multiply(Fraction frac) {
        Fraction out = new Fraction(numerator * frac.getNumerator(),
                            denominator * frac.getDenominator());
        out.simplify();
        return out;
    }

    public Fraction divide(Fraction frac) {
        Fraction out = new Fraction(numerator * frac.getDenominator(),
                            denominator * frac.getNumerator());
        out.simplify();
        return out;
    }

    public int compareTo(Fraction frac) {
        if(denominator == frac.getDenominator()) {
            if(frac.getNumerator() > numerator)
                return 1;
            else if(frac.getNumerator() == numerator)
                return 0;
            else
                return -1;
        } else {
            int commonDen = denominator * frac.getDenominator();

            int newNumOne = numerator * frac.getDenominator();
            int newNumTwo = frac.getNumerator() * denominator;
            
            if(newNumTwo > newNumOne)
                return 1;
            else if(newNumTwo == newNumOne)
                return 0;
            else
                return -1;
        }
    }

    public boolean equals(Fraction frac) {
        if(numerator == frac.getNumerator() && denominator == frac.getDenominator())
            return true;
        else
            return false;
    }

    public double decimal() {
        return (double)numerator / (double)denominator; 
    }

    public static Fraction random() {
        Random rand = new Random();
        int newDen = rand.nextInt(100);
        int newNum = rand.nextInt(newDen);
        return new Fraction(newNum, newDen);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void simplify() {
        int gcdn = gcd(numerator, denominator);
        numerator = (numerator / gcdn);
        denominator = (denominator / gcdn);
    }

    public String toString() {
        return numerator + "/" + denominator;
    }
}
