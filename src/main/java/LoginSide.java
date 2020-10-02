import processing.core.PApplet;

public class LoginSide {
    PApplet p;
    TextFlet password;
    TextFlet userName;
    boolean visible = true;
    AlmindeligKnap registrer;
    LoginSide(PApplet p) {
        this.p = p;
        password = new TextFlet(p, p.width / 2, p.height / 2, 200, 50, "Password");
        userName = new TextFlet(p, p.width / 2, p.height / 2 - 70, 200, 50, "userName");
        registrer = new AlmindeligKnap(p,250,400,100,50,"registrer");
    }

    void drawSide() {
        if (visible) {
            password.tegnTextFlet();
            userName.tegnTextFlet();
            registrer.tegnKnap();

        }
        p.println(visible);
    }


    void typede(char key) {
        if (visible) {
            password.keyindput(key);
            userName.keyindput(key);
        }
    }

    void clik(float mx, float my){
        password.KlikTjek(mx,my);
        userName.KlikTjek(mx,my);
        if(registrer.erKlikket()){
            visible = false;
            registrer.registrerRelease();
        }
        registrer.registrerKlik(p.mouseX,p.mouseY);
    }
}