package main;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe {
	char [][] board = new char[3][3];
	public TicTacToe() {
		// initializing board
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				board[i][j] = '_';
			}
		}
	}
	@Override // tells the compiler you intend to override. 
	public String toString() {
		String board = "";
		board += "  " + "1" + " " + "2" + " " + "3";
		for(int i=0; i<3; i++) {
			board += "\n";
			board += i+1 + " ";
			for(int j=0; j<3; j++) {
				board += this.board[i][j] + " ";
			}
		}
		return board;
	}
	
	public boolean insertLetter(int x, int y, char piece) {
		// insert 'O' or 'X' accordingly
		if(piece != 'O' && piece != 'X') {
			return false;
		}
		if(board[x][y] != '_') {
			return false;
		}
		board[x][y] = piece;
		return true;
	}
	public boolean allSame(List<Character> input) {
		char firstChar = input.get(0);
		for (char c : input) {
			if(firstChar != c) {
				return false;
			}
		}
		return true;
	}
	public char	Winner() {
		// checking row
		for (int i=0; i<3; i++) {
			List<Character> input = new ArrayList<>();
			for (int j=0; j<3; j++) {
				input.add(board[i][j]);
			}
			if (allSame(input) && input.get(0)!='_') {
				return input.get(0);
			}
		}

		// checking column
		for (int i=0; i<3; i++) {
			List<Character> input = new ArrayList<>();
			for (int j=0; j<3; j++) {
				input.add(board[j][i]);
			}
			if (allSame(input) && input.get(0)!='_') {
				return input.get(0);
			}
		}
		

		// checking diagonal
		for (int i=0; i<3; i++) {
			List<Character> input = new ArrayList<>();
			for (int j=0; j<3; j++) {
				input.add(0, board[0][0]);
				input.add(1, board[1][1]);
				input.add(2, board[2][2]);
			}
			if (allSame(input) && input.get(0) != '_') {
				return input.get(0);
			}
		}		
		return 'F'; // F for fail
	}
	
	public void Loser() {
		if (Winner() == 'F') {
			System.out.println("You lost the game");
		}
	}
	
	public void printValue() {
		System.out.println(board[0][0]);
	}
}
