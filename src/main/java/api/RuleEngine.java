package api;

import board.TicTacToeBoard;
import game.Board;

public class RuleEngine {
    public game.GameState isComplete(Board board) {
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
                    return new game.GameState(true, firstCharacter);
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
                    return new game.GameState(true, firstCharacter);

                }
            }

            String firstCharacter = board1.getCell(0, 0);
            if (!firstCharacter.equals("-") && board1.getCell(1, 1).equals(firstCharacter) && board1.getCell(2, 2).equals(firstCharacter)) {
                return new game.GameState(true, firstCharacter);
                // Main diagonal winner
            }

            firstCharacter = board1.getCell(0, 2);
            if (!firstCharacter.equals("-") && board1.getCell(1, 1).equals(firstCharacter) && board1.getCell(2, 0).equals(firstCharacter)) {
                return new game.GameState(true, firstCharacter);

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
                return new game.GameState(true, "");

            }

            return new game.GameState(false, "");

        }else{
            throw new IllegalArgumentException("Invalid type");
        }

    }
}
