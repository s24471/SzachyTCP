package com.company;

import java.net.Socket;

public class Main {
    public static int scoreW;
    public static int scoreB;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        scoreW = 0;
        scoreB = 0;
        Board board = new Board(true);
        board.createGUI();
        Socket socket = new Socket();
    }

    public static void update(int x, boolean team) {
        System.out.println("-"+x+" dla druzyny " + (team?"Bialej":"Czarnej"));
        if (team) {
            scoreW -= x;
        } else {
            scoreB -= x;
        }
        if(scoreW == scoreB) {
            System.out.println("Remis w punktach");
            return;
        }
        System.out.println("Wygyrwa " + (scoreW>scoreB?"bialy":"czarny")+ " " + (scoreW>scoreB?scoreW-scoreB:scoreB-scoreW )+" punktami");
    }
}
