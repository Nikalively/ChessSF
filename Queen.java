class Queen extends ChessPiece {

    public Queen(String color) {
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

        int dx = toLine - line;
        int dy = toColumn - column;

        if (Math.abs(dx) == Math.abs(dy)) { // Диагональное движение
            int stepX = dx / Math.abs(dx);
            int stepY = dy / Math.abs(dy);

            for (int i = 1; i < Math.abs(dx); i++) {
                if (chessBoard.board[line + i * stepX][column + i * stepY] != null) {
                    return false;
                }
            }
        } else if (line == toLine || column == toColumn) { // Прямое движение
            int step = line == toLine ? (toColumn - column) / Math.abs(toColumn - column) : (toLine - line) / Math.abs(toLine - line);
            int start = line == toLine ? column : line;
            int end = line == toLine ? toColumn : toLine;

            for (int i = start + step; i != end; i += step) {
                if (line == toLine) {
                    if (chessBoard.board[line][i] != null) {
                        return false;
                    }
                } else {
                    if (chessBoard.board[i][column] != null) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }

        ChessPiece targetPiece = chessBoard.board[toLine][toColumn];
        return targetPiece == null || !targetPiece.getColor().equals(this.color);
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}