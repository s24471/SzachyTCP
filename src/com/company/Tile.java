package com.company;

import javax.swing.*;
import java.awt.*;

public class Tile extends JLabel {
    private int row, col;
    private Figure figure;
    private Color color;

    public Tile(int row, int col) {
        this.col = col;
        this.row = row;
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public Figure getFigure() {
        return figure;
    }
    public void setFigure(Figure figure) {
        this.figure = figure;
        if(figure!=null)this.setIcon(new ImageIcon(figure.getImage()));
        else this.setIcon(null);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        this.setBackground(color);
    }
}
