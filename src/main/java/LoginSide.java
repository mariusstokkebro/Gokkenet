import processing.core.PApplet;

public class LoginSide {
    PApplet p;
    TextFlet password;
    TextFlet userName;
    boolean visible = true;
    int id;

    LoginSide(PApplet p) {
        id = 1;
        this.p = p;
        password = new TextFlet(p, p.width / 2, p.height / 2, 200, 50, "Password");
        userName = new TextFlet(p, p.width / 2, p.height / 2 - 70, 200, 50, "userName");
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

    void addData(){
        if (p.keyPressed && p.keyCode == p.ENTER){
          /*    ok mangler kun at lave så den har et variabel til databasen.
          VoresBord.INSERT INTO Users (Id, Brugernavn, Kodeord)
          VoresBord.(id, userName.indput, password.indput);
          */
            id++;
        }
    }
}