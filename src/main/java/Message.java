import processing.core.PApplet;

public class Message {
    PApplet p;
    String navn,date,msg;
    public Message( String navn, String date, String msg ){
        this.navn =navn;
        this.date = date;
        this.msg = msg;
    }
    String getMsg(){
        return(navn + ": \n" + msg +"\n" + date);
    }
}
