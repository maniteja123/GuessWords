import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dictionary {

	private static TreeSet<String> legalWords;
	private Set<String> probablesList;

	public Dictionary(String filePath) throws IOException {
		this.legalWords = this.getInstance(filePath);
		probablesList = this.legalWords;
	}

	private TreeSet<String> getInstance(String filePath) throws IOException {
		if (legalWords == null) {
		    legalWords = new TreeSet<> ();
            FileReader file = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(file);
            List<String> lines = new ArrayList<>();
            String singleLine = "";
            while ((singleLine = reader.readLine()) != null) {
                legalWords.add(singleLine.toLowerCase());
            }
		}
		return legalWords;
	}
	
	public void updateProbablesList(String currentWord, int numOfCharsInCommon) {
		Set<String> temp = new TreeSet<>();
        Iterator<String> iter = probablesList.iterator();
		while (iter.hasNext()) {
			String s = iter.next();
			if(getNumberOfCharactersInCommon(s, currentWord) == numOfCharsInCommon) {
				temp.add(s);
			}
		}
		probablesList = temp;
        System.out.println(probablesList.size());
	}

	public Set<String> getProbablesList() {
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
		ArrayList<String> stringList = new ArrayList<String>(probablesList);
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(dictSize);
		s = stringList.get(index);
		while ((getNumberOfCharacters(s) != length) ||  !areAllCharactersUnique(s)) {
			index = randomGenerator.nextInt(dictSize);
			s = stringList.get(index);
		}
		return s;
	}

	public String getRandomWord() {
        ArrayList<String> stringList = new ArrayList<>(probablesList);
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(stringList.size());
        return stringList.get(index);
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
		return charSet1.size();
	}
	
}
