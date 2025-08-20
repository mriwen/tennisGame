import model.*;

public class Main {
    public static void main(String[] args) {

        Player playerA = new Player("A");
        Player playerB = new Player("B");

        // Exemple de séquence de points
        String pointsSequence = "ABABAA";

        Game game = new Game(playerA, playerB);

        for (char pointWinner : pointsSequence.toCharArray()) {
            if (pointWinner == 'A') game.pointWonBy(playerA);
            else if (pointWinner == 'B') game.pointWonBy(playerB);

            if (!game.isFinished()) {
                System.out.println("Player ".concat(playerA.getName()) + " : " + playerA.getGameScoreDisplay() +
                        " / " + "Player ".concat( playerB.getName()) + " : " + playerB.getGameScoreDisplay());
            } else {
                System.out.println(game.getWinner().getName() + " wins the game!");
            }
        }
    }
}
