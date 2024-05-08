package Levels;

import processing.core.PApplet;
import processing.core.PConstants;
import Objects.*;
import LogicClasses.*;

public class Loss {

    public Loss() {
        
    }

    public static void showLossScreen(PApplet p, int currLevel, GameManager g) {
        p.background(p.random(255), p.random(255), p.random(255));

        p.rectMode(PConstants.CORNERS);
        p.fill(255);
        int margin = 75;
        p.rect(margin, margin, p.width-margin, p.height-margin);

        p.fill(0);
        p.textAlign(PConstants.CENTER, PConstants.TOP);
        p.textSize(100);
        p.text("You are clearly a robot!", p.width / 2, margin + 50);
        p.textSize(50);
        p.text("You got to level " + currLevel, p.width / 2, margin + 300);
        p.textSize(70);
        p.text("Git Gut", p.width / 2, margin + 400);


        int buttonW = 200;
        int buttonH = 80;
        Button restartButton = new Button(p.width / 2 - buttonW / 2, p.height - margin - 50 - buttonH, buttonW, buttonH);
        p.rectMode(PConstants.CORNER);
        p.fill(112, 208, 184);
        p.rect(p.width / 2 - buttonW / 2, p.height - margin - 50 - buttonH, buttonW, buttonH);
        p.textAlign(PConstants.CENTER, PConstants.CENTER);
        p.textSize(40);
        p.fill(0);
        p.text("Restart", p.width / 2, restartButton.getY() + restartButton.getH() / 2);


        if (restartButton.contains(p.mouseX, p.mouseY) && MH.LEFT == MH.CLICKED) {
            g.isCorrect = false;
            g.failed = false;
            g.currentLevel = 1;
            g.newLevel = true;
            g.setup();
            
        }
    }
}
