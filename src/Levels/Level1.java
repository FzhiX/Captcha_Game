package Levels;

import processing.core.*;
import Objects.*;
import LogicClasses.*;

public class Level1 extends Level {
    private Button button;
    private PImage reCaptcha;
    private PImage loadImg;
    private PImage checkSign;
    private String text;
    public static boolean isCorrect = false;
    private int rot = 0;
    private boolean showPic = false;
    private int textSize = 20;

    public Level1(PApplet p) {
        super(p);
    }

    public void setup() {
        button = new Button((p.width / 3), p.height / 2, 50, 50);
        reCaptcha = p.loadImage("RecaptchaLogo.png");
        loadImg = p.loadImage("LoadPng.png");
        checkSign = p.loadImage("check.png");
        text = "I'm not a robot";
        isCorrect = false;
    }

    public void update() {
        if (this.button.contains(p.mouseX, p.mouseY) && MH.LEFT == MH.CLICKED) {
            showPic = true;
        }
        logicUpdate();
    }


    public void render() {
        p.fill(50);
        p.rectMode(PConstants.CORNER);
        p.rect(button.getX(), button.getY(), button.getW(), button.getH());
        p.fill(150);
        p.rect(button.getX(), button.getY(), button.getW(), button.getH());
        p.textSize(textSize);
        p.textAlign(PConstants.CENTER, PConstants.CENTER);
        p.text(text, (button.getX() + button.getX() / 2), (button.getY() + (button.getH()) / 2));
        int reCaptchaH = 75;
        p.imageMode(PConstants.CORNER);
        p.image(reCaptcha, (p.width / 3) * 2, (p.height / 2) - (p.abs(button.getH() - reCaptchaH)) / 2, 75, reCaptchaH);

        if (showPic) {
            if (rot == 0) {
                p.imageMode(PConstants.CENTER);
                p.image(loadImg, button.getX() + button.getW() / 2, button.getY() + button.getH() / 2, button.getW(),
                        button.getH());
                rot++;
            } else if (rot < 1080) {
                p.imageMode(PConstants.CENTER);
                p.pushMatrix();
                p.translate(button.getX() + button.getW() / 2, button.getY() + button.getH() / 2);
                p.rotate(PApplet.radians(rot));
                p.image(loadImg, 0, 0, button.getW(), button.getH());
                p.rotate(0);
                p.popMatrix();
                p.imageMode(PConstants.CORNER);
                rot += 12;
            } else {
                p.imageMode(PConstants.CORNER);
                p.image(checkSign, button.getX(), button.getY(), button.getW(), button.getH());
            }
        }
    }
    
    public void logicUpdate() {
        if (showPic == true && rot >= 1080) {
            isCorrect = true;
        }
    }

    public boolean checkIfLevelIsCorrect(){
        return isCorrect;
    }

    public void setShowPic(boolean status) { // for testing purposes
        showPic = status;
    }

    public void setRot(int rot) { // for testing purposes
        this.rot = rot;
    }
}