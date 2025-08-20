package model;

import java.util.ArrayList;
import java.util.List;

public class Match {

    private final Player playerA;
    private final Player playerB;
    private final List<Set> sets = new ArrayList<>();

    public Match(Player a, Player b) {
        this.playerA = a;
        this.playerB = b;
    }

    public void playSet(String[] games) {
        Set set = new Set(playerA, playerB);
        for (String g : games) set.playGame(g);
        sets.add(set);

        if (set.getWinner() != null) set.getWinner().winSet();
    }

    public int getSetsWon(Player player) { return player.getSetsWon(); }
}
