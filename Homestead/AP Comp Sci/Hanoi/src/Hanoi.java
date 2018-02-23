/**
 * Number of Disks: 		1		2		3		4		5		6		7		8		9		10
 * Number of Iterations: 	1		3		7		15		31		63		127		255		511		1023
 * Equation: let n=number of disks. let y=number of iterations. y=2^n-1 
 * 
 * @author ashley
 *
 */
public class Hanoi {
	
	private static long numberOfIterations=0;
	
	
	public static void printHanoiSolution(int numberOfDisks){
		Hanoi(numberOfDisks, 1, 2, 3);
	}
	
	private static void Hanoi(long n, int current, int pile, int target){
		numberOfIterations++;
		if(n==1){
			System.out.println("Move disk " + n +" to peg "+ target);
		}
		else{
			Hanoi(n-1, current, target, pile);
			System.out.println("Move disk " + n + " to peg "+ target);
			Hanoi(n-1, pile, current, target);
		}
	}
	
	
	public static void main(String args[]){
		for(int b=1; b<=10; b++){
			numberOfIterations=0;
			printHanoiSolution(b);
			System.out.println(b+ " iterations: " +numberOfIterations);
		}	
	}


}
