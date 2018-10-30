package com.oreillyauto.w0502;

/**
 * ChessPiece abbreviations should be one of the following:
 *   BR - Black Rook        WR - White Rook
 *   BN - Black Knight      WN - White Knight
 *   BB - Black Bishop      WB - White Bishop
 *   BK - Black King        WK - White King
 *   BQ - Black Queen       WQ - White Queen
 *   BP - Black Pawn        WP - White Pawn
 * @author jbrannon5
 */
public class ChessPiece {

    public final static String COLOR_BLACK = "B";
    public final static String COLOR_WHITE = "W";
    public final static String TYPE_KING = "K";
    public final static String TYPE_QUEEN = "Q";
    public final static String TYPE_BISHOP = "B";
    public final static String TYPE_KNIGHT = "N";
    public final static String TYPE_ROOK = "R";
    public final static String TYPE_PAWN = "P";   
    
    private String type = "";
    private String color = "";
    
    public ChessPiece() {
    }

    public ChessPiece(String type, String color) {
        this.type = type;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAbbreviation() {
        return this.color + this.type;
    }

    @Override
    public String toString() {
        return this.color + this.type;
    }   
    
    
}

