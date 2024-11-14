public class King extends ChessPiece {

    public boolean hadMoving = false;

    public King(String color) {

        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line < 0 || line > 7 || column < 0 || column > 7 || toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7)
            return false;

        int diffX = Math.abs(toLine - line);
        int diffY = Math.abs(toColumn - column);

        if (diffX <= 1 && diffY <= 1) {
            hadMoving = true;
        }

        return (diffX <= 1 && diffY <= 1);
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.board[i][j] != null && !board.board[i][j].getColor().equals(this.color)) {
                    if (board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}