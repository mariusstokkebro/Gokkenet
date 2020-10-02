import processing.core.PApplet;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Gokkenet extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Gokkenet");
    }

    LoginSide ls;
    String databaseURL = "jdbc:ucanaccess://src//main//java//resources//database.accdb";
    boolean k = true;

    @Override
    public void settings() {
        size(500,500);
    }

    @Override
    public void setup() {

        ls = new LoginSide(this);
    }

    @Override
    public void draw() {
        connectToDatabase();
        clear();
        background(200);
        if(k == true){
            ls.drawSide();
        }




    }

    @Override
    public void keyTyped() {

        ls.typede(key);


    }

    public void connectToDatabase(){
        try {
            Connection connection = DriverManager.getConnection(databaseURL);
            println("connected to MS Access database. ");
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT [Brugernavn] FROM [Users]");
            ResultSet rp = s.executeQuery("SELECT [Kodeord] FROM [Users]");

            while (rs.next()) {
                rp.next();
                if(ls.userName.indput.equals(rs.getString(1))){
                    if(ls.password.indput.equals(rp.getString(1))){
                        k = false;
                    }
                }

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mouseClicked() {

        ls.clik(mouseX,mouseY);




    }
}
