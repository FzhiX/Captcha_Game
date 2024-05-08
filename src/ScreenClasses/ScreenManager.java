package ScreenClasses;
import processing.core.*;
import Levels.*;
import Objects.ContinueButton;
import LogicClasses.*;

public class ScreenManager {
    PApplet p;
    ContinueButton continueButton;
    Level level;
    GameManager gameManager;

    public ScreenManager(PApplet p, GameManager g) {
        this.p = p;
        gameManager = g;
    }

    public PApplet getPApplet() {
        return p;
    }

    public void setup() {
        
    }

    public void render() {
        if (!gameManager.failed) {
            gameManager.level.continueButton.render(p);
        }
    }
}