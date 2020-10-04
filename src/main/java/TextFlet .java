import processing.core.PApplet;

class TextFlet {

    //variabler
    float positionX, positionY, sizeX, sizeY;
    float mouseX, mouseY;
    String textFletNavn;
    String indput = ""; //dit navn består af en masse bogstaver <3

    boolean klikket = false;
    boolean acceptLetters = true;

    PApplet p;

    TextFlet(PApplet papp, int posX, int posY, int sizeX, int sizeY, String text ) {
        p = papp;
        positionX = posX;
        positionY = posY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.textFletNavn = text;
    }

    void KlikTjek(float mouseX, float mouseY) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
        if (mouseX > positionX &&
                mouseX < positionX + sizeX &&
                mouseY > positionY &&
                mouseY < positionY + sizeY) {
            klikket = !klikket;
        } else {
            klikket = false;
        }


    }

    void tegnTextFlet() {
        p.stroke(1, 46, 74, 100);
        if(klikket){
            p.fill(227, 225, 252, 250);
        } else {
            p.fill(200);
        }


        p.rect(positionX, positionY, sizeX, sizeY);

        p.fill(0);
        p.textSize(16);
        p.text(indput, positionX +(sizeX/16), positionY + (sizeY/2));
        p.text(textFletNavn,positionX, positionY);
    }

    void setAcceptLetter(boolean accept) {
        acceptLetters = accept;
    }

    void keyindput(char key) {

        if(klikket ){
            if(key == p.BACKSPACE && indput.length() > 0){

                indput =indput.substring(0,indput.length()-1);
            } else {
                if ((!acceptLetters && key >= '0' && key <= '9') || acceptLetters)
                    indput = indput + key;
            }

        }

    }





}