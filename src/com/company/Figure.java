package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Figure {
    protected static BufferedImage image;
    protected boolean team; // white = true;
    protected boolean alive;
    protected int x;
    protected int y;
    protected String name;
    protected boolean moved;
    public Figure(boolean team, int x, int y) {
        this.team = team;
        this.x = x;
        this.y = y;
        alive = true;
        moved = false;
    }

    public Image getImage(){
        try {
            return ImageIO.read(new File("pieces/" + name + (getTeam()?"W":"B") + ".png")).getScaledInstance(100,100, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Figure move(int x2, int y2){
        moved=true;
        x=x2;
        y=y2;
        return this;
    }
    public boolean valid(int x2, int y2,  Figure[] figures){
        return true;
    }

    public boolean getTeam() {
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

    public static Figure find(int x, int y, Figure[] figure){
        for (Figure value : figure) {
            if (value!= null && value.getX() == x && value.getY() == y && value.isAlive()) return value;
        }
        return null;
    }
    public ArrayList<Point> moves(Figure[] figures){
        ArrayList<Point> ans = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(valid(i, j, figures)){
                    ans.add(new Point(i, j));
                }
            }
        }
        return ans;
    }
}