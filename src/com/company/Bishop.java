package com.company;

public class Bishop extends Figure{
    public Bishop(boolean team, int x, int y) {
        super(team, x, y);
        name = "Bishop";
    }
    public boolean valid(int x2, int y2, Figure[] figures) {
        Figure figure = Figure.find(x2, y2, figures);
        if(figure!=null && figure.getTeam()==team)return false;
        int x3 = x<x2?x2 - x:x-x2;
        int y3 = y<y2?y2 - y:y-y2;
        if(x3!=y3)return false;
        if(isBetween(x,y,x2,y2,figures))return false;
        return true;
    }
}
