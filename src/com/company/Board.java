package com.company;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Objects;

public class Board extends Component{
    private JPanel board;
    private int rows, cols;
    private Figure[] figures; //@todo mozna przeniesc sie z figures[] w 100% na tiles[][] i usunac
    private Tile tiles[][];
    private boolean isActive;
    private Tile activeTile;
    public Board(){
        tiles=new Tile[8][8];
        setup();
        isActive = false;
        rows = 8;
        cols = 8;
        board = new JPanel(new GridLayout(rows, cols));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Tile label = new Tile(i, j);
                label.setOpaque(true);
                if ((i + j) % 2 == 0) {
                    label.setColor(new Color(0x759555));
                } else {
                    label.setColor(new Color(0xECECD0));
                }
                if(Figure.find(i,j, figures)!=null) label.setFigure(Figure.find(i, j, figures));
                /*label.addComponentListener(new ComponentListener() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        Figure tmp = Figure.find(label.getX()/100, label.getY()/100, figures);
                        System.out.println(label.getX()/100 +" "+label.getY()/100);
                        if (tmp != null) {
                            System.out.println("did");
                            label.setIcon(new ImageIcon(tmp.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_FAST)));
                        }
                    }

                    @Override
                    public void componentMoved(ComponentEvent e) {

                    }

                    @Override
                    public void componentShown(ComponentEvent e) {

                    }

                    @Override
                    public void componentHidden(ComponentEvent e) {

                    }
                });*/
                tiles[i][j]=label;
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        Tile tmp = (Tile)e.getComponent();
                        int i = tmp.getRow();
                        int j = tmp.getCol();
                        System.out.println(i +" "+ j);
                        if(isActive){
                            isActive=!isActive;
                            activeTile.setBackground(activeTile.getColor());
                            ArrayList<Point> moves = activeTile.getFigure().moves(figures);
                            if(Objects.equals(tmp.getBackground(), new Color(0x00CCFF))){
                                if(tmp.getFigure()!=null){
                                    tmp.getFigure().setAlive(false);
                                }
                                tmp.setFigure(activeTile.getFigure().move(i,j));
                                activeTile.setFigure(null);
                            }
                            for (Point p:moves) {
                                tiles[p.x][p.y].setBackground(tiles[p.x][p.y].getColor());
                            }

                        }else {
                            if (tmp.getFigure() != null) {
                                activeTile = tmp;
                                tmp.setBackground(Color.red);
                                ArrayList<Point> moves = tmp.getFigure().moves(figures);
                                for (Point p : moves) {
                                    tiles[p.x][p.y].setBackground(new Color(0x00CCFF));
                                }
                                isActive=!isActive;
                            }
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
    public void setup(){
        figures = new Figure[32];
        int index =0;
        for (int i = 0; i <8; i++) {
            figures[index++] = new Pawn(true, 1, i);
        }
        for (int i = 0; i <8; i++) {
            figures[index++] = new Pawn(false, 6, i);
        }
        figures[index++]= new Rook(true,0,7);
        figures[index++]= new Rook(true,0,0);
        figures[index++]= new Rook(false,7,0);
        figures[index++]= new Rook(false, 7,7);

        figures[index++]= new Knight(false, 7,1);
        figures[index++]= new Knight(false, 7,6);
        figures[index++]= new Knight(true, 0,1);
        figures[index++]= new Knight(true, 0,6);


        figures[index++]= new Bishop(false, 7,2);
        figures[index++]= new Bishop(false, 7, 5);
        figures[index++]= new Bishop(true, 0,2);
        figures[index++]= new Bishop(true, 0,5);


        figures[index++]= new Queen(false, 7,3);
        figures[index++]= new King(false, 7, 4);
        figures[index++]= new Queen(true, 0,3);
        figures[index++]= new King(true, 0,4);




    }
}
