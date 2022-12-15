package com.company;

public class Queen extends Figure{
    public Queen(boolean team, int x, int y) {
        super(team, x, y);
        name = "Queen";
    }
    @Override
    public boolean valid(int x2, int y2, Figure[] figures) {
        Figure figure = Figure.find(x2, y2, figures);
        if(figure!=null && figure.getTeam()==team)return false;

        int x3 = x<x2?x2 - x:x-x2;
        int y3 = y<y2?y2 - y:y-y2;
        if(x3==y3) {
            return !isBetween(x, y, x2, y2, figures);
        }else{
            x3 = x2 - x;
            y3 = y2 - y;
            if(x3!=0 && y3!=0) return false;
            else{
                return !isBetween(x, y, x2, y2, figures);
            }
        }
    }
}
