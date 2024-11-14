public class Rook extends ChessPiece {

    public boolean hadMoving = false;

    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line < 0 || line > 7 || column < 0 || column > 7 || toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            return false;
        }

        if (!((line == toLine && column != toColumn) || (line != toLine && column == toColumn))) {
            return false;
        }

        if (chessBoard.isPathClear(line, column, toLine, toColumn)) {
            hadMoving = chessBoard.isPathClear(line, column, toLine, toColumn);
        }

        return chessBoard.isPathClear(line, column, toLine, toColumn);
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}