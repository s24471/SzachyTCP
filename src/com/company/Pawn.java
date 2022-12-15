package com.company;

public class Pawn extends Figure{
    public Pawn(boolean team, int x, int y) {
        super(team, x, y);
        name = "Pawn";
    }

    @Override
    public boolean valid(int x2, int y2, Figure[] figures) {
        Figure figure = Figure.find(x2, y2, figures);
        int x3 = x2-x;
        int y3 = y2-y;
        if(y3==0 && figure==null && (x3==1||x3==2 && !moved && Figure.find(x2-1, y2, figures) == null)) return true;
        if(x3==1 && (y3==1 || y3==-1) && figure!=null && figure.getTeam()==team)return true;
        return false;
    }
}