package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Board extends Component{
/*
@TODO
wyswietlanie okna z plansza (done(kinda))


 */
    private JPanel board;
    private int rows, cols;
    public Board(){
        rows = 8;
        cols = 8;
        board = new JPanel(new GridLayout(rows, cols));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JLabel label = new JLabel();
                label.setOpaque(true);
                if ((i + j) % 2 == 0) {
                    label.setBackground(Color.BLACK);
                } else {
                    label.setBackground(Color.WHITE);
                }
                board.add(label, i, j);
            }
        }
    }
    public void createGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 800));
        frame.add(board, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
