package api;

import board.TicTacToeBoard;
import game.*;
import game.GameState;

public class GameEngine {

    public Board start(String type) {
        if(type.equals("TicTacToe")) {
            return new TicTacToeBoard();
        }else {
            throw new IllegalArgumentException("Invalid type");
        }
    }

    public void move(Board board, Move move) {
        if(board instanceof TicTacToeBoard board1) {
            board1.setCell(move.getCell(), move.getPlayer().symbol());
        }else{
            throw new IllegalArgumentException();
        }
    }

    public void display(Board board) {
        if (board instanceof TicTacToeBoard board1) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(board1.getCell(i, j));

                    if (j < 2) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();

                if (i < 2) {
                    System.out.println("---------");
                }
            }
        }
    }

}
