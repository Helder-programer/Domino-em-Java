import game.Game;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pressione ENTER para iniciar o jogo!");
        sc.nextLine();
        
        Game newGame = new Game();
        newGame.startGame();
        sc.close();
    }
}
