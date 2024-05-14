package Levels;

import Objects.*;
import processing.core.*;

public class Level5 extends Level {

  private PApplet p;
  public static boolean isCorrect = false;
  public static boolean isHaxCorrect = false;
  PImage[][] picFrame;
  public PicturesFrame picturesFrame;
  int picW = 40;
  int picH = 50;
  int picsHigh = 10;
  int picsWide = 20;
  int topMargin = 50;
  int picframeBorderWidth = 2;
  private String fileLocation = "Images/picsLVL5/";
  private String[][] fileNames;
  private String filetype = ".png";
  public boolean[][] correctAnswer = new boolean[][] {
    {
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
    },
    {
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
    },
    {
      true,
      true,
      true,
      false,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
    },
    {
      true,
      true,
      true,
      false,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
    },
    {
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      false,
      true,
      true,
    },
    {
      true,
      true,
      true,
      false,
      true,
      true,
      true,
      false,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      false,
      false,
      false,
      false,
      true,
    },
    {
      true,
      false,
      true,
      false,
      false,
      true,
      true,
      false,
      true,
      true,
      true,
      true,
      false,
      true,
      false,
      false,
      false,
      false,
      false,
      false,
    },
    {
      true,
      true,
      true,
      true,
      false,
      false,
      true,
      true,
      true,
      true,
      true,
      true,
      false,
      true,
      false,
      false,
      false,
      false,
      false,
      false,
    },
    {
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
    },
    {
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
    },
  };
  public boolean[][] hax;

  int textSize = 50;
  String task = "Click all the pictures without traffic lights";
  int topMarginText = 20;

  public Level5(PApplet p) {
    super(p);
    this.p = p;
  }

  public void setup() {
    haxSetup();

    fileNames = new String[picsHigh][picsWide];
    picFrame = new PImage[picsHigh][picsWide];
    for (int y = 0; y < picsHigh; y++) {
      for (int x = 0; x < picsWide; x++) {
        fileNames[y][x] = "row-" + (y + 1) + "-column-" + (x + 1);
      }
    }

    isCorrect = false;
    for (int y = 0; y < picsHigh; y++) {
      for (int x = 0; x < picsWide; x++) {
        picFrame[y][x] = p.loadImage(fileLocation + fileNames[y][x] + filetype);
      }
    }

    generateButtons();
  }

  public void haxSetup() {
    hax = new boolean[picsHigh][picsWide];
    for (int y = 0; y < picsHigh; y++) {
      for (int x = 0; x < picsWide; x++) {
        hax[y][x] = false;
      }
    }
    hax[picsHigh - 1][picsWide - 1] = true;
  }

  public void generateButtons() {
    picturesFrame = new PicturesFrame(p);
    picturesFrame.picFrameButtons(
      picW,
      picH,
      picsWide,
      picsHigh,
      topMargin,
      picframeBorderWidth
    );
  }

  public void update() {
    isCorrect = true;
    for (int y = 0; y < picsHigh; y++) {
      for (int x = 0; x < picsWide; x++) {
        if (
          picturesFrame.buttons[y][x].isButtonClicked() != correctAnswer[y][x]
        ) {
          isCorrect = false;
        }
      }
    }

    isHaxCorrect = true;
    for (int y = 0; y < picsHigh; y++) {
      for (int x = 0; x < picsWide; x++) {
        if (picturesFrame.buttons[y][x].isButtonClicked() != hax[y][x]) {
          isHaxCorrect = false;
        }
      }
    }
  }

  public void render() {
    p.textAlign(PConstants.CENTER, PConstants.TOP);
    p.textSize(textSize);
    p.text(task, p.width / 2, topMarginText);

    picturesFrame.pictureFrameNByN(
      picFrame,
      picW,
      picH,
      picsWide,
      picsHigh,
      topMarginText + textSize / 2,
      picframeBorderWidth
    );
  }

  public boolean checkIfLevelIsCorrect() {
    if (isCorrect || isHaxCorrect) {
      return true;
    }

    return false;
  }

  public int getPicsWide() {
    return picsWide;
  }

  public int getPicsHigh() {
    return picsHigh;
  }
}
