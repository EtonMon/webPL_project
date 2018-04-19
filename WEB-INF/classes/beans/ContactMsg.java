package beans;
import java.util.*;

public class ContactMsg{
    private String from;
    private Date date;
    private String message;

    public ContactMsg(){
        this.from = "";
        this.message = "";
        this.date = null;
    }

    public String getFrom(){
        return this.from;
    }

    public void setFrom(String from){
        this.from = from;
    }

    public Date getDate(){
        return this.date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public String getMessage(){
        return this.message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    
}