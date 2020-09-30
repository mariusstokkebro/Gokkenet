import processing.core.PApplet;

public class LoginSide {
    PApplet p;
    TextFlet password;
    TextFlet userName;
    boolean visible = true;

    LoginSide(PApplet p) {
        this.p = p;
        password = new TextFlet(p, p.width / 2, p.height / 2, 200, 50, "Password");
        userName = new TextFlet(p, p.width / 2, p.height / 2 - 60, 200, 50, "userName");
    }

    void drawSide() {
        if (visible) {
            password.tegnTextFlet();
            userName.tegnTextFlet();
        }
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
    }
}