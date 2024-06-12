public enum ChessPieces {
    B_KING(-6),
    B_QUEEN(-5),
    B_BISHOP(-4),
    B_KNIGHT(-3),
    B_ROOK(-2),
    B_PAWN(-1),
    EMPTY(0),
    W_PAWN(1),
    W_ROOK(2),
    W_KNIGHT(3),
    W_BISHOP(4),
    W_QUEEN(5),
    W_KING(6);

    private final int value;

    ChessPieces(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
