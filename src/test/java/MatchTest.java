import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatchTest {

    private Player playerA;
    private Player playerB;

    @BeforeEach
    public void setup() {
        playerA = new Player("A");
        playerB = new Player("B");
    }

    private void playSequence(Game game, String sequence) {
        for (char c : sequence.toCharArray()) {
            if (c == 'A') game.pointWonBy(playerA);
            else if (c == 'B') game.pointWonBy(playerB);
        }
    }

    @Test
    public void testPlayerAWinsGame() {
        Game game = new Game(playerA, playerB);
        playSequence(game, "AAAA");
        assertEquals(1, playerA.getGamesWon());
        assertEquals(0, playerB.getGamesWon());
    }

    @Test
    public void testDeuceAndAdvantage() {
        Game game = new Game(playerA, playerB);
        playSequence(game, "AAABBB");
        assertEquals("40", playerA.getGameScoreDisplay());
        assertEquals("40", playerB.getGameScoreDisplay());
        playSequence(game, "AA");
        assertEquals(1, playerA.getGamesWon());
    }

    @Test
    public void testSetWin() {
        Set set = new Set(playerA, playerB);
        for (int i = 0; i < 6; i++) set.playGame("AAAA");
        assertEquals(playerA, set.getWinner());
    }

    @Test
    public void testMatchWin() {
        Match match = new Match(playerA, playerB);
        match.playSet(new String[] {"AAAA","AAAA","AAAA","AAAA","AAAA","AAAA"});
        assertEquals(1, match.getSetsWon(playerA));
    }
}
