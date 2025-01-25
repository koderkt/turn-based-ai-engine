package game;

public class GameResult {
    private boolean gameOver;
    private String winner;

    public GameResult(boolean gameOver, String winner) {
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
