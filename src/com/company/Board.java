package com.company;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Board extends Component{
    private JPanel board;
    private int rows, cols;
    private Figure figures[];
    public Board(){
        setup();

        rows = 8;
        cols = 8;
        board = new JPanel(new GridLayout(rows, cols));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Tile label = new Tile(i, j);
                label.setOpaque(true);
                if ((i + j) % 2 == 0) {
                    label.setBackground(new Color(0x759555));
                } else {
                    label.setBackground(new Color(0xECECD0));
                }
                /*
                @TODO
                  proponuje zrobic metode set figure ktora od razu ustawia imageIcon figury jako ikone pola,
                  ale tez pozwala nam przechowywac obiekt figury
                 */
                if(Figure.find(i,j, figures)!=null)label.setIcon(new ImageIcon(Figure.find(i,j, figures).getImage())); /*label.addComponentListener(new ComponentListener() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        Figure tmp = Figure.find(label.getX()/100, label.getY()/100, figures);
                        System.out.println(label.getX()/100 +" "+label.getY()/100);
                        if (tmp != null) {
                            System.out.println("did");
                            label.setIcon(new ImageIcon(tmp.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_FAST)));//@TODO za wolne!!!
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
                board.add(label, i, j);

            }
        }
        board.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Tile tmp = (Tile) e.getComponent();
                int i = tmp.getRow();
                int j = tmp.getCol();
                //@TODO potrzebujemy mouseListenera dla dwoch klikniec: wybrania pionka, i wskazania gdzie ma isc (jak masz jakies pomysly to daj znac)
                if(tmp.isActive())
                    ;
                    /*
                    @TODO
                      przypisac figure do pola, zeby mozna bylo wyciagnac obiekt figury z kliknietego pola.
                      na tej podstawie sprawdzac mozliwosci ruchu i wyciagac ikone z figury zwroconej przez klikniete pole.
                     */
                else tmp.setActive(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
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
