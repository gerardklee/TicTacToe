package main;

/**
 * A piece on the board.
 */
public enum Piece {
    Empty('_'),
    Player1('X'),
    Player2('O');
    
    private final char character;
    
    Piece(final char character) {
        this.character = character;
    }
    
    @Override
    public String toString() {
        return String.valueOf(character);
    }
}
