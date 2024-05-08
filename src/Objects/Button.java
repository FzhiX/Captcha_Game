package Objects;

public class Button {
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean clicked = false;

    public Button(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean contains(int mouseX, int mouseY) {
        if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
            return true;
        }
        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return width;
    }

    public int getH() {
        return height;
    }

    public void changeClickState() {
        if (clicked) {
            clicked = false;
        } else {
            clicked = true;
        }
    }

    public boolean isButtonClicked() {
        if (clicked) return true;
        else return false;
    }
}