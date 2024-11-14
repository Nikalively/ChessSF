abstract class ChessPiece {
    protected String color;
    protected boolean check;

    public ChessPiece(String color) {
        this.color = color;
        this.check = true;     //Если фигуры не двигались изначально
    }

    public String getColor() {
        return color;
    }

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();
}
