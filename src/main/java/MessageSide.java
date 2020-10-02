import processing.core.PApplet;

public class MessageSide {
    PApplet p;
    TextFlet besked;
    TextFlet modtager;
    MessageSide(PApplet p){
        this.p = p;
        besked = new TextFlet(p, 0, p.height /2+200, p.width, 60, "Beskeder");
        modtager = new TextFlet(p, 0, p.height / 2+100, p.width/5, 50, "Modtager");
    }

    public void drawMessage(){
        besked.tegnTextFlet();
        modtager.tegnTextFlet();
    }
    public void writeM(char key){
        besked.keyindput(key);
        modtager.keyindput(key);

    }
    void click(float mx, float my){
            besked.KlikTjek(mx, my);
            modtager.KlikTjek(mx,my);
        }
}
