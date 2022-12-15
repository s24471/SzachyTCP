package com.company;

public class Rook extends Figure {
    public Rook(boolean team, int x, int y) {
        super(team, x, y);
        name = "Rook";
    }

    @Override
    public boolean isValid(int xMove, int yMove) {
        Figure figure = Figure.find(xMove, yMove);
        if (figure != null && figure.getTeam() == team) return false;

        int x3 = xMove - x;
        int y3 = yMove - y;

        if (x3 != 0 && y3 != 0) return false;
        return !isBetween(x, y, xMove, yMove);
    }
}
