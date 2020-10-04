import processing.core.PApplet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ChooseThread {
    PApplet p;
    ArrayList<ChooseThredeGroup> thredeGroupsList = new ArrayList<ChooseThredeGroup>();
    AlmindeligKnap btnAddThread;
    int threadid;
    boolean chatVisible = false;

    boolean visibale = false;

    ChooseThread(PApplet p, Connection connection) {
        this.p = p;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rsThread = statement.executeQuery("SELECT threadId FROM thread");

            int i = 0;
            int startY = 50;

            while (rsThread.next()) {
                ++i;
                long threadId = rsThread.getLong(1);
                String sql = "SELECT username FROM user INNER JOIN threadUser ON user.userId = threadUser.userId WHERE threadUser.threadId = " + threadId;
                ResultSet rsThreadUser = statement.executeQuery(sql);
                String names = "";

                while (rsThreadUser.next()) {
                    names += rsThreadUser.getString(1);
                    names += ", ";

                }
                names = names.substring(0, names.length()-2);

                thredeGroupsList.add(new ChooseThredeGroup(p, "navne:" + names, 10, 100 * i + startY, 200, 50, threadId));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        btnAddThread = new AlmindeligKnap(p, p.width - 100, p.height - 100, 100, 100, "New");
    }

    void drawCT() {
        p.textSize(25);
        p.text("Choose Threde", 10, 40);
        for (int i = 0; i < thredeGroupsList.size(); ++i) {
            ChooseThredeGroup t = thredeGroupsList.get(i);
            t.drawBtn();
        }
        btnAddThread.tegnKnap();

    }

    void click(float mx, float my) {
        btnAddThread.registrerKlik(mx, my);
        for (int i = 0; i < thredeGroupsList.size(); ++i) {
            ChooseThredeGroup t = thredeGroupsList.get(i);
            t.click(mx, my);
            if(t.btnJoin.klikket){
                visibale = false;
                threadid = i;
                chatVisible = true;

            }
        }
    }

    boolean getchatVisbale(){
        return chatVisible;
    }
    int getThreadid(){
        return threadid;
    }

}



