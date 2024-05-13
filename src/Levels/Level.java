package Levels;

import processing.core.*;
import Objects.*;

public class Level {
    public ContinueButton continueButton;
    PApplet p;

    public Level(PApplet p) {
        this.p = p;
        continueButton = new ContinueButton(p.width - 150, p.height - 100, 100, 50);
    }

    public void setup() {
    }

    public void update() {

    }

    public void render() {
        
    }

    public boolean checkIfLevelIsCorrect() {
        return false;
    }

}