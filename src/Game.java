
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private Board gameBoard;
    private char currentPlayer;
    // you may want other private members

    /**
     * This initializes the gameboard.
     */
    public Game(Board b) {
        this.gameBoard = b;
    }

    /**
     * getter that returns the character of the current player
     */
    public char getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * setter that sets the current player to the given input
     * @param player
     */
    public void setCurrentPlayer(char player){
        this.currentPlayer = player;
    }

    /**
     * Gameloops runs the entire game
     */
    public void gameLoop() {

        System.out.println("Welcome to the game of Tik-Tac-Toe.");
        Scanner scanny = new Scanner(System.in);
        int playermove;
        setCurrentPlayer('X');

        while (!gameBoard.hasWon(currentPlayer)) {

            System.out.println("Here is the current board.");
            gameBoard.PrintBoard();

            if (gameBoard.isFull()){
                System.out.println("The gameboard is full. The game is a tie and will end now.");
                break;
            }
            System.out.println("Player one, you are X. It is your turn. Your pick should be represented by an integer 1-9");

            try {
                playermove = scanny.nextInt();
                gameBoard.play(currentPlayer, playermove);
                }
            catch (Exception e) {
                System.out.println("Not a valid move.");
                scanny.nextLine();
            }



            if (gameBoard.hasWon(currentPlayer)){
                System.out.println(currentPlayer + " WINS.");
                break;
            }


            System.out.println("Here is the current board.");
            gameBoard.PrintBoard();

            setCurrentPlayer('O');
            if (gameBoard.isFull()){
                System.out.println("The gameboard is full, so its a tie. The game will end now.");
                break;}
            System.out.println("Player two, it is your turn. Your pick should be represented by an integer 1-9");

            try {
                playermove = scanny.nextInt();
                gameBoard.play(currentPlayer, playermove);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                scanny.nextLine();
            }

            if (gameBoard.hasWon(currentPlayer)){
                System.out.println(getCurrentPlayer() + " WINS.");
                break;
            }
            setCurrentPlayer('X');

            }


            }

        }



