import processing.core.PApplet;

public class Message {
    PApplet p;
    int posX,posY,sizeX,sizeY;
    String message;
    public Message(PApplet p, int posX, int posY, int sizeX, int sizeY, String message){
        this.p = p;
        this.posX=posX;
        this.posY=posY;
        this.sizeX=sizeX;
        this.sizeY=sizeY;
        this.message = message;
    }

    public void drawMessage(){
        p.fill(200);
        p.rect(posX,posY - (int)(sizeY/2),sizeX,sizeY);
        p.fill(0);
        p.textAlign(p.CORNER,p.CENTER);
        p.text(message,posX,posY);

    }
}
