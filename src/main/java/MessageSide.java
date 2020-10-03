import processing.core.PApplet;

public class MessageSide {
    PApplet p;
    TextFlet besked;
    TextFlet modtager;
    AlmindeligKnap btnSendt;
    MessageSide(PApplet p){
        this.p = p;
        besked = new TextFlet(p, 0, p.height /2+200, p.width, 60, "Beskeder");
        modtager = new TextFlet(p, 0, p.height / 2+100, p.width/5, 50, "Modtager");
        btnSendt = new AlmindeligKnap(p, p.width- p.width/5 , p.height / 2+100, p.width/5, 50, "send");
    }

    public void drawMessage(){
        besked.tegnTextFlet();
        modtager.tegnTextFlet();
        btnSendt.tegnKnap();
    }
    public void writeM(char key){
        besked.keyindput(key);
        modtager.keyindput(key);

    }
    void click(float mx, float my){
            besked.KlikTjek(mx, my);
            modtager.KlikTjek(mx,my);
            btnSendt.registrerKlik(mx,my);
        }
}
