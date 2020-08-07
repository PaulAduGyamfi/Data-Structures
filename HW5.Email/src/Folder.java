import java.util.ArrayList;

public class Folder{
    private ArrayList<Email> emails;
    private String name;
    private String currentSortingMethod;

    public Folder(String name, String currentSortingMethod) {
        this.emails = emails = new ArrayList<>();
        this.name = name;
        this.currentSortingMethod = currentSortingMethod;
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
        int index = 0;
        while(index < emails.size()){
            if(emails.get(index).compareTo(emails.get(index + 1)) < 0){
                emails.add(index, email);
            }
            else if(emails.get(index).compareTo(emails.get(index + 1)) == 0){
                emails.add(index+1, email);
            }
            else{
                emails.add(email);
            }
        }
    }

}
