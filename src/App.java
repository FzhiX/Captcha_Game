import processing.core.*;
import LogicClasses.*;
import Objects.ContinueButton;
import ScreenClasses.ScreenManager;


public class App extends PApplet {
    ScreenManager screenManager;
    GameManager gameManager;
    int frameRate = 24;

    public static void main(String[] args){
        PApplet.main("App");
    }

    public void settings(){
        fullScreen();
        
        gameManager = new GameManager(this);
        screenManager = new ScreenManager(this, gameManager);
    }

    public void setup(){
        frameRate(frameRate);

        gameManager.setup();
        screenManager.setup();
    }

    public void draw(){
        background(238);

        gameManager.update();

        screenManager.render();

        MH.update(mouseX, mouseY);
        KBH.update();
    }

    public void mousePressed() {

        switch (mouseButton) {
            case PConstants.LEFT:
                MH.LEFT = MH.CLICKED;
                break;
            case PConstants.RIGHT:
                MH.RIGHT = MH.CLICKED;
                break;
            default:
                break;
        }
    }

    public void mouseReleased() {
        switch (mouseButton) {
            case PConstants.LEFT:
                MH.LEFT = MH.RELEASED;
                break;
            case PConstants.RIGHT:
                MH.RIGHT = MH.RELEASED;
                break;
            default:
                break;
        }
    }

    public void keyPressed() {
        if (key != CODED) {
            KBH.keyboardInput = KBH.CLICKED;
        }
    }

    public void keyReleased() {
        KBH.keyboardInput = KBH.RELEASED;
    }
}
