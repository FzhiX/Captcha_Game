package ScreenClasses;

import Levels.*;
import LogicClasses.*;
import Objects.ContinueButton;
import processing.core.*;

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

  public void setup() {}

  public void render() {
    if (
      !gameManager.failed && !gameManager.win && gameManager.currentLevel != 0
    ) {
      gameManager.level.continueButton.render(p);
    }
  }
}
