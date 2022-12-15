package com.company;

public class Bishop extends Figure {
    public Bishop(boolean team, int x, int y) {
        super(team, x, y);
        name = "Bishop";
        value = 3;
    }

    public boolean isValid(int xMove, int yMove) {
        Figure figure = Figure.find(xMove, yMove);
        if (figure != null && figure.getTeam() == team) return false;

        int xDiff = x < xMove ? xMove - x : x - xMove;
        int yDiff = y < yMove ? yMove - y : y - yMove;

        if (xDiff != yDiff) return false;
        if (isBetween(x, y, xMove, yMove)) return false;
        return true;
    }
}
