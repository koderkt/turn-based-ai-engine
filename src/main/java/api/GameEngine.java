package api;

import board.TicTacToeBoard;
import game.*;

import java.util.Objects;

public class GameEngine {
    public Board start(String type) {
        if(type.equals("TicTacToe")) {
            return new TicTacToeBoard();
        }else {
            throw new IllegalArgumentException("Invalid type");
        }
    }

    public void move(Board board, Player player, Move move) {
        if(board instanceof TicTacToeBoard board1) {
            board1.setCell(move.getCell(), player.symbol());
        }else{
            throw new IllegalArgumentException();
        }
    }

    public GameResult isComplete(Board board) {
        if(board instanceof TicTacToeBoard board1) {
            boolean rowComplete;
            for (int i = 0; i < 3; i++) {
                rowComplete = true;
                String firstCharacter = board1.getCell(i, 0);
                if (firstCharacter.equals("-")) {
                    continue;
                }
                for (int j = 1; j < 3; j++) {
                    if (!board1.getCell(i, j).equals(firstCharacter)) {
                        rowComplete = false;
                        break;
                    }
                }
                if (rowComplete) {
                    return new GameResult(true, firstCharacter);
                }
            }

            boolean colComplete;
            for (int i = 0; i < 3; i++) {
                colComplete = true;
                String firstCharacter = board1.getCell(0, i);
                if (firstCharacter.equals("-")) {
                    continue;
                }
                for (int j = 1; j < 3; j++) {
                    if (!board1.getCell(j, i).equals(firstCharacter)) {
                        colComplete = false;
                        break;
                    }
                }
                if (colComplete) {
                    return new GameResult(true, firstCharacter);

                }
            }

            String firstCharacter = board1.getCell(0, 0);
            if (!firstCharacter.equals("-") && board1.getCell(1, 1).equals(firstCharacter) && board1.getCell(2, 2).equals(firstCharacter)) {
                return new GameResult(true, firstCharacter);
                // Main diagonal winner
            }

            firstCharacter = board1.getCell(0, 2);
            if (!firstCharacter.equals("-") && board1.getCell(1, 1).equals(firstCharacter) && board1.getCell(2, 0).equals(firstCharacter)) {
                return new GameResult(true, firstCharacter);

            }

            boolean isBoardFull = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board1.getCell(i, j).equals("-")) {
                        isBoardFull = false;
                        break;
                    }
                }
                if (!isBoardFull) {
                    break;
                }
            }
            if (isBoardFull) {
                return new GameResult(true, "");

            }

            return new GameResult(false, "");

        }else{
            throw new IllegalArgumentException("Invalid type");
        }

    }

    public Move suggestMove(Board board) {
       if(board instanceof TicTacToeBoard board1) {
           for(int i = 0; i < 3; i++){
               for(int j = 0; j < 3; j++){
                   if(board1.getCell(i,j).equals("-")){
                       return new Move(new Cell(i, j));
                   }
               }
           }
           throw new IllegalStateException();

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
