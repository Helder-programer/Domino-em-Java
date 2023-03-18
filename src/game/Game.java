package game;
import pieceAndPlayer.Piece;
import pieceAndPlayer.Player;
import java.util.*;

public class Game {
// PROPRIEDADES DO GAME
    private Player player1 = new Player();
    private Player player2 = new Player();
    private Player player3 = new Player();
    private Piece piece1 = new Piece();
    private Scanner sc = new Scanner(System.in);
    private String ranking[][] = new String[3][2];
    private Random generator = new Random();


// MÉTODO PARA INICIAR O JOGO
    public void startGame() {
        registerPlayers();
        gameBrain();
        showFinalRanking();
    }

// MÉTODO PARA CADASTRAR OS JOGADORES
    void registerPlayers() {
        System.out.println("-----BEM-VINDO AO JOGO DE DOMINO EM JAVA-----");
        System.out.print("Nome do player 1: ");
        String name1 = sc.nextLine();
        System.out.print("Nome do player 2: ");
        String name2 = sc.nextLine();
        System.out.print("Nome do player 3: ");
        String name3 = sc.nextLine();
        player1.setName(name1);
        player2.setName(name2);
        player3.setName(name3);
    }

// ESTRUTURA DO JOGO
    void gameBrain() {
        for (int round = 1; round <= 3; round++) {
            if (round != 1) {
                System.out.println("\nPressione ENTER para ir para a proxima rodada:");
                sc.nextLine();
            }
            System.out.println("\n-----RODADA " + round + "-----");
// REPETIÇÃO PARA JOGADA DE CADA PLAYER
            for (int player = 1; player <= 3; player++) {
                int number1 = generator.nextInt(7);
                int number2 = generator.nextInt(7);
                piece1.setSide1(number1);
                piece1.setSide2(number2);
// DETERMINA A PEÇA DE CADA PLAYER E A AVALIAÇÃO DA PEÇA DE CADA PLAYER
                switch (player) {

                    case 1:
                        player1.setPiece("[" + piece1.getSide1() + ":" + piece1.getSide2() + "]");
                        System.out.println("A peça do " + player1.getName() + " é " + player1.getPiece());
                        player1.setPieceRate(piece1.rules());
                        System.out.println("Avalicacao da pedra do jogador " + player1.getName() + " é " + player1.getPieceRate());
                        break;

                    case 2:
                        player2.setPiece("[" + piece1.getSide1() + ":" + piece1.getSide2() + "]");
                        System.out.println("A peça do " + player2.getName() + " é " + player2.getPiece());
                        player2.setPieceRate(piece1.rules());
                        System.out.println("Avalicacao da pedra do jogador " + player2.getName() + " é " + player2.getPieceRate());
                        break;

                    case 3:
                        player3.setPiece("[" + piece1.getSide1() + ":" + piece1.getSide2() + "]");
                        System.out.println("A peça do " + player3.getName() + " é " + player3.getPiece());
                        player3.setPieceRate(piece1.rules());
                        System.out.println("Avalicacao da pedra do jogador " + player3.getName() + " é " + player3.getPieceRate());
                        break;

                    default:
                        System.out.println("Erro!");

                }
            }
            
            executeRulesOfPoints();
            showPlayersPointsOfRound();
        }
    }

/* MÉTODO PARA EXECUTAR AS REGRAS PARA PONTUAÇÃO DO JOGADOR DE ACORDO COM A 
AVALIAÇÃO DA PEÇA*/
    void executeRulesOfPoints() {
        if (player1.getPieceRate() > player2.getPieceRate() && player1.getPieceRate() > player3.getPieceRate()) {
            player1.setPointsOfRound(3);
            player1.earnTotalPoints(player1.getPointsOfRound());

        } else if (player1.getPieceRate() > player2.getPieceRate() && player1.getPieceRate() < player3.getPieceRate()) {
            player1.setPointsOfRound(2);
            player1.earnTotalPoints(player1.getPointsOfRound());

        } else if (player1.getPieceRate() < player2.getPieceRate() && player1.getPieceRate() > player3.getPieceRate()) {
            player1.setPointsOfRound(2);
            player1.earnTotalPoints(player1.getPointsOfRound());

        } else if (player1.getPieceRate() < player2.getPieceRate() && player1.getPieceRate() < player3.getPieceRate()) {
            player1.setPointsOfRound(1);
            player1.earnTotalPoints(player1.getPointsOfRound());

        }
        
        if (player2.getPieceRate() > player1.getPieceRate() && player2.getPieceRate() > player3.getPieceRate()) {
            player2.setPointsOfRound(3);
            player2.earnTotalPoints(player2.getPointsOfRound());

        } else if (player2.getPieceRate() > player1.getPieceRate() && player2.getPieceRate() < player3.getPieceRate()) {
            player2.setPointsOfRound(2);
            player2.earnTotalPoints(player2.getPointsOfRound());

        } else if (player2.getPieceRate() < player1.getPieceRate() && player2.getPieceRate() > player3.getPieceRate()) {
            player2.setPointsOfRound(2);
            player2.earnTotalPoints(player2.getPointsOfRound());

        } else if (player2.getPieceRate() < player1.getPieceRate() && player2.getPieceRate() < player3.getPieceRate()) {
            player2.setPointsOfRound(1);
            player2.earnTotalPoints(player2.getPointsOfRound());

        }

        if (player3.getPieceRate() > player1.getPieceRate() && player3.getPieceRate() > player2.getPieceRate()) {
            player3.setPointsOfRound(3);
            player3.earnTotalPoints(player3.getPointsOfRound());

        } else if (player3.getPieceRate() > player1.getPieceRate() && player3.getPieceRate() < player2.getPieceRate()) {
            player3.setPointsOfRound(2);
            player3.earnTotalPoints(player3.getPointsOfRound());

        } else if (player3.getPieceRate() < player1.getPieceRate() && player3.getPieceRate() > player2.getPieceRate()) {
            player3.setPointsOfRound(2);
            player3.earnTotalPoints(player3.getPointsOfRound());

        } else if (player3.getPieceRate() < player1.getPieceRate() && player3.getPieceRate() < player2.getPieceRate()) {
            player3.setPointsOfRound(1);
            player3.earnTotalPoints(player3.getPointsOfRound());

        }

        if (player1.getPieceRate() == player2.getPieceRate() && player1.getPieceRate() == player3.getPieceRate()) {
            player1.setPointsOfRound(2);
            player2.setPointsOfRound(2);
            player3.setPointsOfRound(2);
            player1.earnTotalPoints(player1.getPointsOfRound());
            player2.earnTotalPoints(player2.getPointsOfRound());
            player3.earnTotalPoints(player3.getPointsOfRound());


        } else if (player2.getPieceRate() == player3.getPieceRate()) {
            player2.setPointsOfRound(2);
            player3.setPointsOfRound(2);
            player2.earnTotalPoints(player2.getPointsOfRound());
            player3.earnTotalPoints(player3.getPointsOfRound());

        } else if (player1.getPieceRate() == player3.getPieceRate()) {
            player1.setPointsOfRound(2);
            player3.setPointsOfRound(2);
            player1.earnTotalPoints(player1.getPointsOfRound());
            player3.earnTotalPoints(player3.getPointsOfRound());
        }
        else if (player1.getPieceRate() == player2.getPieceRate()) {
            player1.setPointsOfRound(2);
            player2.setPointsOfRound(2);
            player1.earnTotalPoints(player1.getPointsOfRound());
            player2.earnTotalPoints(player2.getPointsOfRound());
        }
    }

// MÉTODO UTILIZADO PARA MOSTRAR PONTUAÇÃO DOS JOGADORES NA RODADA
    void showPlayersPointsOfRound() {
        System.out.println("\n-----RESULTADO DA RODADA-----");
        System.out.println("Pontuação do player " + player1.getName() + ": " + player1.getPointsOfRound());
        System.out.println("Pontuação do player " + player2.getName() + ": " + player2.getPointsOfRound());
        System.out.println("Pontuação do player " + player3.getName() + ": " + player3.getPointsOfRound());
    }


// MÉTODO UTILIZADO PARA ORDENAÇÃO E EXIBIÇÃO DO RANKING
    void showFinalRanking() {
        System.out.println("\n-----JOGO ENCERRADO-----");
        System.out.println("\n-----RANKING-----");
// ORDENAÇÃO DO RANKING
        ranking[0][0] = player1.getName();
        ranking[1][0] = player2.getName();
        ranking[2][0] = player3.getName();
        ranking[0][1] = Integer.toString(player1.getTotalPoints());
        ranking[1][1] = Integer.toString(player2.getTotalPoints());
        ranking[2][1] = Integer.toString(player3.getTotalPoints());
        String assistentName = " ";
        String assistentPoint = " ";

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Integer.parseInt(ranking[i][1]) > Integer.parseInt(ranking[j][1])) {
                    assistentName = ranking[i][0];
                    assistentPoint = ranking[i][1];
                    ranking[i][0] = ranking[j][0];
                    ranking[i][1] = ranking[j][1];
                    ranking[j][0] = assistentName;
                    ranking[j][1] = assistentPoint;
                }
            }
        }
// EXIBIÇÃO DO RANKING
        if (Integer.parseInt(ranking[0][1]) == Integer.parseInt(ranking[1][1]) && Integer.parseInt(ranking[0][1]) == Integer.parseInt(ranking[2][1])) {
            System.out.println("-----O JOGO TERMINOU EMPATADO-----");

            for (int i = 0; i < ranking.length; i++) {
                System.out.println("Jogador " + ranking[i][0] + ": " + ranking[i][1] + " Pontos");
            }

        } else {

            for (int i = 0; i < ranking.length; i++) {
                System.out.println(i + 1 + "º-Jogador " + ranking[i][0] + ": " + ranking[i][1] + " Pontos");
            }
        }
    }
}