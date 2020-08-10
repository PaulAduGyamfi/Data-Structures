import java.io.Serializable;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Email implements Serializable{
    private String to;
    private String cc;
    private String bcc;
    private String subject;
    private String body;
    private GregorianCalendar timestamp;

    public Email(String to, String cc, String bcc, String subject, String body, GregorianCalendar timestamp) {
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.subject = subject;
        this.body = body;
        this.timestamp = timestamp;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public GregorianCalendar getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(GregorianCalendar timestamp) {
        this.timestamp = timestamp;
    }

    public static Comparator<Email> bySubjectAscending=new Comparator<>(){
        public int compare(Email one, Email two){
            String emailOne = one.getSubject().toLowerCase();
            String emailTwo = two.getSubject().toLowerCase();
            return emailOne.compareTo(emailTwo);
        }
    };

    public static Comparator<Email> bySubjectDescending=new Comparator<>(){
        public int compare(Email one, Email two){
            String emailOne = one.getSubject().toLowerCase();
            String emailTwo = two.getSubject().toLowerCase();
            return emailTwo.compareTo(emailOne);
        }
    };

    public static Comparator<Email> byDateAscending=new Comparator<>(){
        public int compare(Email one, Email two){
            return one.getTimestamp().compareTo(two.getTimestamp());
        }
    };

    public static Comparator<Email> byDateDescending=new Comparator<>(){
        public int compare(Email one, Email two){
            return two.getTimestamp().compareTo(one.getTimestamp());
        }
    };

    public void displayEmailContent(){
        System.out.println("To:" + this.getTo());
        System.out.println("CC: "+ this.getCc());
        System.out.println("BCC: "+ this.getBcc());
        System.out.println("Subject: "+ this.getSubject());
        System.out.println(this.getBody());
    }
}
