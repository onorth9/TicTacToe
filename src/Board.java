import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * Represents the state of a board in a game of Tic-Tac-Toe
 */
public class Board {
    /**
     * The number of rows and columns in this square Tic-Tac-Toe board
     */
    private static final int SIZE = 3;
    /**
     * A 2D array representing the state of this Tic-Tac-Toe board
     */
    private char[][] currentBoard = new char[SIZE][SIZE];

    /**
     * Creates an empty Tic-Tac-Toe board
     */
    public Board() {
    for (int r = 0; r < currentBoard.length;r++){
        for (int c =0; c <currentBoard.length;c++){
            currentBoard[r][c] = '-';
        }
    }
    }

    /**
     * Prints out the tic-tac-toe board.
     */
    public void PrintBoard() {
        for (int r = 0; r < currentBoard.length; r++) {
            for (int c = 0; c < currentBoard.length; c++) {
                System.out.print(currentBoard[r][c]);
            }
            System.out.println();
        }
    }

    /**
     * Converts an integer board location into a column number in currentBoard.
     *
     * @param location an integer board position in range [1-9]
     * @return an integer column number in range [0-2]
     * @see Board#currentBoard
     */
    public int getColumn(int location) {
        return (location-1) % SIZE;
    }

    /**
     * Converts an integer board location into a row number in currentBoard.
     *
     * @param location an integer board position in range [1-9]
     * @return an integer row number in range [0-2]
     * @see Board#currentBoard
     */
    public int getRow(int location) {
        // Use integer division to truncate fractional part (column info)
        return (location-1) / SIZE;
    }

    /**
     * Add move to the board
     * @throws Exception if location is invalid or already full
     */
    public void play(char currentPlayer, int location) throws Exception {
        if (isFilled(getRow(location),getColumn(location))){
            throw new Exception("This is an invalid move because a move was already played in that spot.");
        }
        if (location < 1 || location > 9){
            throw new Exception("This is an invalid move. Make sure to pick and integer 1-9");

        }
        currentBoard[getRow(location)][getColumn(location)] = currentPlayer;


    }

    /**
     * @return true if the currentBoard already has an 'X' or an 'O' at
     * [row][column].
     */
    public boolean isFilled(int row, int col) {
        boolean check;
        if (currentBoard[row][col] == 'X' || currentBoard[row][col] == 'O'){
            check = true;
        }
        else{
            check = false;
        }
        return check;
    }

    /**
     * @return true if all of the spaces on the board are occupied
     */
    public boolean isFull(){
        boolean check;
        int count = 0;
        for (int i = 0; i < currentBoard.length; i++){
            for(int j =2; j > -1; j--) {
                if (currentBoard[i][j] == 'O' || currentBoard[i][j] == 'X') {
                    count++;
                }
            }
        }
        if (count == 9){
            check = true;
        }
        else{
            check = false;
        }
        return check;
    }

    /**
     * @return true if currentPlayer has won the game
     */
    public boolean hasWon(char currentPlayer) {
        boolean hasWon = false;
        int rowcount = 0;
        int colcount = 0;
        int diag1 = 0;
        int diag2 = 0;
        for (int c = 0; c < currentBoard.length; c++){
            for(int r =2; r > -1; r--) {
                if (currentBoard[r][c] == currentPlayer){
                    colcount++;
                }
                if (colcount == 3){
                    hasWon = true;
                }
            }
            colcount = 0;
        }
        for (int c = 0; c < currentBoard.length; c++){
            for(int r =2; r > -1; r--) {
                if (currentBoard[c][r] == currentPlayer){
                    rowcount++;
                }
                if (rowcount == 3){
                    hasWon = true;
                }
            }
            rowcount = 0;
        }
        for (int i = 0; i < currentBoard.length; i++){
            if (currentBoard[i][i] == currentPlayer){
                diag1++;
            }
            if (diag1 == 3){
                hasWon = true;
            }
        }
        for (int i = 0; i < currentBoard.length;i++){
            if (currentBoard[i][(SIZE-1)-i] == currentPlayer){
                diag2++;
            }
            if (diag2 == 3){
                hasWon = true;
            }
        }
        return hasWon;
    }
}
