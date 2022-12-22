package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Figure {
    protected static ArrayList<Figure> figures = new ArrayList<>();

    protected boolean team; // white = true;
    protected boolean alive;
    protected boolean moved;
    protected String name;
    protected int x;
    protected int y;
    protected int value;

    public Figure(boolean team, int x, int y) {
        this.team = team;
        if(!Board.team)this.team=!team;
        this.x = x;
        this.y = y;
        alive = true;
        moved = false;
        figures.add(this);
    }

    public Figure move(int xMove, int yMove) {
        moved = true;
        x = xMove;
        y = yMove;
        return this;
    }

    public static Figure find(int xFind, int yFind) {
        for (Figure value : figures)
            if (value != null && value.getX() == xFind && value.getY() == yFind && value.isAlive())
                return value;
        return null;
    }

    public ArrayList<Point> moves() {
        ArrayList<Point> ans = new ArrayList<>();
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if (isValid(i, j)) ans.add(new Point(i, j));

        return ans;
    }

    public void kill() {
        Main.update(value, team);
        alive = false;
    }

    public static boolean isBetween(int xStart, int yStart, int xStop, int yStop) {
        if (xStart != xStop) xStart += xStart < xStop ? 1 : -1;
        if (yStart != yStop) yStart += yStart < yStop ? 1 : -1;

        while (xStart != xStop || yStart != yStop) {
            if (find(xStart, yStart) != null) return true;
            if (xStart != xStop) xStart += xStart < xStop ? 1 : -1;
            if (yStart != yStop) yStart += yStart < yStop ? 1 : -1;
        }
        return false;
    }

    public boolean isValid(int xMove, int yMove) {
        return true;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setTeam(boolean team) {
        this.team = team;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Image getImage() {
        try {
            return ImageIO.read(new File("pieces/" + name + (getTeam() ? "W" : "B") + ".png")).getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean getTeam() {
        return team;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }
}