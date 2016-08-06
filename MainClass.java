import java.io.IOException;
import java.util.Scanner;

public class MainClass {
    private static final int BIGGEST_POSSIBLE_WORD_SIZE = 26;
    public static void main(String []args) {
        String charInTest = "ACMO";
        Dictionary dict = null;
        try {
            dict = new Dictionary("C:\\Users\\abadrinath\\Desktop\\sowpods.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        final int DIFFICULTY = 4;
        Game game = new Game();
        Scanner sc = new Scanner(System.in);
        String word = new String();
        word = sc.next().toLowerCase();
        while(!dict.areAllCharactersUnique(word)) {
            word = sc.next().toLowerCase();
        }
        game.setUserWord(word);
        game.setCompWord(dict.getRandomWord(DIFFICULTY));
        do {
            System.out.println("Guess the word");
            word = sc.next().toLowerCase();
            while(! Dictionary.isLegal(word)) {
                System.out.println("Enter a legal word");
                word = sc.next().toLowerCase();
            }
            game.updateStatus(dict, word);
            if (game.isGameOver(dict, word)) {
                System.out.println("You win. lul.");
                break;
            }
            game.setComputerTurn(!game.isComputerTurn());
            game.updateStatus(dict, dict.getRandomWord());
            game.setComputerTurn(!game.isComputerTurn());
        } while(!game.isGameOver(dict, word));
        System.out.println(game.getWinner());
        sc.close();
    }
}
