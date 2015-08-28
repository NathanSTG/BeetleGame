package beetle;

import java.util.Scanner;

public class BeetleGame {
	public static final Scanner INPUT = new Scanner(System.in);
	
	private Beetle bug1, bug2;
	
	private Die die;
	
	public BeetleGame(){
		bug1 = new Beetle();
		bug2 = new Beetle();
		die = new Die();
	}
	
	public static void main(String[] args){
		System.out.println("Welcome to Beetle.");
		do{
			BeetleGame game = new BeetleGame();
			game.play();
		}while(promptPlayAgain());
	}
	
	public static boolean promptPlayAgain(){
		System.out.println("\nPlay again? ");
		return isYes(INPUT.nextLine());
	}
	
	public static boolean isYes(String s){
		s = s.toUpperCase();
		if(s.equals("Y") || s.equals("YES")){
			return true;
		}
		return false;
	}
	
	public void play(){
		int player = 1;
		Beetle bug = bug1;
		
		while(!bug.isComplete()){
			if(!takeTurn(player, bug)){
				if(player == 1){
					player = 2;
					bug = bug2;
				}else{
					player = 1;
					bug = bug1;
				}
			}
		}
		
		System.out.println("=============================================");
		System.out.println("Player " + player + " wins!!!");
		System.out.println(bug);
		System.out.println("=============================================");
	}
	
	public boolean takeTurn(int player, Beetle bug){
		boolean takeAnotherTurn = false;
		
		System.out.println("=============================================");
		System.out.println("\nPlayer " + player + ", your beetle:");
		System.out.println(bug);
		System.out.print("Enter to roll: ");
		
		INPUT.nextLine();
		die.roll();
		bug.incrementRollCount();
		System.out.println("You rolled a " + die.getTopFace());
		
		
		switch(die.getTopFace()){
		case 1:
			System.out.println(" (body)");
			takeAnotherTurn = bug.addBody();
			break;
		case 2:
			System.out.println(" (head)");
			takeAnotherTurn = bug.addHead();
			break;
		case 3:
			System.out.println(" (leg)");
			takeAnotherTurn = bug.addLeg();
			break;
		case 4:
			System.out.println(" (eye)");
			takeAnotherTurn = bug.addEye();
			break;
		case 5:
			System.out.println(" (feeler)");
			takeAnotherTurn = bug.addFeeler();
			break;
		default:
			System.out.println(" (tail)");
			takeAnotherTurn = bug.addTail();
			break;
		}
		
		System.out.println("Roll Count: " + bug.getRollCount());
		return takeAnotherTurn;
	}
}
