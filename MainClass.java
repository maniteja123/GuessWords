package guesswords;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClass {

	static Map<String, Integer> level;
	
	public static void main(String []args) {
		level = new HashMap<> ();
		level.put("EASY", 4);
		level.put("DIFFICULT", 5);
		level.put("HARD", 6);
		Dictionary dict = null;
        try {
        	dict = new Dictionary("sowpods.txt");
//         dict = new Dictionary("C:\\Users\\abadrinath\\Desktop\\sowpods.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Game game = new Game();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of matches");
        int T = sc.nextInt();
        for(int i=1; i<=T; i++) {
        	System.out.println("Enter the difficulty");
        	String s = sc.next().toUpperCase();
        	String word = new String();
	        System.out.println("Enter your word");
	        word = sc.next().toLowerCase();
	        while(!dict.areAllCharactersUnique(word) || !Dictionary.isLegal(word)) {
	            System.out.println("Enter a legal word and also has unique characters ");
	            word = sc.next().toLowerCase();
	        }
	        game.setUserWord(word);
	        game.setCompWord(dict.getRandomWord(level.get(s)));
	        do {
	            System.out.println("Guess the word");
	            word = sc.next().toLowerCase();
	            while(! Dictionary.isLegal(word)) {
	                System.out.println("Enter a legal word");
	                word = sc.next().toLowerCase();
	            }
	        } while(!game.isGameOver(dict, word));
	        System.out.println(game.getWinner());
		}	
        sc.close();
    }
}
