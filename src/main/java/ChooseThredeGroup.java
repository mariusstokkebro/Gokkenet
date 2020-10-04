import processing.core.PApplet;

public class ChooseThredeGroup {
    PApplet p;
    String names = "";
    int posX,posY,sizeX,sizeY;
    int extra;
    AlmindeligKnap btnJoin;
    private long threadId;

    ChooseThredeGroup(PApplet p,String name,int posX,int posY,int sizeX, int sizeY, long threadId) {
        this.p = p;
        names = name;
        this.posX = posX;
        this.posY = posY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.threadId = threadId;

        extra = (int) sizeX/4;
        btnJoin = new AlmindeligKnap(p,(int)(posX + extra +p.textWidth(names)), posY,(int)p.textWidth("Join")+ extra ,sizeY,"Join");
    }

    public void drawBtn(){
        p.fill(200);
       p.rect(posX,posY , sizeX,sizeY);
       p.fill(0);
       p.textAlign(p.CORNER,p.CENTER);
       p.text(names,posX ,posY + (int)(extra/2) , posY);
        p.textAlign(p.CORNER);
       btnJoin.tegnKnap();
    }

    void  click(float mx, float my){
        btnJoin.registrerKlik(mx,my);
    }

    long getThreadId(){
        return threadId;
    }
}
