/*
 * This is the abstract class Player, both ComputerPlayer and HumanPlayer classes
 * inherited from it
 */
public abstract class Player {
    /*
     * computer players and human players will have different make move behaviors
     * yet they both have to have a make move method
     */
    public abstract void makeMove();

    /*
     * The getter for data member player name
     */
    public String getPlayerName() {
        return playerName;
    }

    /*
     * the setter for data member player name (not used in this program)
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /*
     * private String data member playerName to represents the player's name
     */
    private String playerName;

    /*
     * the constructor of this class to initialize private data member playerName
     */
    public Player(String playerName){
        this.playerName = playerName;
    }
}
