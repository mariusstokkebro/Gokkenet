import processing.core.PApplet;

import java.awt.event.KeyEvent;
import java.security.Key;

public class LoginSide {
 PApplet p;
 TextFlet password;
 TextFlet userName;
 int id = 1;

    LoginSide(PApplet p){

      this.p = p;
      password = new TextFlet(p,p.width/2,p.height/2, 200, 50, "Fuck");


      if (p.keyPressed && p.keyCode == p.ENTER){
          /*    ok mangler kun at lave så den har et variabel til databasen.
          INSERT INTO Customers (Id, Brugernavn, Kodeord)
          VALUES (id, userName.indput, password.indput);
          */
          id++;
      }
    }

    void drawSide() {

            password.tegnTextFlet();
            userName.tegnTextFlet();
    }

    void typede(char key) {
            password.keyindput(key);
            userName.keyindput(key);

    }

    void clik(float mx, float my){
        password.KlikTjek(mx,my);
        userName.KlikTjek(mx,my);
    }
}
}
