package LogicClasses;

import Levels.*;
import Objects.*;
import ScreenClasses.*;
import processing.core.*;

public class GameManager {

  Win winScreen;
  ContinueButton continueButton;
  PApplet p;
  ScreenManager screenManager;
  public boolean isCorrect = false;
  public boolean failed = false;
  public int currentLevel = 0;
  public Level level;
  public boolean newLevel = true;
  public boolean win = false;

  public GameManager(PApplet p) {
    this.p = p;
  }

  public void setup() {
    p.rectMode(PConstants.CORNER);
    setLevel(currentLevel);
  }

  public void update() {
    checkIfCorrect();
    checkNextLevel();

    setLevel(currentLevel);
    if (win) {
      winScreen();
    } else if (!failed) {
      updateAndRenderLevel();
    } else {
      lossScreen();
    }
  }

  private void checkIfCorrect() {
    isCorrect = level.checkIfLevelIsCorrect();
  }

  private void checkNextLevel() {
    if (
      level.continueButton.contains(p.mouseX, p.mouseY) && MH.LEFT == MH.CLICKED
    ) {
      if (isCorrect) {
        nextLevel();
      } else {
        failed = true;
      }
    } else if (currentLevel == 0 && isCorrect) {
      nextLevel();
    }
  }

  private void nextLevel() {
    currentLevel++;
    newLevel = true;
    isCorrect = false;
  }

  private void setLevel(int levelIn) {
    if (newLevel) {
      newLevel = false;

      switch (levelIn) {
        case 0:
          // Level 0
          level = new Level0(p);
          break;
        case 1:
          level = new Level1(p);
          break;
        case 2:
          // Level 2
          level = new Level2(p);
          break;
        case 3:
          // Level 3
          level = new Level3(p);
          break;
        case 4:
          // Level 4
          level = new Level4(p);
          break;
        case 5:
          // Level 5
          level = new Level5(p);
          break;
        default:
          winScreen = new Win(p);
          win = true;
          break;
      }

      level.setup();
    }
  }

  public void updateAndRenderLevel() {
    level.update();
    level.render();
  }

  public void lossScreen() {
    Loss.showLossScreen(p, currentLevel, this);
  }

  public void winScreen() {
    winScreen.showWinScreen(p, this);
  }
}
