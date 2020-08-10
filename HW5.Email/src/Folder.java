import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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


    public ArrayList<Email> getEmails(){
        return this.emails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentSortingMethod() {
        return currentSortingMethod;
    }

    public void setCurrentSortingMethod(String currentSortingMethod) {
        this.currentSortingMethod = currentSortingMethod;
    }

    public void addEmail(Email email){
        emails.add(email);
    }

    public Email removeEmail(int index){
        Email saveDeleted = emails.get(index);
        emails.remove(index);
        return saveDeleted;
    }

    public void sortBySubjectAscending(){
        emails.sort(Email.bySubjectAscending);
        this.setCurrentSortingMethod("Subject Ascending");
    }

    public void sortBySubjectDescending(){
        emails.sort(Email.bySubjectDescending);
        this.setCurrentSortingMethod("Subject Descending");
    }

    public void sortByDateAscending(){
        emails.sort(Email.byDateAscending);
        this.setCurrentSortingMethod("Date Ascending");
    }

    public void sortByDateDescending(){
        emails.sort(Email.byDateDescending);
        this.setCurrentSortingMethod("Date Descending");
    }

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
