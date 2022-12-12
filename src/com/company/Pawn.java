package com.company;


import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Pawn extends Figure{
    public Pawn(boolean team, int x, int y) {
        super(team, x, y);
        name = "Pawn";
    }
}
