import java.util.ArrayList;
import java.util.Scanner;
public class Mailbox {
    private Folder inbox;
    private Folder trash;
    private ArrayList<Folder> folders;
    public static Mailbox mailbox;

    public Mailbox() throws ExisitngFolderException {
        this.folders = new ArrayList<>();
        addFolder(inbox);
        addFolder(trash);
    }

    public void addFolder(Folder folder) throws ExisitngFolderException{
        for(Folder existingFolder : folders){
            if(folder.getName().equals(existingFolder.getName())){
                throw new ExisitngFolderException();
            }
            folders.add(folder);
        }
    }

    public static void main(String[] args) throws ExisitngFolderException {
        Mailbox mailbox = new Mailbox();
        Scanner in = new Scanner(System.in);

        System.out.println("Mailbox\n--------\nInbox\nTrash\n");
        System.out.println("A – Add folder\nR – Remove folder\nC – Compose email\nF – Open folder\nI – Open Inbox\nT – Open Trash\nQ – Quit\n");
        System.out.print("Enter a user option: ");

        char menu_option = in.next().charAt(0);

        while(menu_option != 'Q' && menu_option != 'q'){
            switch (Character.toUpperCase(menu_option)){
                case 'A':
                    try{
                        Folder createdFolder = new Folder("Archive","ascending");
                        mailbox.addFolder(createdFolder);

                    }catch (ExisitngFolderException e){
                        System.out.println("There is an existing folder with that name!");
                    }
//                    System.out.println("Mailbox\n--------\nInbox\nTrash\n");
                    for(Folder getFolders : mailbox.folders){
                        System.out.println(getFolders.getName()+"\n");
                    }
                    break;
            }
        }
    }
}
