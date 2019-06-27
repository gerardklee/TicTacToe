package main;

import java.util.ArrayList;
import java.util.List;

/**
 * A TicTacToe board.
 */
public class TicTacToe {
    // The internal representation of the board.
    final Piece[][] board = new Piece[3][3];

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
    
    // TODO: make getPiece method
    
    // TODO: make findFirstEmpty method 

    // TODO: make this method static
    // TODO: make this method private
    // TODO: document this method
    public boolean allSame(final List<Piece> input) {
        Piece firstChar = input.get(0);
        for (Piece c : input) {
            if (firstChar != c) {
                return false;
            }
        }
        return true;
    }

    // TODO: document this method
    // TODO: find a better name for this method
    public Piece Winner() {
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
        
        // TODO: check for off diagonal
        
        // Return empty piece to indicate that no one has won yet.
        return Piece.Empty; 
    }

    // TODO: determine what this method should do
    public void Loser() {
        if (Winner() == Piece.Empty) {
            System.out.println("You lost the game");
        }
    }

    public void printValue() {
        System.out.println(board[0][0]);
    }
}
