package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class Board extends Component {
    private final Color COLOR_CHOSEN = Color.RED;
    private final Color COLOR_MOVABLE = new Color(0x00CCFF);
    private final Color COLOR_TILE_1 = new Color(0x759555);
    private final Color COLOR_TILE_2 = new Color(0xECECD0);
    private final int ROWS = 8, COLUMNS = 8;

    private JPanel board;
    private Tile[][] tiles;
    private Tile activeTile;

    public Board() {
        tiles = new Tile[ROWS][COLUMNS];
        board = new JPanel(new GridLayout(ROWS, COLUMNS));
        setup();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {

                Tile tile = new Tile(i, j);
                tile.setOpaque(true);

                if ((i + j) % 2 == 0) tile.setColor(COLOR_TILE_1);
                else tile.setColor(COLOR_TILE_2);

                if (Figure.find(i, j) != null) tile.setFigure(Figure.find(i, j));

                tile.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        Tile tilePressed = (Tile) e.getComponent();
                        Figure tileFigure = tilePressed.getFigure();

                        if (activeTile != null) {
                            activeTile.resetBackground();
                            Figure activeFigure = activeTile.getFigure();
                            Color back = tilePressed.getBackground();

                            for (Point p : activeFigure.moves()) tiles[p.x][p.y].resetBackground();

                            if (Objects.equals(back, COLOR_MOVABLE)) {

                                if (tileFigure != null) tileFigure.kill();

                                tilePressed.setFigure(activeFigure.move(tilePressed.getRow(), tilePressed.getCol()));
                                activeTile.setFigure(null);
                                activeTile = null;
                            } else if (tileFigure != null) newActive(tilePressed);
                            else activeTile = null;

                        } else if (tileFigure != null) newActive(tilePressed);
                    }

                    public void newActive(Tile tilePressed) {
                        activeTile = tilePressed;
                        tilePressed.setBackground(COLOR_CHOSEN);

                        for (Point p : tilePressed.getFigure().moves()) tiles[p.x][p.y].setBackground(COLOR_MOVABLE);
                    }
                });

                tiles[i][j] = tile;
                board.add(tile, i, j);
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

    public void setup() {
        for (int i = 0; i < 8; i++) {
            new Pawn(true, 1, i);
            new Pawn(false, 6, i);
        }

        new Rook(true, 0, 7);
        new Rook(true, 0, 0);
        new Rook(false, 7, 0);
        new Rook(false, 7, 7);

        new Knight(false, 7, 1);
        new Knight(false, 7, 6);
        new Knight(true, 0, 1);
        new Knight(true, 0, 6);

        new Bishop(false, 7, 2);
        new Bishop(false, 7, 5);
        new Bishop(true, 0, 2);
        new Bishop(true, 0, 5);

        new Queen(false, 7, 3);
        new Queen(true, 0, 3);

        new King(true, 0, 4);
        new King(false, 7, 4);
    }
}
