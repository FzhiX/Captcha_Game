package Levels;

import processing.core.*;
import Objects.*;

public class Level3 extends Level {
    private PApplet p;
    public static boolean isCorrect = false;
    PImage[][] picFrame = new PImage[3][3];
    PicturesFrame picturesFrame;
    int picW = 238;
    int picH = 238;
    int picsHigh = 3;
    int picsWide = 3;
    int topMargin = 50;
    private String fileLocation = "Images/picsLVL2og3/";
    private String[][] fileNames;
    private String filetype = ".png";
    private boolean[][] correctAnswer = new boolean[][] {
        {false, false, true},
        {false, true, false},
        {true, true, false}
    };

    int textSize = 50;
    String task = "Click all the pictures with bikes";
    int topMarginText = 20;

    public Level3(PApplet p) {
        super(p);
        this.p = p;
        setup();
    }

    public void setup() {
        fileNames = new String[][] {
            {"pic1,1", "pic1,2", "pic1,3"}, 
            {"pic2,1", "pic2,2", "pic2,3"}, 
            {"pic3,1", "pic3,2", "pic3,3"}
        };
        picturesFrame = new PicturesFrame(p);
        isCorrect = false;
        for (int y = 0; y < picsHigh; y++){
            for (int x = 0; x < picsWide; x++) {
                picFrame[y][x] = p.loadImage(fileLocation + fileNames[y][x] + filetype);
            }
        }

        picturesFrame.picFrameButtons(picW, picH, picsWide, picsHigh, topMargin);
    }

    public void update() {
        isCorrect = true;
        for (int y = 0; y < picsHigh; y++){
            for (int x = 0; x < picsWide; x++) {
                if (picturesFrame.buttons[y][x].isButtonClicked() != correctAnswer[y][x]) {
                    isCorrect = false;
                }
            }
        }
        
    }

    public void render() {
        p.textAlign(PConstants.CENTER, PConstants.TOP);
        p.textSize(textSize);
        p.text(task, p.width / 2, topMarginText);

        picturesFrame.pictureFrameNByN(picFrame, picW, picH, picsWide, picsHigh, topMarginText + textSize / 2);
    }

    public boolean checkIfLevelIsCorrect(){
        return isCorrect;
    }
}