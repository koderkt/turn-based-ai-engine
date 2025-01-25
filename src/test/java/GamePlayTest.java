import api.AIEngine;
import api.GameEngine;
import api.RuleEngine;
import game.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GamePlayTest {
    private GameEngine gameEngine;
    private RuleEngine ruleEngine;
    private AIEngine aiEngine;

    @BeforeEach
    public void setup() {
        gameEngine = new GameEngine();
        ruleEngine = new RuleEngine();
        aiEngine = new AIEngine();
    }

    @Test
    public void checkForRowWin() {
        Board board = gameEngine.start("TicTacToe");
        int[][] moves = new int[][]{{1, 0}, {1, 1}, {1, 2}};
        playGame(board, moves);
        GameState result = ruleEngine.isComplete(board);
        Assertions.assertTrue(result.isGameOver());
        Assertions.assertEquals(result.getWinner(), "X");
    }

    @Test
    public void checkForColWin() {
        Board board = gameEngine.start("TicTacToe");
        int[][] moves = new int[][]{{0, 0}, {1, 0}, {2, 0}};
        playGame(board, moves);
        GameState result = ruleEngine.isComplete(board);
        Assertions.assertTrue(result.isGameOver());
        Assertions.assertEquals(result.getWinner(), "X");
    }
    @Test
    public void checkForDiagWin() {
        Board board = gameEngine.start("TicTacToe");
        int[][] moves = new int[][]{{0, 0}, {1, 1}, {2, 2}};
        playGame(board, moves);
        GameState result = ruleEngine.isComplete(board);
        Assertions.assertTrue(result.isGameOver());
        Assertions.assertEquals(result.getWinner(), "X");
    }
    @Test
    public void checkForRevDiagWin() {
        Board board = gameEngine.start("TicTacToe");
        int[][] moves = new int[][]{{0, 2}, {1, 1}, {2, 0}};
        playGame(board, moves);
        GameState result = ruleEngine.isComplete(board);
        Assertions.assertTrue(result.isGameOver());
        Assertions.assertEquals(result.getWinner(), "X");
    }

    @Test
    public void checkForComputerWin() {
        Board board = gameEngine.start("TicTacToe");
        int[][] moves = new int[][]{{1, 0}, {1, 1}, {2, 0}};
        playGame(board, moves);
        GameState result = ruleEngine.isComplete(board);
        Assertions.assertTrue(result.isGameOver());
        Assertions.assertEquals(result.getWinner(), "O");
    }

    private void playGame(Board board, int[][] moves) {
        int next = 0;
        while (!ruleEngine.isComplete(board).isGameOver()) {
            Player opponent = new Player("X");
            Player computer = new Player("O");
            int row = moves[next][0];
            int col = moves[next++][1];
            gameEngine.move(board, new Move(new Cell(row, col), opponent));
            if (!ruleEngine.isComplete(board).isGameOver()) {
                Move computerMove = aiEngine.suggestMove(board, computer);
                gameEngine.move(board, computerMove);
            }
        }
    }
}
