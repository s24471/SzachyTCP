package com.company;

import java.awt.*;

public class Figure {
    private boolean team; // white = true;
    private boolean alive;
    private int x;
    private int y;

    public Figure(boolean team, int x, int y) {
        this.team = team;
        this.x = x;
        this.y = y;
        alive = true;
    }

    public Image getImage(){
        return  null;
    }

    public Figure move(int x2, int y2){
        return this;
    }
    public boolean valid(int x2, int y2){
        return true;
    }

    public boolean isTeam() {
        return team;
    }

    public void setTeam(boolean team) {
        this.team = team;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
