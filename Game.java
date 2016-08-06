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

	public boolean isGameOver(Dictionary dict, String currentWord) {
		return gameOver;
	}
	
	public void updateStatus(Dictionary dict, String currentWord) {
		String wordToMatch;
		if (isComputerTurn()) {
            int numOfCharsInCommon = dict.getNumberOfCharactersInCommon(currentWord, userWord);
			dict.updateProbablesList(currentWord, numOfCharsInCommon);
		} else {
		    System.out.println("Number of characters in common: " + dict.getNumberOfCharactersInCommon(currentWord, compWord));
        }
		if(isComputerTurn()) {
			wordToMatch = userWord;
			setWinner("computer");
		} else {
			wordToMatch = compWord;
			setWinner("user");
		}
		gameOver = wordToMatch.equals(currentWord);
	}
	
	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
	
}
