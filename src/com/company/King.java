package com.company;

public class King extends Figure{
    public King(boolean team, int x, int y) {
        super(team, x, y);
        name = "King";
    }

    @Override
    public boolean valid(int x2, int y2, Figure[] figures) {
        Figure figure = Figure.find(x2, y2, figures);
        int x3 = x2-x;
        int y3 = y2-y;
        if(x3>1 || x3<-1 || y3>1 || y3<-1)return false;
        return figure==null || figure.getTeam()!=team;
    }
}
