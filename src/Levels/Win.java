package Levels;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import Objects.*;
import LogicClasses.*;

public class Win{
    PApplet p;
    private boolean reloadable;
    private int rot = 0;
    PImage loadImg;

    public Win(PApplet p) {
        this.p = p;
        setup();
    }

    public void setup() {
        loadImg = p.loadImage("LoadPng.png");
    }

    public void showWinScreen(PApplet p, GameManager g) {
        

        p.rectMode(PConstants.CORNERS);

        


        int buttonW = 200;
        int buttonH = 80;
        Button restartButton = new Button(p.width / 2 - buttonW / 2, p.height - 25 - buttonH, buttonW, buttonH);
        if (reloadable) {
            p.fill(0);
            p.textAlign(PConstants.CENTER, PConstants.TOP);
            p.textSize(100);
            p.text("Sorry we could not load the page.", p.width / 2, 100);
            p.textSize(70);
            p.text("Please try again.", p.width / 2, 200);


            p.rectMode(PConstants.CORNER);
            p.fill(112, 208, 184);
            p.rect(p.width / 2 - buttonW / 2, p.height - 25 - buttonH, buttonW, buttonH);
            p.textAlign(PConstants.CENTER, PConstants.CENTER);
            p.textSize(40);
            p.fill(0);
            p.text("Reload", p.width / 2, restartButton.getY() + restartButton.getH() / 2);
        } else {
            p.fill(0);
            p.textAlign(PConstants.CENTER, PConstants.TOP);
            p.textSize(100);
            p.text("You are not a robot.", p.width / 2, 100);
            p.textSize(70);
            p.text("Please wait while the page opens.", p.width / 2, 200);
        }
        

        reloadable = false;
        if (rot == 0) {
            p.imageMode(PConstants.CENTER);
            p.image(loadImg, p.width / 2, p.height / 2, 200, 200);
            rot++;
        } else if (rot < 2160) {
            p.imageMode(PConstants.CENTER);
            p.pushMatrix();
            p.translate(p.width / 2, p.height / 2);
            p.rotate(PApplet.radians(rot));
            p.image(loadImg, 0, 0, 200, 200);
            p.rotate(0);
            p.popMatrix();
            p.imageMode(PConstants.CORNER);
            rot += 12;
        } else {
            reloadable = true;
        }


        if (restartButton.contains(p.mouseX, p.mouseY) && MH.LEFT == MH.CLICKED && reloadable) {
            reloadable = false;
            g.isCorrect = false;
            g.failed = false;
            g.currentLevel = 1;
            g.newLevel = true;
            g.win = false;
            g.setup();
            
        }
    }
}
