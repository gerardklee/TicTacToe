package main;

public class Main {
	public static void main(String[] args) {
		TicTacToe gun = new TicTacToe();
		gun.insertLetter(1, 0, 'O');
		System.out.println(gun);
		gun.Winner();
		gun.loseGame();
	}
}
