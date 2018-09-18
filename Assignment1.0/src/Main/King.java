package Main;

public class King extends Piece{

    public King(int color, Position position, Board board){
        /* Piece is the super class
         * use the constructor of the super class
         */
        super(color, position, board);
    }

    /**
     * Returns the integer that indicate valid or not
     * King can move exactly one square horizontally, vertically, or diagonally.
     * At most once in every game, each king is allowed to make a special move, known as castling.
     * @param  i    new row
     * @param  j    new col
     * @return      1:  will eat the opponent's piece
     *              0:  is valid
     *              -1: out of bound
     *              -2: did not move
     *              -3: blocked by same color piece
     *              -4: invalid moving range
     */
    public int judgeMove(int i, int j){
        if (i<0 || j<0 || i>7 || j>7)
            return -1;

        if (this.getRow() == i && this.getCol()==j)
            return -2;

        if (Math.abs(this.getRow()-i) > 1  || Math.abs(this.getCol()-j) > 1)
            return -4;

        if (this.getBoard().chessPieces[i][j]==null)
            return 0;


        if (this.getBoard().chessPieces[i][j].getColor() == this.getColor()) {
            return -3;
        }
        else
            return 1;

        // valid and nothing happened
    }

}