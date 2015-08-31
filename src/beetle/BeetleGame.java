package beetle;

import java.util.Scanner;

public class BeetleGame {
	public static final Scanner INPUT = new Scanner(System.in);

	private Beetle[] bugs;

	private Die die;
	
	private int numPlayers;

	public BeetleGame(int numPlayers) {
		this.numPlayers = numPlayers;
		initBeetles();
		//create die
		die = new Die();
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Beetle.");
		int playerCount;
		
		do {
			//Get number of players
			do{

				System.out.print("How many players will be playing? (1-4):");
				playerCount = INPUT.nextInt();
			}while(playerCount < 1 && playerCount > 4);
			
			//Play game
			BeetleGame game = new BeetleGame(playerCount);
			game.play();
		} while (promptPlayAgain());
	}

	public static boolean promptPlayAgain() {
		System.out.println("\nPlay again? ");
		return isYes(INPUT.nextLine());
	}

	public static boolean isYes(String s) {
		s = s.toUpperCase();
		if (s.equals("Y") || s.equals("YES")) {
			return true;
		}
		return false;
	}
	
	private void initBeetles(){
		bugs = new Beetle[numPlayers];
		for(int i = 0; i < numPlayers; i++){
			bugs[i] = new Beetle();
		}
	}

	public void play() {
		LimitedIncrementer incrementer = new LimitedIncrementer(0, numPlayers - 1);
		int player = incrementer.getAndIncrement();
		Beetle bug = bugs[player];		
		
		while (!bug.isComplete()) {
			if (!takeTurn(player, bug)) {
				player = incrementer.getAndIncrement();
				bug = bugs[player];
			}
		}

		System.out.println("=============================================");
		System.out.println("Player " + (player + 1) + " wins!!!");
		System.out.println(bug);
		System.out.println("=============================================");
	}

	public boolean takeTurn(int player, Beetle bug) {
		boolean takeAnotherTurn = false;

		System.out.println("=============================================");
		System.out.println("\nPlayer " + (player + 1) + ", your beetle:");
		System.out.println(bug);
		System.out.print("Enter to roll: ");

		INPUT.nextLine();
		die.roll();
		bug.incrementRollCount();
		System.out.println("You rolled a " + die.getTopFace());

		switch (die.getTopFace()) {
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
