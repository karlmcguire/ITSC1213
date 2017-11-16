import java.util.*;

public class Tutor {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);	
		
		Fraction[] frac = new Fraction[10];
		
		
		int checkNum;
		int checkDen;
		Fraction checkFrac;	

		char input = ' ';

		while(input != 'q') {

		for(int i = 0; i < frac.length; i++) {
			frac[i] = Fraction.random();
		}
			
		System.out.print("Add (+)\nSubtract (-)\nDivide (/)\nMultiply (*)\nQuit (q)\nEnter: ");
		input = keyboard.next().charAt(0);	

		switch(input) {
			case '+':
				for(int a = 0; a < frac.length; a += 2) {
					System.out.print(frac[a]);
					System.out.print(" + ");
					System.out.print(frac[a+1]);
					System.out.println(" = ");
					
					System.out.print("\tNumerator: ");
					checkNum = keyboard.nextInt();
					System.out.print("\tDenominator: ");
					checkDen = keyboard.nextInt();

					checkFrac = new Fraction(checkNum, checkDen);
					
					if(frac[a].add(frac[a+1]).equals(checkFrac)) {
						System.out.println("correct!");
					} else {
						System.out.println("wrong, the answer is " + 
								frac[a].add(frac[a+1]));
					}
				}
				break;
			case '-':
				for(int a = 0; a < frac.length; a += 2) {
					System.out.print(frac[a]);
					System.out.print(" - ");
					System.out.print(frac[a+1]);
					System.out.println(" = ");
					
					System.out.print("\tNumerator: ");
					checkNum = keyboard.nextInt();
					System.out.print("\tDenominator: ");
					checkDen = keyboard.nextInt();

					checkFrac = new Fraction(checkNum, checkDen);
					
					if(frac[a].subtract(frac[a+1]).equals(checkFrac)) {
						System.out.println("correct!");
					} else {
						System.out.println("wrong, the answer is " + 
								frac[a].subtract(frac[a+1]));
					}
				}
				break;
			case '/':
				for(int a = 0; a < frac.length; a += 2) {
					System.out.print(frac[a]);
					System.out.print(" / ");
					System.out.print(frac[a+1]);
					System.out.println(" = ");
					
					System.out.print("\tNumerator: ");
					checkNum = keyboard.nextInt();
					System.out.print("\tDenominator: ");
					checkDen = keyboard.nextInt();

					checkFrac = new Fraction(checkNum, checkDen);
					
					if(frac[a].divide(frac[a+1]).equals(checkFrac)) {
						System.out.println("correct!");
					} else {
						System.out.println("wrong, the answer is " + 
								frac[a].divide(frac[a+1]));
					}
				}
				break;
			case '*':
				for(int a = 0; a < frac.length; a += 2) {
					System.out.print(frac[a]);
					System.out.print(" * ");
					System.out.print(frac[a+1]);
					System.out.println(" = ");
					
					System.out.print("\tNumerator: ");
					checkNum = keyboard.nextInt();
					System.out.print("\tDenominator: ");
					checkDen = keyboard.nextInt();

					checkFrac = new Fraction(checkNum, checkDen);
					
					if(frac[a].multiply(frac[a+1]).equals(checkFrac)) {
						System.out.println("correct!");
					} else {
						System.out.println("wrong, the answer is " + 
								frac[a].multiply(frac[a+1]));
					}
				}
				break;
			case 'q':
				break;
		}

		}
	}
}
