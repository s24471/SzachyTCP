package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Figure {
    private static BufferedImage image;
    private boolean team; // white = true;
    private boolean alive;
    private int x;
    private int y;
    protected String name;

    public Figure(boolean team, int x, int y) {
        this.team = team;
        this.x = x;
        this.y = y;
        alive = true;
    }

    public Image getImage(){
        try {
            return ImageIO.read(new File("pieces/" + name + (isTeam()?"W":"B") + ".png")).getScaledInstance(100,100, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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

    public static Figure find(int x, int y, Figure figure[]){
        for (int i = 0; i < figure.length; i++) {
            if(figure[i].getX() == x && figure[i].getY()==y);
                return figure[i];
        }
        return null;
    }
}
