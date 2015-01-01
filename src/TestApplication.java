import java.util.Scanner;

class GuessingGame {
	
	private int bullseye;	// create private variable for bullseye
	private int ref;	// # to keep track of the lines in the arrays
	private int userGuess;	// # that user will put in
	private boolean compareGuess;	// boolean used to track if answer was correct or not
	
	Scanner userInput = new Scanner(System.in);	// create new Scanner object to capture user input
	
	private int[] answerArray = new int[9];	// array for answers attempted
	
	public void setBullseye() {	// method to set the # for user to guess
		
		System.out.println("Randomizing the number to guess...");
		bullseye = (int) (Math.random() * 10);	// declare and initialize int variable to have value between 0-9
		
		System.out.println(bullseye);	// ***TROUBLESHOOTING LINE
	}
	
	public int getBullseye() {	// return the bullseye value for the method
		
		return bullseye;	
		
	}
			
	public void setUserGuess() {	// method to set user input
		
		System.out.print("Please input your guess: ");	// message to request user input
		
		userGuess = userInput.nextInt();	// set previously input answer to the int
	}
	
	public void setAnswerArray(int userGuess) {
		
		answerArray[ref] = userGuess;
		ref++;
	
	}
	
	public int getUserGuess() {	// get user guess
	
		return userGuess;	// return the userGuess value for the method
	}
	
	public boolean checkGuess(int userGuess, int bullseye) {	// method to compare user's guess against actual bullseye and set/get compareGuess
		
		if(userGuess == bullseye) {	// if answer is correct, set variable to true
			boolean compareGuess = true;
			System.out.println("Nice job, you guessed the number!");
			return compareGuess;
		}
		else {	// if answer is incorrect, set the variable to false and output an encouraging message
			boolean compareGuess = false;
			
			if(userGuess > bullseye) {
				System.out.println("Guess was too high, try a little lower next time!");
			}
			if(userGuess < bullseye) {
				System.out.println("Guess was too low, try a little higher next time!");
			}
			
			return compareGuess;
		}
	}
	
	public void liveDieRepeat() {	// combines all the methods above to get a repeatable game going
		
		while(compareGuess == false) {
			
			setUserGuess();	// sets userGuess based on next user input
			
			getUserGuess();	// gets userGuess
			
			setAnswerArray(userGuess);	// collects answers and reference
			
			compareGuess = checkGuess(userGuess, bullseye);
			
		}
	}
	
	public void displayResults() {	// displays all the previously attempted answers in an array
		
		System.out.printf("You took %d tries to guess the answer!\n", ref);
		
		for(int x=0; x<ref; x++) {
			
			System.out.printf("Answer %2d: \t %2d \n", x+1, answerArray[x]);
			
		}
			
	}
	
	public void tryAgain() {	// gives a prompt to repeat the game
		
		bullseye = 0;
		ref = 0;
		userGuess = 0;	
		compareGuess = false;	
		
		System.out.print("Continue (Yes or No)? ");
		String userContinue = userInput.next();	// puts in user input for continuing
		
		if ("Yes".equals(userContinue)) {
			
			
			// GuessingGame nextGame = new GuessingGame();	// create a new object for the guessing game ***this might need to be refined, will it simply carry over old objects?
			
			this.setBullseye();	// set a new bullseye
			
			this.liveDieRepeat();	// get into the next game
			
			this.displayResults();	// set the results
			
			this.tryAgain(); // see if user wants to play again
			
		}
		
		else {
		
			System.out.println("Thank you for playing!  Game over.");	// game over
			
		}
			
	}
}
		
public class TestApplication {

	public static void main(String[] args) {
		
		GuessingGame newGame = new GuessingGame();
		
		newGame.setBullseye();
		
		newGame.liveDieRepeat();
		
		newGame.displayResults();
		
		newGame.tryAgain();
		
	}
}
