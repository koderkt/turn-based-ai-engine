package api;

import board.TicTacToeBoard;
import game.Board;
import game.Cell;
import game.Move;
import game.Player;

public class AIEngine {
    public Move suggestMove(Board board, Player player) {
        if(board instanceof TicTacToeBoard board1) {
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(board1.getCell(i,j).equals("-")){
                        return new Move(new Cell(i, j), player);
                    }
                }
            }
            throw new IllegalStateException();

        }else{
            throw new IllegalArgumentException();
        }
    }
}
