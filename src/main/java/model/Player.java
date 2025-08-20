package model;

public class Player {

    private final String name;
    private int gamePoints = 0;
    private int gamesWon = 0;
    private int setsWon = 0;

    public Player(String name) { this.name = name; }

    public String getName() { return name; }

    public int getGamePoints() { return gamePoints; }
    public void winPoint() { gamePoints++; }
    public void resetGamePoints() { gamePoints = 0; }

    public int getGamesWon() { return gamesWon; }
    public void winGame() { gamesWon++; }

    public int getSetsWon() { return setsWon; }
    public void winSet() { setsWon++; }

    public String getGameScoreDisplay() {
        switch (gamePoints) {
            case 0: return "0";
            case 1: return "15";
            case 2: return "30";
            case 3: return "40";
            default: return "40"; // deuce/advantage
        }
    }
}
