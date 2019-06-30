package main;

import java.util.ArrayList;
import java.util.List;

/**
 * A TicTacToe board.
 */
public class TicTacToe {
	// The internal representation of the board.
	private final Piece[][] board = new Piece[3][3];

	/**
	 * Creates an empty TicTacToe board.
	 */
	public TicTacToe() {
		// Initialize all board indices to the empty piece.
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = Piece.Empty;
			}
		}
	}

	// TODO: create copy constructor
	public TicTacToe(TicTacToe b) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = b.board[i][j];
			}
		}
	}

	@Override // tells the compiler you intend to override.
	public String toString() {
		String boardString = "";
		boardString += "  " + "1" + " " + "2" + " " + "3";

		for (int i = 0; i < 3; i++) {
			boardString += "\n";
			boardString += i + 1 + " ";
			for (int j = 0; j < 3; j++) {
				boardString += board[i][j] + " ";
			}
		}

		return boardString;
	}
	
	
	public void clearPiece(final int i, final int j) {
		board[i][j] = Piece.Empty;
	}
	/**
	 * Sets a piece on the board.
	 * 
	 * @param i the row of the piece
	 * @param j the column of the piece
	 * @param piece the piece to insert
	 * @return whether the piece was successfully inserted
	 */
	public boolean setPiece(final int i, final int j, final Piece piece) {
		// If the location is out of bounds, return false.
		if (!(0 <= i && i < 3 && 0 <= j && j < 3)) {
			return false;
		}

		// If the location already contains a non-empty piece, return false.
		if (board[i][j] != Piece.Empty) {
			return false;
		}

		// Set the piece.
		board[i][j] = piece;
		return true;
	}

	/**
	 * get a piece on the board
	 * 
	 * @param i as row
	 * @param j as column
	 * @return the piece at that location
	 */
	public Piece getPiece(final int i, final int j) {
		return board[i][j];
	}

	// TODO: make findFirstEmpty method

	// TODO: document this method (DONE)
	/**
	 * 
	 * @param input List with two possible piece ('O' or 'X') to be examined. The list contains three values.
	 * @return true if three values in the list are the same. It returns false otherwise.
	 */
	private static boolean allSame(final List<Piece> input) {
		Piece firstChar = input.get(0);

		for (Piece c : input) {
			if (firstChar != c) {
				return false;
			}
		}
		return true;
	}

	// TODO: document this method (DONE)
	// TODO: find a better name for this method (DONE)
	/**
	 * 
	 * @return the player's unique piece ('O' or 'X') if victory is determined. If victory is
	 *         not determined, this method returns character '_' to indicate no one has won
	 *         the game. 
	 */
	public Piece checkForWin() {
		// checking row
		for (int i = 0; i < 3; i++) {
			List<Piece> input = new ArrayList<>();
			for (int j = 0; j < 3; j++) {
				input.add(board[i][j]);
			}
			if (allSame(input) && input.get(0) != Piece.Empty) {
				return input.get(0);
			}
		}

		// checking column
		for (int i = 0; i < 3; i++) {
			List<Piece> input = new ArrayList<>();
			for (int j = 0; j < 3; j++) {
				input.add(board[j][i]);
			}
			if (allSame(input) && input.get(0) != Piece.Empty) {
				return input.get(0);
			}
		}

		// checking main diagonal
		List<Piece> mainDiagonal = new ArrayList<>();
		mainDiagonal.add(board[0][0]);
		mainDiagonal.add(board[1][1]);
		mainDiagonal.add(board[2][2]);
		if (allSame(mainDiagonal) && mainDiagonal.get(0) != Piece.Empty) {
			return mainDiagonal.get(0);
		}

		// TODO: check for off diagonal (DONE)
		// checking off diagonal
		List<Piece> offDiagonal = new ArrayList<>();
		offDiagonal.add(board[0][2]);
		offDiagonal.add(board[1][1]);
		offDiagonal.add(board[2][0]);
		if(allSame(offDiagonal) && offDiagonal.get(0) != Piece.Empty) {
			return offDiagonal.get(0);
		}

		// Return empty piece to indicate that no one has won yet.
		return Piece.Empty;
	}

	// TODO: determine what this method should do
	public void checkForLose() {
		if (checkForWin() == Piece.Empty) {
			System.out.println("You lost the game");
		}
	}
	
	/**
	 * 
	 * @return true if the board is full. It returns false if the board is empty.
	 */
	public boolean isFull() {
		//checking if the board is full
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (board[i][j] == Piece.Empty) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param x value for indicating row
	 * @param y value for indicating column
	 * @return true if the specific location of the board is empty. It returns false otherwise.
	 */
	public boolean checkForSetPiece(int x, int y) {
		//checking if the location of the board is empty
		if(board[x][y] == Piece.Empty) {
			return true;
		}
		return false;
	}
	
	public void printValue() {
		System.out.println(board[0][0]);
	}
}
