import api.GameEngine;
import api.AIEngine;
import api.RuleEngine;
import game.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            GameEngine engine = new GameEngine();
            RuleEngine ruleEngine = new RuleEngine();
            AIEngine aiEngine = new AIEngine();
            Board board = engine.start("TicTacToe");
            System.out.println("Initial board: ");
            engine.display(board);
            while(!ruleEngine.isComplete(board).isGameOver()){
                System.out.println("Make your move");
                Player opponent = new Player("O");
                Player computer = new Player("X");
                Scanner scanner = new Scanner(System.in);
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                engine.move(board, new Move(new Cell(row, col), opponent));
                if(!ruleEngine.isComplete(board).isGameOver()){
                    Move computerMove = aiEngine.suggestMove(board, computer);
                    engine.move(board,  computerMove);
                }
                System.out.println("Current board: ");
                engine.display(board);
            }
            GameState result = ruleEngine.isComplete(board);
            System.out.println("Game Result: " + result.isGameOver());
            System.out.println(result.getWinner() == "" ? "" : "Winner: " + result.getWinner());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
