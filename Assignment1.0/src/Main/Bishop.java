package Main;

public class Bishop extends Piece{
    public Bishop(int color, Position position, Board board){
         /* Piece is the super class
         * use the constructor of the super class
         */
        super(color, position, board);
    }

    /**
     * Returns the integer that indicate valid or not
     * A bishop moves any number of vacant squares in any diagonal direction.
     * @param  i    new row
     * @param  j    new col
     * @return      1:  will eat the opponent's piece
     *              0:  is valid
     *              -1: out of bound
     *              -2: did not move
     *              -3: blocked by same/other color piece
     *              -4: invalid moving range
     */
    public int judgeMove(int i, int j){
        /* row+1, col-1     row+1, col      row+1, col+1
        *  row, col-1       row, col        row, col+1
        *  row-1, col-1     row-1, col      row-1, col+1
        */
        if (i<0 || j<0 ||i>7 ||j>7)
            return -1;

        if (this.getRow()==i && this.getCol()==j)
            return -2;

        if (Math.abs(this.getRow() - i) != Math.abs(this.getCol()- j))
            // not moving diagonally
            return -4;

        if (this.getBoard().chessPieces[i][j]!= null) {
            if (this.getBoard().chessPieces[i][j].getColor() == this.getColor()) {
                System.out.println("same color-piece in destination - check--1");
                return -3;
            }
        }

        int step_row = (i - this.getRow()) > 0? 1: -1;
        int step_col = (j - this.getCol()) > 0? 1: -1;
        for (int r = this.getRow()+step_row, c = this.getCol()+step_col; r!=i; r+=step_row, c+=step_col){
            if (this.getBoard().chessPieces[r][c]!=null) {
                System.out.println("r,c = "+r+" "+c);
                return -3;
            }
        }

        if (this.getBoard().chessPieces[i][j]!= null) {
            if (this.getBoard().chessPieces[i][j].getColor() != this.getColor()) {
                System.out.println("same color-piece in destination - check--2");
                return 1;
            }
        }
        return 0;
    }



}
