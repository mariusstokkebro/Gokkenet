import processing.core.PApplet;

public class AlmindeligKnap extends Knap {

    AlmindeligKnap(PApplet papp, int posX, int posY, int sizeX, int sizeY, String text) {
        super(papp, posX, posY, sizeX, sizeY, text  );
    }

    @Override
    void registrerKlik(float mouseX, float mouseY) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
        if (mouseX > positionX &&
                mouseX < positionX + sizeX &&
                mouseY > positionY &&
                mouseY < positionY + sizeY) {
            klikket = true;
        }
    }

    void registrerRelease() {
        klikket = false;
    }
}

