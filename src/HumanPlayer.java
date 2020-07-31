/*
 * This is the HumanPlayer class used to generate HumanPlayer objects to
 * represents a human player. This class inherited from an abstract class Player.
 */
public class HumanPlayer extends Player {
    /*
     * This is the constructor of the HumanPlayer class,
     * which calls the constructor of its super class: Player to
     * initialize data member playerName.
     */
    public HumanPlayer(String playerName){
        super(playerName);
    }
    /*
     * This method overrides the makeMove method in the super class Player, this method let
     * the human player to make his/her move manually by letting him/her choose which row
     * and column the player wants to make a move.
     */
    @Override
    public void makeMove(){
        System.out.println("Player " + getPlayerName() + "'s turn");
        System.out.println("Which row would you like to play your next move? (1, 2 or 3)");
        Game.moveCoodX = Game.in.nextInt() - 1;
        System.out.println("Which column would you like to play your next move? (1, 2 or 3)");
        Game.moveCoodY = Game.in.nextInt() - 1;
        if(!Board.checkMove(Game.moveCoodX, Game.moveCoodY)){
            System.out.println("Invalid inputs, please re-enter");
            makeMove();
        }
    }
}
