package com.company;

public class Knight extends Figure {
    public Knight(boolean team, int x, int y) {
        super(team, x, y);
        name = "Knight";
    }

    @Override
    public boolean isValid(int xMove, int yMove) {
        Figure figure = Figure.find(xMove, yMove);
        if (figure != null && figure.getTeam() == team) return false;
        int xDiff = xMove - x;
        int yDiff = yMove - y;
        if ((xDiff == 2 || xDiff == -2) && (yDiff == -1 || yDiff == 1)) return true;
        else return (xDiff == 1 || xDiff == -1) && (yDiff == 2 || yDiff == -2);
    }
}
