import processing.core.PApplet;

public class MessageSide {
    PApplet p;
    TextFlet besked;

    MessageSide(PApplet p){
        this.p = p;
        besked = new TextFlet(p, p.width / 2, p.height / 2 - 70, 200, 50, "Beskeder");
    }

    public void drawMessahe(){
        besked.tegnTextFlet();
    }
}
