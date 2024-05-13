package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import Levels.*;
import LogicClasses.*;
import ScreenClasses.*;
import processing.core.PApplet;
import Objects.*;

public class LevelTester {
    PApplet p = new PApplet();
    
    @Test
    public void testLevel() {
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
}
