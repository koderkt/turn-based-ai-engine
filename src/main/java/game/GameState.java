package game;

public class GameState {
    private boolean gameOver;
    private String winner;

    public GameState(boolean gameOver, String winner) {
        this.gameOver = gameOver;
         this.winner = winner;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public String getWinner() {
        return winner;
    }
}
