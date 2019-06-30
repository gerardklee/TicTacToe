package main;

import java.util.List;

public class MiniMaxAI implements TicTacToeAI {
	private class MiniMaxResult {
		public int bestValue;
		public int i;
		public int j;
	}

	@Override
	public List<Integer> bestMove(TicTacToe board, Piece piece) {	
		MiniMaxResult bestMove = miniMax(board, piece, true);
		return List.of(bestMove.i, bestMove.j);
	}

	/**
	 * 
	 * @param board
	 * @param piece
	 * @param isMaximizing
	 * @return
	 */
	private MiniMaxResult miniMax(TicTacToe board, Piece piece, boolean isMaximizing) {
		// terminal state
		if (board.checkForWin() != Piece.Empty || board.isFull()) {
			MiniMaxResult result = new MiniMaxResult();
			result.bestValue = score(board, piece);
			return result;
		}

		// piece is maximizing
		if (isMaximizing) {
			MiniMaxResult result = new MiniMaxResult();
			result.bestValue = -1000;

			// try every move
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					Piece currentPiece = board.getPiece(i, j);
					if (currentPiece == Piece.Empty) {
						board.setPiece(i, j, piece);
						Piece nextPiece = piece == Piece.Player1 ? Piece.Player2 : Piece.Player1;
						MiniMaxResult maxResult = miniMax(board, nextPiece, false);
						if (maxResult.bestValue > result.bestValue) {
							result.bestValue = maxResult.bestValue;
							result.i = i;
							result.j = j;
						}
						board.clearPiece(i, j);
					}
				}
			}
			return result;
		}

		// piece is minimizing
		else {
			MiniMaxResult result = new MiniMaxResult();
			result.bestValue = 1000;

			// try every move
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					Piece currentPiece = board.getPiece(i, j);
					if (currentPiece == Piece.Empty) {
						board.setPiece(i, j, piece);
						Piece nextPiece = piece == Piece.Player1 ? Piece.Player2 : Piece.Player1;
						MiniMaxResult minResult = miniMax(board, nextPiece, false);
						if (minResult.bestValue < result.bestValue) {
							result.bestValue = minResult.bestValue;
							result.i = i;
							result.j = j;
						}
						board.clearPiece(i, j);
					}
				}
			}
			return result;
		}
	}

	/**
	 * 
	 * @param board
	 * @param piece
	 * @return
	 */
	private int score(TicTacToe board, Piece piece) {
		// check who won the game
		Piece winner = board.checkForWin();
		if (winner != Piece.Empty) {
			if (winner == piece) {
				return 1;
			} else {
				return -1;
			}
		}
		return 0;
	}
}
