package model;

public interface IGame {

    void pointWonBy(Player player);

    boolean isFinished();

    Player getWinner();
}
