package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import Levels.*;
import LogicClasses.*;
import Objects.*;
import ScreenClasses.*;
import org.junit.Test;
import processing.core.PApplet;

public class LevelTester {

  PApplet p = new PApplet();

  @Test
  public void testLevel1() {
    Level1 level = new Level1(p);

    assertFalse(level.checkIfLevelIsCorrect());

    level.setShowPic(true);
    level.setRot(1080);

    level.logicUpdate();
    assertTrue(level.checkIfLevelIsCorrect());
  }

  @Test
  public void testLevel2() {
    Level2 level = new Level2(p);
    assertFalse(level.checkIfLevelIsCorrect());

    level.generateButtons();
    level.picturesFrame.buttons[0][0].changeClickState();
    level.update();
    assertFalse(level.checkIfLevelIsCorrect());
    level.picturesFrame.buttons[0][0].changeClickState();

    level.picturesFrame.buttons[2][0].changeClickState();
    level.picturesFrame.buttons[2][1].changeClickState();
    level.picturesFrame.buttons[1][1].changeClickState();
    level.update();
    assertTrue(level.checkIfLevelIsCorrect());
  }

  @Test
  public void testLevel3() {
    Level3 level = new Level3(p);
    assertFalse(level.checkIfLevelIsCorrect());

    level.generateButtons();
    level.picturesFrame.buttons[0][0].changeClickState();
    level.update();
    assertFalse(level.checkIfLevelIsCorrect());

    level.picturesFrame.buttons[0][0].changeClickState();

    level.picturesFrame.buttons[2][0].changeClickState();
    level.picturesFrame.buttons[2][1].changeClickState();
    level.picturesFrame.buttons[1][1].changeClickState();
    level.picturesFrame.buttons[0][2].changeClickState();
    level.update();
    assertTrue(level.checkIfLevelIsCorrect());
  }

  @Test
  public void testLevel4() {
    Level4 level = new Level4(p);
    assertFalse(level.checkIfLevelIsCorrect());

    level.changeCorrectedText("this should be a wrong answer");
    level.checkAnswer();
    assertFalse(level.checkIfLevelIsCorrect());

    level.changeCorrectedText(
      "Llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch"
    );
    level.checkAnswer();
    assertTrue(level.checkIfLevelIsCorrect());

    level.changeCorrectedText("duGae");
    level.checkAnswer();
    assertTrue(level.checkIfLevelIsCorrect());
  }

  @Test
  public void testLevel5() {
    Level5 level = new Level5(p);
    assertFalse(level.checkIfLevelIsCorrect());

    level.generateButtons();
    level.haxSetup();

    level.picturesFrame.buttons[0][0].changeClickState();
    level.update();
    assertFalse(level.checkIfLevelIsCorrect());

    level.picturesFrame.buttons[0][0].changeClickState();

    level.picturesFrame.buttons[2][0].changeClickState();
    level.picturesFrame.buttons[2][1].changeClickState();
    level.picturesFrame.buttons[1][1].changeClickState();
    level.picturesFrame.buttons[0][2].changeClickState();
    level.update();
    assertFalse(level.checkIfLevelIsCorrect());

    for (int y = 0; y < level.getPicsHigh(); y++) {
      for (int x = 0; x < level.getPicsWide(); x++) {
        if (level.picturesFrame.buttons[y][x].isButtonClicked()) {
          level.picturesFrame.buttons[y][x].changeClickState();
        }
      }
    }
    for (int y = 0; y < level.getPicsHigh(); y++) {
      for (int x = 0; x < level.getPicsWide(); x++) {
        if (level.correctAnswer[y][x] == true) {
          level.picturesFrame.buttons[y][x].changeClickState();
        }
      }
    }
    level.update();
    assertTrue(level.checkIfLevelIsCorrect());

    for (int y = 0; y < level.getPicsHigh(); y++) {
      for (int x = 0; x < level.getPicsWide(); x++) {
        if (level.picturesFrame.buttons[y][x].isButtonClicked()) {
          level.picturesFrame.buttons[y][x].changeClickState();
        }
      }
    }

    level.picturesFrame.buttons[level.getPicsHigh() - 1][level.getPicsWide() -
      1].changeClickState();
    level.update();
    assertTrue(level.checkIfLevelIsCorrect());
  }
}
