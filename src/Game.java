/*
 * Hongyan Ji's Homework assignment
 */

import java.util.Scanner;

/*
 * This is the Game class which represents the TicTacToe game itself, when its constructor is called
 * the game will begin.
 */
public class Game {
    /*
     * Declare a new Player array which has a length of 2 to contain 2 players doesn't matter if they
     * are human players or computer players.
     */
    private static Player[] players = new Player[2];
    /*
     * Declare and initialize a new Scanner to take in user input
     */
    public static Scanner in = new Scanner(System.in);
    /*
     * Declare the public static integer data member moveCoodX to take in which row the player wants to
     * make his/her/its move.
     */
    public static int moveCoodX;
    /*
     * Declare the public static integer data member moveCoodX to take in which column the player wants to
     * make his/her/its move.
     */
    public static int moveCoodY;
    /*
     * Declare and initialize the private final integer player1Won, to determine whether that player1 has won
     * the game.
     */
    private final int player1Won = 1;
    /*
     * Declare and initialize the private final integer player2Won, to determine whether that player2 has won
     * the game.
     */
    private final int player2Won = 2;
    /*
     * Declare and initialize the private final integer draw, to determine whether that the game is draw.
     */
    private final int draw = 3;

    /*
     * Declare the private integer data member gameStatus to determine whether the game is over
     */
    private int gameStatus;

    /*
     * This is the constructor of Game class which calls the play method to play the game.
     */
    public Game(){
        play();
    }

    /*
     * This is private void play method which plays the game by first determine which player is human and which one
     * is computer, or both humans, or both computers. Then it sets the game board to empty to be ready for the new game
     * then it let both players to make their moves in turn until the game ends, which means either one of the player has
     * won the game or the game is draw.
     */
    private void play(){
        determinePlayers();
        clearBoard();
        gameStatus = 0;
        int i = 0;
        System.out.println();
        Board.printBoard();
        while(gameStatus == 0){
            if(i == 2){
                i = 0;
            }
            addPlayerMoveToBoard(players[i], i);
            checkGameStatus(i);
            i++;
        }
        if(gameStatus == draw){
            System.out.println("The game is draw.");
        }else{
            System.out.println("Player " + players[gameStatus -1].getPlayerName() + " has won the game!");
        }
    }

    /*
     * This is the private void determinePlayers method for determining each player is human or computer and store both
     * players in the Players array.
     */
    private void determinePlayers(){
        boolean validInput = false;
        int answer;
        String playerName;
        for(int i = 0; i < 2; i++){
            do{
                System.out.println("For player " + (i+1)  +", would you like to play manually? Choose the number 1 for yes and 2 for no");
                answer = in.nextInt();
                if(answer == 1){
                    validInput = true;
                    System.out.println("Please enter your player name");
                    in.nextLine();
                    playerName = in.nextLine();
                    players[i] = new HumanPlayer(playerName);
                }
                else if(answer == 2){
                    validInput = true;
                    players[i] = new ComputerPlayer();
                }
            }while(!validInput);
            validInput = false;
        }
        System.out.println("Player 1 uses 'X', Player 2 uses 'O'");
    }

    /*
     * This method clear the game board, restore it to empty state.
     */
    private void clearBoard(){
        for (int row = 0; row < Board.ROW; ++row) {
            for (int col = 0; col < Board.COL; ++col) {
                Board.board[row][col] = 0;
            }
        }
    }

    /*
     * This method let one of the players to make his/her/its move and add that move to the game board.
     */
    private void addPlayerMoveToBoard(Player currentPlayer, int playerNumber) {
        currentPlayer.makeMove();
        Board.board[moveCoodX][moveCoodY] = playerNumber + 1;
        Board.printBoard();
    }

    /*
     * This method checks whether the game has ended by calling winner method and then update the gameStatus.
     */
    private void checkGameStatus(int playerNumber){
        if(winner(playerNumber, moveCoodX, moveCoodY)){
            if(playerNumber == 0){
                gameStatus = player1Won;
            }
            else if(playerNumber == 1){
                gameStatus = player2Won;
            }
        }
        else if(isDraw()){
            gameStatus = draw;
        }
    }

    /*
     * This method checks if one of the player has won the game.
     */
    private static boolean winner(int playerNumber, int currentRow, int currentCol) {
        return (Board.board[currentRow][0] == (playerNumber + 1)         // 3-in-the-row
                && Board.board[currentRow][1] == (playerNumber + 1)
                && Board.board[currentRow][2] == (playerNumber + 1)
                || Board.board[0][currentCol] == (playerNumber + 1)      // 3-in-the-column
                && Board.board[1][currentCol] == (playerNumber + 1)
                && Board.board[2][currentCol] == (playerNumber + 1)
                || currentRow == currentCol            // 3-in-the-diagonal
                && Board.board[0][0] == (playerNumber + 1)
                && Board.board[1][1] == (playerNumber + 1)
                && Board.board[2][2] == (playerNumber + 1)
                || currentRow + currentCol == 2  // 3-in-the-opposite-diagonal
                && Board.board[0][2] == (playerNumber + 1)
                && Board.board[1][1] == (playerNumber + 1)
                && Board.board[2][0] == (playerNumber + 1));
    }

    /*
     * this method determines whether the game is draw by checking if there are any empty cell found in the
     */
    private static boolean isDraw() {
        for (int row = 0; row < Board.ROW; ++row) {
            for (int col = 0; col < Board.COL; ++col) {
                if (Board.board[row][col] == 0) {
                    return false;  // an empty cell found, not draw, exit
                }
            }
        }
        return true;  // no empty cell, it's a draw
    }
}
