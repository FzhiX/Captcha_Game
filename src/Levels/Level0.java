package Levels;

import LogicClasses.*;
import Objects.*;
import processing.core.*;

public class Level0 extends Level {

  private Button mailButton;
  private Button link;
  private PImage background;
  private PImage mail;

  private String fileLocation = "Images/picsMisc/";
  private String filetype = ".png";

  public static boolean isCorrect = false;
  private boolean mailOpened = false;
  private boolean mailPressed = false;
  private boolean linkPressed = false;
  private int rot = 0;

  PImage loadImg;

  public Level0(PApplet p) {
    super(p);
  }

  public void setup() {
    mailButton = new Button(37, 260, 150, 140);
    background = p.loadImage(fileLocation + "Background" + filetype);
    mail = p.loadImage(fileLocation + "mail" + filetype);

    link = new Button((p.width / 2) - 520, (p.height / 2) + 180, 650, 50);
    loadImg = p.loadImage("LoadPng.png");
  }

  public void update() {
    p.imageMode(PConstants.CORNER);
    p.image(background, 0, 0, p.width, p.height);

    if (
      mailButton.contains(p.mouseX, p.mouseY) && MH.LEFT == MH.CLICKED && !mailButton.isButtonClicked()) {
      mailButton.changeClickState();

      mailPressed = true;
    }

    if (mailPressed) {
      if (rot < 1080) {
        p.imageMode(PConstants.CENTER);
        p.pushMatrix();
        p.translate(p.mouseX - 5, p.mouseY - 5);
        p.rotate(PApplet.radians(rot));
        p.image(loadImg, 0, 0, 20, 20);
        p.rotate(0);
        p.popMatrix();
        p.imageMode(PConstants.CORNER);
        rot += 12;
      } else {
        mailOpened = true;
      }

    }

    if (mailOpened) {
      p.imageMode(PConstants.CENTER);
      p.image(mail, p.width / 2, p.height / 2, 1040, 710);

      if (link.contains(p.mouseX, p.mouseY) && MH.LEFT == MH.CLICKED) {
        rot = 0;
        linkPressed = true;
      }
    }

    if (linkPressed) {
      if (rot < 1080) {
        p.imageMode(PConstants.CENTER);
        p.pushMatrix();
        p.translate(p.mouseX - 5, p.mouseY - 5);
        p.rotate(PApplet.radians(rot));
        p.image(loadImg, 0, 0, 20, 20);
        p.rotate(0);
        p.popMatrix();
        p.imageMode(PConstants.CORNER);
        rot += 12;
      } else {
        isCorrect = true;
      }
    }
  }

  public boolean checkIfLevelIsCorrect() {
    return isCorrect;
  }

  public void render() {}
}
