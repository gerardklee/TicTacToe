package main;

public class Main {
	public static void main(String[] args) {
		TicTacToe gun = new TicTacToe();
		gun.setPiece(1, 0, Piece.Player2);
		System.out.println(gun);
		gun.Winner();
		// gun.loseGame();
	}
}
