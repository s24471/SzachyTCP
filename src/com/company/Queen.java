package com.company;

public class Queen extends Figure {
    public Queen(boolean team, int x, int y) {
        super(team, x, y);
        name = "Queen";
        value = 9;
    }

    @Override
    public boolean isValid(int xMove, int yMove) {
        Figure figure = Figure.find(xMove, yMove);
        if (figure != null && figure.getTeam() == team) return false;

        int xDiff = x < xMove ? xMove - x : x - xMove;
        int yDiff = y < yMove ? yMove - y : y - yMove;

        if (xDiff == yDiff) return !isBetween(x, y, xMove, yMove);
        xDiff = xMove - x;
        yDiff = yMove - y;
        if (xDiff != 0 && yDiff != 0) return false;
        return !isBetween(x, y, xMove, yMove);
    }
}
