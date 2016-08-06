import java.util.HashSet;
import java.util.TreeSet;

public class Dictionary {
    private static TreeSet<String> legalWords;

    public Dictionary(String filePath) {

    }

    public static Boolean isLegal(String word) {
        return legalWords.contains(word);
    }

    public int getNumberOfCharacters(String word) {
        return word.length();
    }

    public Boolean areAllCharactersUnique(String word) {
        return true;
    }

    public int getNumberOfCharactersInCommon(String word1, String word2) {
        HashSet<Character> charSet1 = new HashSet<> ();
        HashSet<Character> charSet2 = new HashSet<> ();

        for (int i = 0; i < word1.length(); i ++) {
            charSet1.add(word1.charAt(i));
        }

        for (int i = 0; i < word2.length(); i ++) {
            charSet2.add(word2.charAt(i));
        }

        charSet1.retainAll(charSet2);

        Character[] commonWords = charSet1.toArray(new Character[0]);

        return commonWords.length;
    }

}
