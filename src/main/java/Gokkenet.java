import processing.core.PApplet;
import resources.Message;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Gokkenet extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Gokkenet");
    }
    MessageSide ms;
    LoginSide ls;
    ChooseThread ct;
    Message message;

    private String databaseURL = "jdbc:ucanaccess://src//main//java//resources//database.accdb";
    boolean k = true;
    private Connection connection = null;

    public Gokkenet() {
        try {
            connection = DriverManager.getConnection(databaseURL);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        println("connected to MS Access database. ");
    }

    @Override
    public void settings() {
        size(500,500);
    }

    @Override
    public void setup() {
        ls = new LoginSide(this);
        ms = new MessageSide(this);
        ct = new ChooseThread(this, connection);
        message = new Message(this,100,100,200,50,"Dette er en lang besked jeg skriver for at kunne se det");
    }

    @Override
    public void draw() {
        clear();
        background(200);
        ls.drawSide();


        if (ls.btnLogin.klikket == true)
            login();

        if(ls.visible == false && ct.visibale){
            ct.drawCT();
        }
        if(ls.visible == false && ct.visibale == false){
            ms.drawMessage();
        }

    }

    @Override
    public void keyTyped() {
        if(ls.visible){
            ls.typede(key);

        }

        if(ls.visible == false && ct.visibale == false){
            ms.writeM(key);
        }

    }

    @Override
    public void mouseClicked() {
        if(ls.visible){
            ls.clik(mouseX,mouseY);
        } else if(ct.visibale){
            ct.click(mouseX,mouseY);
        } else if(ls.visible == false && ct.visibale == false){
            ms.click(mouseX,mouseY);
        }


    }

    private void login() {
        ls.btnLogin.registrerRelease();
        Statement s = null;
        try {
            s = connection.createStatement();
            ResultSet rsUser = s.executeQuery("SELECT [username],[password] FROM [user]");

            while (rsUser.next()) {
                String rsUsername = rsUser.getString(1);
                String rsPassword = rsUser.getString(2);

                System.out.println(rsUsername);
                System.out.println(rsPassword);
                System.out.println("");

                if (ls.userName.indput.equals(rsUsername) && ls.password.indput.equals(rsPassword)) {
                    ls.visible = false;
                    ct.visibale = true;
                    //break;
                    ls.password.klikket = false;
                }
            }
        } catch (SQLException throwable) {
                throwable.printStackTrace();
        }
    }
}
