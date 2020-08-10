import java.io.Serializable;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

/**
 * This class represents an Email Object
 *
 * @author Paul Adu-Gyamfi
 *
 */
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

    /**
     *
     * @return
     * return the recipient of the email
     */
    public String getTo() {
        return to;
    }

    /**
     *
     * @param to
     * set the recipient of the email
     */
    public void setTo(String to) {
        this.to = to;
    }


    /**
     *
     * @return
     * return the carbon copy recipients
     */
    public String getCc() {
        return cc;
    }

    /**
     *
     * @param cc
     * set the carbon copy recipients
     */
    public void setCc(String cc) {
        this.cc = cc;
    }

    /**
     *
     * @return
     * return the blind carbon copy recipients
     */
    public String getBcc() {
        return bcc;
    }

    /**
     *
     * @param bcc
     * set the blind carbon copy recipients
     */
    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    /**
     *
     * @return
     * return the email subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     *
     * @param subject
     * set the email subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     *
     * @return
     * return the body of the email
     */
    public String getBody() {
        return body;
    }

    /**
     *
     * @param body
     * set the body of the email
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     *
     * @return
     * return the timestamp of the email
     */
    public GregorianCalendar getTimestamp() {
        return timestamp;
    }

    /**
     *
     * @param timestamp
     * set the email timestamp
     */
    public void setTimestamp(GregorianCalendar timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * sort the emails by subject in ascending order
     */
    public static Comparator<Email> bySubjectAscending=new Comparator<>(){
        public int compare(Email one, Email two){
            String emailOne = one.getSubject().toLowerCase();
            String emailTwo = two.getSubject().toLowerCase();
            return emailOne.compareTo(emailTwo);
        }
    };

    /**
     * sort the emails by subject in descending order
     */
    public static Comparator<Email> bySubjectDescending=new Comparator<>(){
        public int compare(Email one, Email two){
            String emailOne = one.getSubject().toLowerCase();
            String emailTwo = two.getSubject().toLowerCase();
            return emailTwo.compareTo(emailOne);
        }
    };

    /**
     * sort the emails by date in ascending order
     */
    public static Comparator<Email> byDateAscending=new Comparator<>(){
        public int compare(Email one, Email two){
            return one.getTimestamp().compareTo(two.getTimestamp());
        }
    };

    /**
     * sort the emails by date in descending order
     */
    public static Comparator<Email> byDateDescending=new Comparator<>(){
        public int compare(Email one, Email two){
            return two.getTimestamp().compareTo(one.getTimestamp());
        }
    };

    /**
     * print out contents of the email
     */
    public void displayEmailContent(){
        System.out.println("To:" + this.getTo());
        System.out.println("CC: "+ this.getCc());
        System.out.println("BCC: "+ this.getBcc());
        System.out.println("Subject: "+ this.getSubject());
        System.out.println(this.getBody());
    }
}
