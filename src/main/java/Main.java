import api.GameEngine;
import game.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            GameEngine engine = new GameEngine();
            Board board = engine.start("TicTacToe");
            System.out.println("Initial board: ");
            engine.display(board);
            while(!engine.isComplete(board).isGameOver()){
                System.out.println("Make your move");
                Player opponent = new Player("O");
                Player computer = new Player("X");
                Scanner scanner = new Scanner(System.in);
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                engine.move(board, opponent, new Move(new Cell(row, col)));
                if(!engine.isComplete(board).isGameOver()){
                    Move computerMove = engine.suggestMove(board);
                    engine.move(board, computer, computerMove);
                }
                System.out.println("Current board: ");
                engine.display(board);
            }
            GameResult result = engine.isComplete(board);
            System.out.println("Game Result: " + result.isGameOver());
            System.out.println(result.getWinner() == "" ? "" : "Winner: " + result.getWinner());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
