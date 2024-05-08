package Objects;

import processing.core.PApplet;
import processing.core.PConstants;

public class ContinueButton extends Button {
    private String text = "Continue";

    int x, y, w, h;


    public ContinueButton(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.x = x;
        this.y = y;
        this.w = width;
        this.h = height;
    }

    public String getText() {
        return text;
    }

    public void render(PApplet p) {
        p.fill(255);
        p.rectMode(PConstants.CORNER);
        p.rect(getX(), getY(), getW(), getH());
        p.fill(255, 0, 0);
        p.textAlign(PConstants.CENTER, PConstants.CENTER);
        p.textSize(20);
        p.text(text, (x + w / 2), (y + h / 2));
    }
}