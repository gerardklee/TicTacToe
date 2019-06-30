package main;

import java.util.List;

public class SimpleAI implements TicTacToeAI {

	@Override
	public List<Integer> bestMove(TicTacToe board, Piece piece) {
		// TODO Auto-generated method stub
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(board.getPiece(i, j)==Piece.Empty) {
					return List.of(i, j); // returning location of the board
				}
			}
		}
		return null;
	}

}
