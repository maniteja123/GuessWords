package guesswords;

import java.util.ArrayList;
import java.util.Scanner;

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

	public boolean isGameOver(String currentWord) {
		updateStatus(currentWord);
		return gameOver;
	}
	
	public void updateStatus(String currentWord) {
		String wordToMatch;
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

	public static void main() {
		final int DIFFICULTY = 4;
		Game game = new Game();
		Scanner sc = new Scanner(System.in);
		Dictionary dict = new Dictionary("sowpods.txt");
		String word = new String();
		word = sc.next();
		while(!dict.areAllCharactersUnique(word)) {
			word = sc.next();
		}
		game.setUserWord(word);
		game.setCompWord(dict.getRandomWord(DIFFICULTY));
		while(!game.isGameOver(word)) {
			System.out.println("Enter the word");
			word = sc.next();
			while(! Dictionary.isLegal(word)) {
				System.out.println("Enter the word");
				word = sc.next();
			}
			game.setComputerTurn(!game.isComputerTurn());
		}
		System.out.println(game.getWinner());
		sc.close();
	}
}
