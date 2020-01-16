/*
 * Hongyan Ji's Homework assignment
 */

/*
 * This is the ComputerPlayer class used to generate ComputerPlayer objects to
 * represents a computer player. This class inherited from an abstract class Player.
 */
public class ComputerPlayer extends Player {
    /*
     * This is the constructor of the ComputerPlayer class,
     * which calls the constructor of its super class: Player to
     * initialize data member playerName.
     */
    public ComputerPlayer(){
        super("Computer");
    }

    /*
     * This method overrides the makeMove method in the super class Player, this method make a move on
     * the game board for the computer player automatically.
     */
    @Override
    public void makeMove(){
        for (int row = 0; row < Board.ROW; ++row) {
            for (int col = 0; col < Board.COL; ++col) {
                if(Board.board[row][col] == 0){
                    Game.moveCoodX = row;
                    Game.moveCoodY = col;
                }
            }
        }
    }
}
