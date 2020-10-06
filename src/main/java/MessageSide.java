import org.w3c.dom.Text;
import processing.core.PApplet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MessageSide {
    PApplet p;
    TextFlet besked;

    AlmindeligKnap btnSendt;
    boolean visible = false;
    private long threadId, userId;
    private Connection connection;
    int y = 100;
    int maxIdx= 0,minIdx = 1;
    Long[] cand = new Long[]{0L, 0L, 0L};
    //ArrayList<Message> msgListe = new ArrayList<Message>();
    Map<Long, Message> msgMap = new HashMap<Long, Message>();


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

        String firstMsg = msgMap.get(cand[minIdx]) != null
                ? msgMap.get(cand[minIdx]).getMsg()
                : ":";

        String lastMsg = msgMap.get(cand[maxIdx]) != null
                ? msgMap.get(cand[maxIdx]).getMsg()
                :":";

        String midtMsg = msgMap.get(cand[3-maxIdx-minIdx]) != null
                ? msgMap.get(cand[3-maxIdx-minIdx]).getMsg()
                :":";

        p.text(firstMsg,p.width/4,20);
        p.text(midtMsg,p.width/4,100);
        p.text(lastMsg,p.width/4,180);
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

            msgMap.clear();
            while (rsMessages.next()) {
                String msg = rsMessages.getString(1);
                Date date = rsMessages.getTimestamp(2);
                String name = rsMessages.getString(3);
                Message message = new Message(name, date.toString(), msg);

                msgMap.put(date.getTime(), message);
            }

            cand = new Long[]{0L, 0L, 0L};
            maxIdx= 0;
            minIdx = 1;

            for(Long key : msgMap.keySet()) {
                for (int i = 0; i < cand.length; ++i) {
                    if (cand[i] > cand[maxIdx])
                        maxIdx = i;
                    if (cand[i] < cand[minIdx])
                        minIdx = i;
                }

                if (key > cand[minIdx]) {
                    cand[minIdx] = key;
                }
            }

            System.out.println("" + cand[0] + " - " + cand[1] + " - " + cand[2]);

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void sendMessage(String msg) {

        try {
            String sql = "INSERT INTO message (userId, threadId, message) VALUES (" + userId + "," + threadId + ",'" + msg + "')";
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
