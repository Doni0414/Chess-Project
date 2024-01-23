package org.chessapp.piece;

public enum PieceCode {
    BLACK_PAWN('\u265F'), BLACK_KNIGHT('\u265E'), BLACK_BISHOP('\u265D'), BLACK_ROOK('\u265C'), BLACK_QUEEN('\u265B'), BLACK_KING('\u265A'),
    WHITE_PAWN('\u2659'), WHITE_KNIGHT('\u2658'), WHITE_BISHOP('\u2657'), WHITE_ROOK('\u2656'), WHITE_QUEEN('\u2655'), WHITE_KING('\u2654');

    private char code;

    PieceCode(char code) {
        this.code = code;
    }
    public char getCode(){
        return code;
    }
}
