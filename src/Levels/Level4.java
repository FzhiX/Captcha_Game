package Levels;

import processing.core.*;

import java.text.CharacterIterator;

import LogicClasses.KBH;
import Objects.*;

public class Level4 extends Level {
    PFont monoSpace, arial;

    private PApplet p;
    public static boolean isCorrect = false;
    private String fileLocation = "Images/picsLVL4/";
    private String fileName = "picText";
    private String filetype = ".png";
    private PImage cityName;
    private String correctAnswer = "Llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch";
    private String hackAnswer = "duGae"; // For development purposes, cheet code


    int textSize = 50;
    String task = "To continue, type the characters you see in the picture below.";
    String typedText = "";
    String writtenText = "";
    String correctedText = "";
    int topMarginText = 20;

    int textBoxH = textSize;

    public Level4(PApplet p) {
        super(p);
        this.p = p;
    }

    public void setup() {
        cityName = p.loadImage(fileLocation + fileName + filetype);
    }

    public void update() {
        if (p.textWidth(typedText) > 550) {
            writtenText += "\n";
            textBoxH += textSize;
            typedText = "";
        }

        checkAnswer();

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
        p.rect(p.width / 2, topMarginText * 2 + textSize + cityName.height / 2 + cityName.height, p.textWidth(writtenText) + 6, textBoxH + 6);
        p.fill(255);
        p.rect(p.width / 2, topMarginText * 2 + textSize + cityName.height / 2 + cityName.height, p.textWidth(writtenText) + 3, textBoxH + 3);

        p.fill(0);
        p.textAlign(PConstants.CENTER, PConstants.CENTER);
        p.textSize(textSize);
        p.text(writtenText, p.width / 2, topMarginText * 2 + textSize + cityName.height / 2 + cityName.height);
    }

    public boolean checkIfLevelIsCorrect() {
        return isCorrect;
    }

    public void checkAnswer() {
        if (correctedText.equals(correctAnswer) || correctedText.equals(hackAnswer)) {
            isCorrect = true;
        }
    }
    
    public void textUpdate() {
        if (KBH.keyboardInput == KBH.CLICKED) {
            if (p.key == PConstants.BACKSPACE) {
                if (correctedText.length() > 0) {
                    correctedText = correctedText.substring(0, correctedText.length() - 1);
                }

                if (typedText.length() > 0) {
                        typedText = typedText.substring(0, typedText.length() - 1);
                }

                if (writtenText.length() > 0) {
                    if (writtenText.charAt(writtenText.length() - 1) == '\n') {
                        writtenText = writtenText.substring(0, writtenText.length() - 1);
                        textBoxH -= textSize;
                        String tempVal = "";
                        for (int i = 0; i < writtenText.length(); i++) {
                            if (writtenText.charAt(i) == '\n') {
                                tempVal = "";
                            } else {
                                tempVal += writtenText.charAt(i);
                            }
                        }
                        typedText = tempVal;
                    }
                    writtenText = writtenText.substring(0, writtenText.length() - 1);
                }

            } else if ((p.key > 64 && p.key < 91) || (p.key > 96 && p.key < 123)) {
                typedText += p.key;
                writtenText += p.key;
                correctedText += p.key;
            }
        }
    }

    public void changeCorrectedText(String textIn) { // For testing purposes
        correctedText = textIn;
    }
}