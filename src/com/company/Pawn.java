package com.company;

public class Pawn extends Figure{
    public Pawn(boolean team, int x, int y) {
        super(team, x, y);
        name = "Pawn";
    }

    @Override
    public boolean valid(int x2, int y2, Figure[] figures) {
        if(y!=y2)return false;
        if(team){
            if(Figure.find(x+1, y, figures)!=null)return false;
            return x2-x==1;
        }else{
            if(Figure.find(x-1, y, figures)!=null)return false;
            return x-x2==1;
        }
    }
}
