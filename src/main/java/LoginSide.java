import processing.core.PApplet;

public class LoginSide {
    PApplet p;
    TextFlet password;
    TextFlet userName;
    boolean visible = true;
    AlmindeligKnap registrer;
    AlmindeligKnap btnLogin;
    LoginSide(PApplet p) {
        this.p = p;
        password = new TextFlet(p, p.width / 2-100, p.height / 2, 200, 50, "Password");
        userName = new TextFlet(p, p.width / 2-100, p.height / 2 - 70, 200, 50, "userName");
        registrer = new AlmindeligKnap(p,p.width/2,p.height/2 +60,100,50,"registrer");
        btnLogin  = new AlmindeligKnap(p,p.width / 2-100, p.height / 2 +60,100,50,"login");
    }

    void drawSide() {
        if (visible) {
            password.tegnTextFlet();
            userName.tegnTextFlet();
            registrer.tegnKnap();
            btnLogin.tegnKnap();

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


        if (visible) {
            password.KlikTjek(mx, my);
            userName.KlikTjek(mx, my);

        }else{
            userName.klikket = false;
            password.klikket= !password.klikket;
        }
        if(registrer.erKlikket()){
            visible = false;
            registrer.registrerRelease();
            btnLogin.registrerRelease();
        }
        registrer.registrerKlik(p.mouseX,p.mouseY);
        btnLogin.registrerKlik(p.mouseX,p.mouseY);
    }

    ///
}