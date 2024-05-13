package Objects;

import processing.core.*;
import LogicClasses.*;
import Objects.*;


public class PicturesFrame {
    PApplet p;
    public Button[][] buttons;
    int picsWide, picsHigh;

    public PicturesFrame (PApplet p) {
        this.p = p;
    }

    public void picFrameButtons(int picW, int picH, int picsWide, int picsHigh, int topMargin, int borderWidth) {
        buttons = new Button[picsHigh][picsWide];

        for (int y = 0; y < picsHigh; y++) {
            for (int x = 0; x < picsWide; x++) {
                buttons[y][x] = new Button(p.width / 2 + (x - (picsWide - 1) / 2) * (picW + borderWidth) - picW / 2, p.height / 2 + (y - (picsHigh - 1) / 2) * (picH + borderWidth) - picH / 2 + topMargin, picW, picH);
            }
        }
    }

    public void pictureFrameNByN(PImage[][] pics, int picW, int picH, int picsWide, int picsHigh, int topMargin, int borderWidth) {
        p.imageMode(PConstants.CENTER);

        

        for (int y = 0; y < picsHigh; y++) {
            for (int x = 0; x < picsWide; x++) {
                if (buttons[y][x].contains(p.mouseX, p.mouseY) && MH.LEFT == MH.CLICKED) {
                    buttons[y][x].changeClickState();
                }
            }
        }

        for (int y = 0; y < picsHigh; y++) {
            for (int x = 0; x < picsWide; x++) {
                p.image(pics[y][x], p.width / 2 + (x - (picsWide - 1) / 2) * (picW + borderWidth), p.height / 2 + (y - (picsHigh - 1) / 2) * (picH + borderWidth) + topMargin, isClicked(buttons[y][x], picW), isClicked(buttons[y][x], picH));
            }
        }
    }  

    private int isClicked(Button buttonOnCurrPic, int picSide) {
        if (buttonOnCurrPic.isButtonClicked()) {
            return (picSide * 4 / 5);
        }   else {
            return picSide;
        }
    }
}
