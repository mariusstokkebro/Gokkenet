import processing.core.PApplet;

public class ToggleKnap extends Knap {

    ToggleKnap(PApplet papp, int posX, int posY, int sizeX, int sizeY, String text) {
        super(papp, posX, posY, sizeX, sizeY, text );
    }

    @Override
    void registrerKlik(float mouseX, float mouseY) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
        if (mouseX > positionX &&
                mouseX < positionX + sizeX &&
                mouseY > positionY &&
                mouseY < positionY + sizeY) {
            klikket = !klikket;
        }
    }



}