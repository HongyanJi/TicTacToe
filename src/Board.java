/*
 * This is the declaration of the Board class which represents the board used to play the TicTacToe game
 */
public class Board {
    /*
     * This is a public static final integer data member of Board class, this represents how many rows
     * the Board has.
     */
    public static final int ROW = 3;
    /*
     * This is a public static final integer data member of the Board class, it represents how many columns
     * the Game Board has.
     */
    public static final int COL = 3;

    /*
     * This is a public static integer 2D array called the board which is the game board itself.
     */
    public static int[][] board = new int[ROW][COL];
    public static boolean checkMove(int row, int column){
        if(row >= 0 && row < ROW && column >= 0 && column < COL && board[row][column] == 0){
            return true;
        }else{
            return false;
        }
    }

    /*
     * This is a public static void method used to print the current game board with players' moves
     * on it.
     */
    public static void printBoard(){
        for (int i = 0; i < ROW; ++i) {
            for (int j = 0; j < COL; ++j) {
                switch (board[i][j]) {
                    case 0:  System.out.print("   "); break;
                    case 2: System.out.print(" O "); break;
                    case 1:  System.out.print(" X "); break;
                }
                if (j != COL - 1) {
                    System.out.print("|");   // print vertical partition
                }
            }
            System.out.println();
            if (i != ROW - 1) {
                System.out.println("-----------"); // print horizontal partition
            }
        }
        System.out.println();
    }
}
