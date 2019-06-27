package main;

import java.util.List;

/**
 * The interface for a TicTacToe AI.
 */
public interface TicTacToeAI {
    /**
     * Determines the best move given the current board and piece to place.
     * This method does not mutate the input board.
     * 
     * @param board the current TicTacToe board to examine
     * @param piece the piece to place
     * @return a list containing the (row, col) move
     */
    List<Integer> bestMove(TicTacToe board, Piece piece);
}
