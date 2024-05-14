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

  public Level0(PApplet p) {
    super(p);
  }

  public void setup() {
    mailButton = new Button(37, 260, 150, 140);
    background = p.loadImage(fileLocation + "Background" + filetype);
    mail = p.loadImage(fileLocation + "mail" + filetype);

    link = new Button((p.width / 2) - 520, (p.height / 2) + 180, 650, 50);
  }

  public void update() {
    p.imageMode(PConstants.CORNER);
    p.image(background, 0, 0, p.width, p.height);

    if (
      mailButton.contains(p.mouseX, p.mouseY) &&
      MH.LEFT == MH.CLICKED &&
      !mailButton.isButtonClicked()
    ) {
      mailButton.changeClickState();
      p.delay(3000);

      mailOpened = true;
    }

    if (mailOpened) {
      p.imageMode(PConstants.CENTER);
      p.image(mail, p.width / 2, p.height / 2, 1040, 710);

      if (link.contains(p.mouseX, p.mouseY) && MH.LEFT == MH.CLICKED) {
        p.delay(3000);
        isCorrect = true;
      }
    }
  }

  public boolean checkIfLevelIsCorrect() {
    return isCorrect;
  }

  public void render() {}
}
