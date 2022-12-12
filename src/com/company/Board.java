package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Board extends Component{
    private JPanel board;
    private int rows, cols;
    private Figure figures[];
    public Board(){
        figures = new Figure[32];
        figures[0] = new Pawn(true, 0, 0);
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

                label.setIcon(new ImageIcon(figures[0].getImage()));
                label.addComponentListener(new ComponentAdapter() {
                    public void componentResized(ComponentEvent componentEvent) {
                        Figure tmp = Figure.find(label.getX(), label.getY(), figures);
                        if(tmp!=null){
                            label.setIcon(new ImageIcon(tmp.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH)));//@TODO za wolne!!!
                        }
                    }
                });
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
