/**
 * TikTacToe creates a board and gameboard and runs the game of Tik-Tac-Toe.
 */
public class TicTacToe {
    public static void main(String[] args){
        Board b = new Board();
        Game g = new Game(b); g.gameLoop();
    }
}

