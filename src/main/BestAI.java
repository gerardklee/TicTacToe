package main;

import java.util.List;

public class BestAI implements TicTacToeAI {

	@Override
	public List<Integer> bestMove(TicTacToe board, Piece piece) {
		
		// occupy middle to defend diagonals and cross if spot is open
		if (board.getPiece(1, 1).equals(Piece.Empty)) {
			System.out.println("not yet occupied and called");
			return List.of(1, 1);
		}
		
		// if middle is occupied by opponent
		if (board.getPiece(1, 1).equals(Piece.Player1)) {
			System.out.println("occupied in first turn and called");
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i == 0 && j == 0 && board.getPiece(i, j).equals(Piece.Player1)) {
						return List.of(i + 2, j + 2);
					}
					if (i == 0 && j == 1 && board.getPiece(i, j).equals(Piece.Player1)) {
						if (board.getPiece(i + 2, j) != Piece.Empty) {
							break;
						}
						return List.of(i + 2, j);
					}
					if (i == 0 && j == 2 && board.getPiece(i, j).equals(Piece.Player1)) {
						return List.of(i + 2, j - 2);
					}
					if (i == 1 && j == 0 && board.getPiece(i, j).equals(Piece.Player1)) {
						return List.of(i, j + 2);
					}
					if (i == 1 && j == 2 && board.getPiece(i, j).equals(Piece.Player1)) {
						return List.of(i, j - 2);
					}
					if (i == 2 && j == 0 && board.getPiece(i, j).equals(Piece.Player1)) {
						return List.of(i - 2, j + 2);
					}
					if (i == 2 && j == 1 && board.getPiece(i, j).equals(Piece.Player1)) {
						return List.of(i - 2, j);
					}
					if (i == 2 && j == 2 && board.getPiece(i, j).equals(Piece.Player1)) {
						if (board.getPiece(i - 2, j - 2).equals(Piece.Player2)) {
							return List.of(i, j - 2);
						}
						return List.of(i - 2, j - 2);
					}
				}
			}
		}
		
		// otherwise, return any empty spot
		for (int i = 0; i < 3; i++) {
			System.out.println("otherwise called");
			for (int j = 0; j < 3; j++) {
				if (board.getPiece(i, j).equals(Piece.Empty)) {
					return List.of(i, j);
				}
			}
		}
		return null;
	}
}
