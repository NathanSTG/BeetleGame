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
		BeetleGame game = new BeetleGame();
		game.play();
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
		System.out.println("=============================================");
	}
	
	public boolean takeTurn(int player, Beetle bug){
		System.out.println("=============================================");
		System.out.println("\nPlayer " + player + ", your beetle:");
		System.out.println(bug);
		System.out.print("Enter to roll: ");
		
		INPUT.nextLine();
		die.roll();
		System.out.println("You rolled a " + die.getTopFace());
		
		switch(die.getTopFace()){
		case 1:
			System.out.println(" (body)");
			return bug.addBody();
		case 2:
			System.out.println(" (head)");
			return bug.addHead();
		case 3:
			System.out.println(" (leg)");
			return bug.addLeg();
		case 4:
			System.out.println(" (eye)");
			return bug.addEye();
		case 5:
			System.out.println(" (feeler)");
			return bug.addFeeler();
		default:
			System.out.println(" (tail)");
			return bug.addTail();
		}
	}
}
