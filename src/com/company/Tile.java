package com.company;

import javax.swing.*;

public class Tile extends JLabel {
    private int row, col;
    private Figure figure;

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

}
