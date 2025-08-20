package model;

import java.util.ArrayList;
import java.util.List;

public class Set implements ISet {
    private final Player playerA;
    private final Player playerB;
    private final List<Game> games = new ArrayList<>();
    private Player winner = null;

    public Set(Player a, Player b) {
        this.playerA = a;
        this.playerB = b;
    }

    @Override
    public void playGame(String sequence) {
        Game game = new Game(playerA, playerB);
        for (char c : sequence.toCharArray()) {
            if (c == 'A') game.pointWonBy(playerA);
            else if (c == 'B') game.pointWonBy(playerB);
        }
        games.add(game);

        if (playerA.getGamesWon() >= 6 && playerA.getGamesWon() - playerB.getGamesWon() >= 2) winner = playerA;
        else if (playerB.getGamesWon() >= 6 && playerB.getGamesWon() - playerA.getGamesWon() >= 2) winner = playerB;
    }

    @Override
    public Player getWinner() { return winner; }
}
