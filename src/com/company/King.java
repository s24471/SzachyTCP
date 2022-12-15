package com.company;

public class King extends Figure {
    public King(boolean team, int x, int y) {
        super(team, x, y);
        name = "King";
    }

    @Override
    public boolean isValid(int xMove, int yMove) {
        Figure figure = Figure.find(xMove, yMove);
        int xDiff = xMove - x;
        int yDiff = yMove - y;
        if (xDiff > 1 || xDiff < -1 || yDiff > 1 || yDiff < -1) return false;
        return figure == null || figure.getTeam() != team;
    }
}
