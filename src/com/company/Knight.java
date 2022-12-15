package com.company;

public class Knight extends Figure{
    public Knight(boolean team, int x, int y) {
        super(team, x, y);
        name = "Knight";
    }
    @Override
    public boolean valid(int x2, int y2, Figure[] figures) {
        Figure figure = Figure.find(x2, y2, figures);
        if(figure!=null && figure.getTeam()==team)return false;
        int x3 = x2 - x;
        int y3 = y2 - y;
        if((x3==2 || x3==-2) && (y3==-1 || y3==1))return true;
        else if((x3==1 || x3==-1) &&(y3==2 ||y3==-2))return true;
        return false;

    }
}
