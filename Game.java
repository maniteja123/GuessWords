package guesswords;

public class Game {

	private String compWord, userWord, winner;
	private boolean isComputerTurn, gameOver;

	public Game() {
		isComputerTurn = false;
		gameOver = false;
	}

	public boolean isComputerTurn() {
		return isComputerTurn;
	}

	public void setComputerTurn(boolean isComputerTurn) {
		this.isComputerTurn = isComputerTurn;
	}

	public String getCompWord() {
		return compWord;
	}

	public void setCompWord(String compWord) {
		this.compWord = compWord;
	}

	public String getUserWord() {
		return userWord;
	}

	public void setUserWord(String userWord) {
		this.userWord = userWord;
	}

	
	/** The game status function to update the position
	 * of the players 
	 * 1. Get the user guess
	 * 2. Check if it matches the computer word
	 * 3. Else output the number of characters in the guess
	 * 4. Then the computer updates the probable list
	 * 5. Also updates the Game over status
	 * @param dict
	 * @param userGuess
	 * @return
	 */
	public boolean isGameOver(Dictionary dict, String userGuess) {
		System.out.println("Number of characters in common: " + dict.getNumberOfCharactersInCommon(userGuess, compWord));
    	setWinner("user");
		gameOver = userGuess.equals(compWord);
		String compGuess = dict.getRandomWord();
		int numOfCharsInCommon = dict.getNumberOfCharactersInCommon(compGuess, userWord);
		dict.updateProbablesList(compGuess, numOfCharsInCommon);
		System.out.println(compGuess);
		System.out.println(dict.getProbablesList().size());
		if(dict.getProbablesList().size() < 10) 
			for(String s : dict.getProbablesList())
				System.out.print(s + " ");
		if(!gameOver) {
//			System.out.println(gameOver);
			gameOver = compGuess.equals(userWord);
			setWinner("computer");
		}
		return gameOver;
	}
	
	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
	
}
