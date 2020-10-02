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
        clear();
        background(200);
        ls.drawSide();


        try {
            Connection connection = DriverManager.getConnection(databaseURL);
            println("connected to MS Access database. ");
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT [Brugernavn] FROM [Users]");
            ResultSet rp = s.executeQuery("SELECT [Kodeord] FROM [Users]");

            while (rs.next()) {
                System.out.println(rs.getString(1));
                rp.next();

                System.out.println(rp.getString(1));
                System.out.println("");
                if(ls.userName.indput.equals(rs.getString(1))){
                    if(ls.password.indput.equals(rp.getString(1))){


                    }
                }

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyTyped() {
        if(ls.visible = true){
            ls.typede(key);
        }

    }

    @Override
    public void mouseClicked() {
        ls.clik(mouseX,mouseY);
    }
}
