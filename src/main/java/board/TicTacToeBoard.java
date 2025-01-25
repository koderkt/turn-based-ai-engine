package board;

import game.Board;
import game.Cell;

public class TicTacToeBoard extends Board {
    private String[][] board = new String[3][3];
    public TicTacToeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "-";
            }
        }
    }

    public String getCell(int row, int col){
        return board[row][col];
    }

    public void setCell(Cell cell, String symbol){
        board[cell.getRow()][cell.getCol()] = symbol;
    }
}
