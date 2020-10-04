import processing.core.PApplet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MessageSide {
    PApplet p;
    TextFlet besked;

    AlmindeligKnap btnSendt;
    boolean visible = false;
    private long threadId, userId;
    private Connection connection;
    int y = 100;
    ArrayList<Message> msgListe = new ArrayList<Message>();


    MessageSide(PApplet p, Connection connection) {
        this.p = p;
        this.connection = connection;
        besked = new TextFlet(p, 0, p.height / 2 + 200, p.width, 60, "Beskeder");
        btnSendt = new AlmindeligKnap(p, p.width - p.width / 5, p.height / 2 + 100, p.width / 5, 50, "send");
    }

    public void setThreadId(long threadId) {
        this.threadId = threadId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void drawMessage() {
        besked.tegnTextFlet();
        btnSendt.tegnKnap();

        if (btnSendt.klikket) {
            sendMessage(besked.indput);
            btnSendt.registrerRelease();
        }
        msgListe.add(new Message("", "", ""));


    }

    public void writeM(char key) {
        besked.keyindput(key);
    }

    void click(float mx, float my) {
        besked.KlikTjek(mx, my);
        btnSendt.registrerKlik(mx, my);
    }

    public void updateMessages() {
        try {
            Statement statement = connection.createStatement();
            ResultSet rsMessages = statement.executeQuery("SELECT message.message, message.timestamp, username " +
                    "FROM thread INNER JOIN message ON thread.threadId = message.threadId " +
                    "INNER JOIN user ON message.userId = user.userID " +
                    "WHERE threadId = " + threadId + " ORDER BY message.timestamp");
            int i = 0;
            while (rsMessages.next()) {
                p.text(rsMessages.getString(3) + ": ", p.width / 2, y - 20 +  200);
                p.text(rsMessages.getString(1), p.width / 2, y +200);
                p.text(rsMessages.getString(2), p.width / 2, y + 20 +200);



                p.println(i);
                i++;

            }



        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void sendMessage(String msg) {
        msgListe.add(new Message("a","111",msg));
        try {
            String sql = "INSERT INTO message (userId, threadId, message) VALUES (" + userId + "," + threadId + ",'" + msg + "')";
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
