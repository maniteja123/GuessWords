package guesswords;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Dictionary {

	private static TreeSet<String> legalWords;
	private TreeSet<String> probablesList;

	public Dictionary(String filePath) {
		this.legalWords = this.getInstance(filePath);
		probablesList = this.legalWords;
	}

	private TreeSet<String> getInstance(String filePath) {
		if (Dictionary.legalWords != null) {
			Scanner sc = new Scanner(filePath);
			while (sc.hasNext()) {
				Dictionary.legalWords.add(sc.next().toLowerCase());
			}
			sc.close();
		}
		return Dictionary.legalWords;
	}
	
	public void updateProbablesList(String currentWord, int numOfCharsInCommon) {
		Iterator<String> iter = probablesList.iterator();
		while (iter.hasNext()) {
			String s = iter.next();
			if(getNumberOfCharactersInCommon(s, currentWord) != numOfCharsInCommon) {
				probablesList.remove(s);
			}
		}
	}

	public TreeSet<String> getProbablesList() {
		return probablesList;
	}

	public void setProbablesList(TreeSet<String> probablesList) {
		this.probablesList = probablesList;
	}

	private int getSize() {
		return Dictionary.legalWords.size();
	}

	public static Boolean isLegal(String word) {
		return legalWords.contains(word);
	}

	public int getNumberOfCharacters(String word) {
		return word.length();
	}

	public String getRandomWord(int length) {
		String s = new String();
		int dictSize = this.getSize();
		ArrayList<String> stringList = new ArrayList<String>(Dictionary.legalWords);
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(dictSize);
		s = stringList.get(index);
		while ((getNumberOfCharacters(s) != length) ||  !areAllCharactersUnique(s)) {
			index = randomGenerator.nextInt(dictSize);
			s = stringList.get(index);
		}
		return s;
	}


	/**
	 * Finds out if all the characters in a word are unique. Does this by
	 * putting all unique characters in word inside a list and taking all the
	 * words from the list and forming another word comprised only of the unique
	 * characters from the original word. If both words are equal, returns true.
	 */
	public Boolean areAllCharactersUnique(String word) {
		List<Character> characterList = new ArrayList<>();
		for (int i = 0; i < word.length(); i++) {
			if (!(characterList.contains(word.charAt(i)))) {
				characterList.add(word.charAt(i));
			}
		}
		String uniqueCharacters = "";
		for (char c : characterList) {
			uniqueCharacters += c;
		}

		return word.equals(uniqueCharacters);
	}

	/**
	 * Takes two words and returns the number of characters it has in common.
	 * Does this by putting all words in word1 inside a set and all words in
	 * word2 inside another set and finding the intersection of the two sets
	 */
	public int getNumberOfCharactersInCommon(String word1, String word2) {
		Set<Character> charSet1 = new HashSet<>();
		Set<Character> charSet2 = new HashSet<>();

		for (int i = 0; i < word1.length(); i++) {
			charSet1.add(word1.charAt(i));
		}

		for (int i = 0; i < word2.length(); i++) {
			charSet2.add(word2.charAt(i));
		}

		/* Returns the intersection */
		charSet1.retainAll(charSet2);

		Character[] commonWords = charSet1.toArray(new Character[0]);

		return commonWords.length;
	}
	
}
