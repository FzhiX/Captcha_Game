package LogicClasses;

public class KBH {

    public static int keyboardInput = 0;

    public final static int PRESSED = 2;
    public final static int CLICKED = 1;
    public final static int RELEASED = 0;


    private KBH() {

    }

    public static void update() {
        if(keyboardInput == CLICKED) {
            keyboardInput = PRESSED;
        }
    }
}