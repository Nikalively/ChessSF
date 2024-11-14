class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) ||
                !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        if (line == toLine && column == toColumn) {
            return false;
        }

        int direction = color.equals("White") ? 1 : -1;
        int startRow = color.equals("White") ? 1 : 6;
        ChessPiece targetPiece = chessBoard.board[toLine][toColumn];

        if (Math.abs(column - toColumn) == 1 && line + direction == toLine) {
            return targetPiece != null && !targetPiece.getColor().equals(this.color);
        }

        if (column == toColumn) {
            if (line + direction == toLine && targetPiece == null) return true;
            if (line == startRow && line + 2 * direction == toLine && targetPiece == null &&
                    chessBoard.board[line + direction][column] == null) return true;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}