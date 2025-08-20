package model;

public class Game implements IGame {

    private final Player playerA;
    private final Player playerB;
    private Player advantagePlayer = null;
    private Player winner = null;

    public Game(Player a, Player b) {
        this.playerA = a;
        this.playerB = b;
    }

    @Override
    public void pointWonBy(Player player) {
        if (winner != null) return;

        Player opponent = (player == playerA) ? playerB : playerA;

        if (playerA.getGamePoints() >= 3 && playerB.getGamePoints() >= 3) {
            if (advantagePlayer == null) advantagePlayer = player;
            else if (advantagePlayer == player) playerWinsGame(player);
            else advantagePlayer = null;
            return;
        }

        player.winPoint();
        if (player.getGamePoints() > 3) playerWinsGame(player);
    }

    private void playerWinsGame(Player player) {
        player.winGame();
        winner = player;
        playerA.resetGamePoints();
        playerB.resetGamePoints();
        advantagePlayer = null;
    }

    @Override
    public boolean isFinished() { return winner != null; }

    @Override
    public Player getWinner() { return winner; }
}
