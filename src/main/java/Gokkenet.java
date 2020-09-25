import processing.core.PApplet;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Gokkenet extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Gokkenet");

        String databaseURL = "jdbc:ucanaccess://src//main//java//resources//database.accdb";
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

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    @Override
    public void setup() {


    }

}
