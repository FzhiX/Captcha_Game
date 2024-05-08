package Levels;

import processing.core.*;

import java.text.CharacterIterator;

import LogicClasses.KBH;
import Objects.*;

public class Level5 extends Level {
    private PApplet p;
    public static boolean isCorrect = false;
    private String fileLocation = "Images/picsLVL4/";
    private String fileName = "picText";
    private String filetype = ".png";
    private PImage cityName;
    private String correctAnswer = "llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch";

    int textSize = 50;
    String task = "To continue, type the characters you see in the picture below.";
    String writtenText = "";
    int topMarginText = 20;

    int textBoxW = 1000, textBoxH = 1000;

    public Level5(PApplet p) {
        super(p);
        this.p = p;
        setup();
    }

    public void setup() {
        cityName = p.loadImage(fileLocation + fileName + filetype);
    }

    public void update() {

        if (writtenText == correctAnswer) {
            isCorrect = true;
        } else {
            isCorrect = false;
        }

        textUpdate();
    }

    public void render() {
        p.textAlign(PConstants.CENTER, PConstants.TOP);
        p.textSize(textSize);
        p.text(task, p.width / 2, topMarginText);

        p.imageMode(PConstants.CENTER);
        p.image(cityName, p.width / 2, topMarginText * 2 + textSize + cityName.height / 2, cityName.width * 1.2f, cityName.height);

        p.rectMode(PConstants.CENTER);
        p.fill(0);
        p.rect(p.width / 2, topMarginText * 2 + textSize + cityName.height / 2 + cityName.height, textBoxW + 3, textBoxH + 3);
        p.fill(255);
        p.rect(p.width / 2, topMarginText * 2 + textSize + cityName.height / 2 + cityName.height, textBoxW, textBoxH);
    }

    public boolean checkIfLevelIsCorrect() {
        return isCorrect;
    }

    public void textUpdate() {
        if (KBH.keyboardInput == KBH.CLICKED) {
            writtenText += p.key;
        }
    }
}