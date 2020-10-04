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

        extra = (int) sizeX/2;
        btnJoin = new AlmindeligKnap(p,(int)(posX + extra +p.textWidth(names))+20, posY,(int)p.textWidth("Join")+ sizeX/4 ,sizeY,"Join");
    }

    public void drawBtn(){
        btnJoin.tegnKnap();
        p.fill(200);
       p.rect(posX,posY ,p.textWidth(names) ,sizeY);
       p.fill(0);
       p.textAlign(p.CORNER,p.CENTER);
       p.text(names,posX ,posY + (int)((sizeX/5)/2) , posY);
        p.textAlign(p.CORNER);

    }

    void  click(float mx, float my){
        btnJoin.registrerKlik(mx,my);
    }

    long getThreadId(){
        return threadId;
    }
}
