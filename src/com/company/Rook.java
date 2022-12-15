package com.company;

public class Rook extends Figure{
    public Rook(boolean team, int x, int y) {
        super(team, x, y);
        name = "Rook";
    }
    @Override
    public boolean valid(int x2, int y2, Figure[] figures) {
        Figure figure = Figure.find(x2, y2, figures);
        int x3 = x2-x;
        int y3 = y2-y;
        if(x3!=0 && y3!=0)return false;
        if(isBetween(x,y,x2,y2,figures))return false;
        if(figure!=null && figure.getTeam()==team)return false;
        return true;
    }
}
