package main;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		TicTacToe gun = new TicTacToe();
		//TicTacToeAI ai = new SimpleAI();
		TicTacToeAI bestai = new MiniMaxAI();
		Scanner myPiece = new Scanner(System.in);

		//List<Integer> bestMove = ai.bestMove(gun, Piece.Player2);		
		//gun.setPiece(bestMove.get(0), bestMove.get(1), Piece.Player2);
		System.out.println(gun);
		
		// turn for player 1 and player 2
		while (gun.checkForWin() == Piece.Empty && !gun.isFull()) {
			
			// enter stdin for user's piece
			System.out.println("Enter your piece: ");
			int x = myPiece.nextInt();
			int y = myPiece.nextInt();
			
			// re-enter if user input is out of range
			while(x>2 || y>2) {
				System.out.println("Exception occured");
				System.out.println("Re-enter: ");
				x = myPiece.nextInt();
				y = myPiece.nextInt();
			}
			
			// re-enter if the location is occupied
			while(!gun.checkForSetPiece(x, y)) {
				System.out.println("Location occupied");
				System.out.println("Re-enter: ");
				x = myPiece.nextInt();
				y = myPiece.nextInt();
			}
			
			// set piece for player 1 (myself)
			gun.setPiece(x, y, Piece.Player1);
			System.out.println("Player 1 set his piece");
			
			// set piece for AI
			List<Integer> bestMove = bestai.bestMove(gun, Piece.Player2);
			gun.setPiece(bestMove.get(0), bestMove.get(1), Piece.Player2);
			System.out.println("Player 2 set his piece");
			
			// visualize board
			if(!gun.isFull() || gun.checkForWin().equals(Piece.Empty)) {
				System.out.println(gun);
			}
		}
		myPiece.close();
		
		// final board
		System.out.println(gun);
		System.out.println("Game ended");
	}
}
