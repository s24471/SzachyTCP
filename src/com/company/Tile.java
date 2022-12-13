package com.company;

import javax.swing.*;

public class Tile extends JLabel {
    private int row, col;
    private boolean active;
    private Figure figure;

    public Tile(int row, int col) {
        this.col = col;
        this.row = row;
        active = false;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }
}
