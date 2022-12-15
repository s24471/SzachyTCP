package com.company;

public class Pawn extends Figure {
    public Pawn(boolean team, int x, int y) {
        super(team, x, y);
        name = "Pawn";
    }

    @Override
    public boolean isValid(int xMove, int yMove) {
        Figure figure = Figure.find(xMove, yMove);
        int xDiff = xMove - x;
        int yDiff = yMove - y;
        if (xDiff <= 0) return false;
        if (yDiff == 0) {
            if (figure == null) {
                if (xDiff == 1) return true;
                if (xDiff == 2 && !moved && Figure.find(xMove - 1, yMove) == null) return true;
            }
        }
        if (yDiff == 1 || yDiff == -1) {
            if (figure == null || figure.getTeam() == team) return false;
            return xDiff == 1;
        }
        return false;
    }
}