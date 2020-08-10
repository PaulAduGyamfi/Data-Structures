import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * This class represents an Folder Object that contains a list of email objects
 *
 * @author Paul Adu-Gyamfi
 *
 */
public class Folder{
    private ArrayList<Email> emails;
    private String name;
    private String currentSortingMethod;

    public Folder(String name) {
        this.emails = emails = new ArrayList<>();
        this.name = name;
    }
    public Folder(){
        this.emails = emails = new ArrayList<>();
    }


    /**
     *
     * @return
     * the list of emails in the folder
     */
    public ArrayList<Email> getEmails(){
        return this.emails;
    }

    /**
     *
     * @return
     * get the name of the folder
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * set the name of the folder
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * the current sorting method of the folder
     */
    public String getCurrentSortingMethod() {
        return currentSortingMethod;
    }

    /**
     *
     * @param currentSortingMethod
     * set the current sorting method of the folder
     */
    public void setCurrentSortingMethod(String currentSortingMethod) {
        this.currentSortingMethod = currentSortingMethod;
    }

    /**
     *
     * @param email
     * add an email to the folder
     */
    public void addEmail(Email email){
        emails.add(email);
    }

    /**
     *
     * @param index
     * index of the email in the folder
     * @return
     * the email removed from the folder
     */
    public Email removeEmail(int index){
        Email saveDeleted = emails.get(index);
        emails.remove(index);
        return saveDeleted;
    }

    /**
     * sort the emails by subject in ascending order
     */
    public void sortBySubjectAscending(){
        emails.sort(Email.bySubjectAscending);
        this.setCurrentSortingMethod("Subject Ascending");
    }

    /**
     * sort the emails by subject in descending order
     */
    public void sortBySubjectDescending(){
        emails.sort(Email.bySubjectDescending);
        this.setCurrentSortingMethod("Subject Descending");
    }

    /**
     * sort the emails by date in ascending order
     */
    public void sortByDateAscending(){
        emails.sort(Email.byDateAscending);
        this.setCurrentSortingMethod("Date Ascending");
    }

    /**
     * sort the emails by date in descending order
     */
    public void sortByDateDescending(){
        emails.sort(Email.byDateDescending);
        this.setCurrentSortingMethod("Date Descending");
    }

    /**
     * print out contents of the folder
     */
    public String toString(){
        System.out.println(this.getName());
        System.out.println(String.format("%-10s%5s%-10s", "Index | ", "Time", " | Subject"));
        System.out.println("-----------------------------------");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        for(int i = 0; i<emails.size(); i++){
            formatter.setCalendar(emails.get(i).getTimestamp());
            String dateFormatted = formatter.format(emails.get(i).getTimestamp().getTime());
            System.out.println(String.format("%-10d%5s%-10s", i+1, " | "+dateFormatted, " | "+emails.get(i).getSubject()));
        }
        return null;
    }

}
