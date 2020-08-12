import jdk.nio.mapmode.ExtendedMapMode;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Paul Adu-Gyamfi
 *
 * paul.adu-gyamfi@stonybrook.edu
 *
 * CSE 214.R30
 * Juan Tarquino
 *
 *
 *
 * This class represents a Mailbox which holds folders of emails
 */

public class Mailbox extends ArrayList<Email>{
    private final Folder inbox = new Folder("Inbox");;
    private final Folder trash = new Folder("Trash");
    private ArrayList<Folder> folders;
    public static Mailbox mailbox;

    public Mailbox() throws ExisitngFolderException {
        this.folders = new ArrayList<>();
        folders.add(inbox);
        folders.add(trash);
    }

    /**
     *
     * @param folder
     * name of the new folder to create and add to mailbox
     * @throws ExisitngFolderException
     * if there is an existing folder in the mailbox with the sam name
     */
    public void addFolder(Folder folder) throws ExisitngFolderException{
        if(folders.size() > 0){
            for (Folder value : folders) {
                if (value.getName().equals(folder.getName())) {
                    throw new ExisitngFolderException();
                }
            }
        }
        folders.add(folder);
    }

    /**
     *
     * @param to
     * the recipient of the email
     * @param cc
     * the carbon copy recipients
     * @param bcc
     * the blind carbon copy recipients
     * @param subject
     * the subject of the email
     * @param body
     * the body of the email
     * @param timestamp
     * the date timestamp of the created email
     */
    public void composeEmail(String to, String cc, String bcc, String subject, String body, GregorianCalendar timestamp){
        Email composeEmail = new Email(to, cc, bcc, subject, body, timestamp);
        inbox.addEmail(composeEmail);
    }

    /**
     *
     * @param email
     * email to be moved to trash folder
     */
    public void deleteEmail(Email email){
        trash.addEmail(email);
    }

    /**
     *
     * @param name
     * name of folder to remove from the mailbox
     * @throws EmptyMailboxException
     * if folder does not exist
     */
    public void deleteFolder(String name) throws EmptyMailboxException{
        if(folders.size() > 0){
            folders.removeIf(value -> value.getName().equalsIgnoreCase(name));
        }else {
            throw new EmptyMailboxException();
        }
    }

    public static void main(String[] args) throws Exception {
        Mailbox mailbox = new Mailbox();
        Scanner in = new Scanner(System.in);


        System.out.println("Mailbox\n---------");
        for(Folder folder : mailbox.folders){
            System.out.println(folder.getName());
        }
        System.out.println("\nA – Add folder\nR – Remove folder\nC – Compose email\nF – Open folder\nI – Open Inbox\nT – Open Trash\nQ – Quit\n");
        System.out.print("Enter a user option: ");

        char menu_option = in.next().charAt(0);
        String sub_menu_option;
        Folder stepIntoFolder = null;

            while(menu_option != 'Q' && menu_option != 'q') {

                switch (Character.toUpperCase(menu_option)) {
                    case 'A':
                        try {
                            System.out.print("Enter folder name: ");
                            String folderName = in.next();

                            Folder createdFolder = new Folder(folderName);
                            mailbox.addFolder(createdFolder);

                            System.out.println("Mailbox\n---------");
                            for (Folder getFolders : mailbox.folders) {
                                System.out.print(getFolders.getName() + "\n");
                            }

                        } catch (ExisitngFolderException e) {
                            System.out.println("There is an existing folder with that name!");
                        }
                        break;
                    case 'R':
                        boolean canDelete = false;
                        System.out.print("Enter name of the folder to delete: ");
                        String deleteFolder = in.next();

                        try {
                            for (Folder folder : mailbox.folders) {
                                if (folder.getName().equalsIgnoreCase(deleteFolder) && !(folder.getName().equals("Inbox")) && !(folder.getName().equals("Trash"))) {
                                    canDelete = true;
                                }
                                if(folder.getName().equals("Inbox") || folder.getName().equals("Trash")){
                                    System.out.println("Cannot delete this folder");
                                    break;
                                }
                            }
                            if (canDelete) {
                                mailbox.deleteFolder(deleteFolder);
                                System.out.println(deleteFolder + " was successfully deleted");
                                System.out.println("Mailbox\n---------");
                                for (Folder getFolders : mailbox.folders) {
                                    System.out.print(getFolders.getName() + "\n");
                                }
                                break;
                            } else if (!deleteFolder.equals("Inbox") && !deleteFolder.equals("Trash")){
                                System.out.println("Folder does not exist");
                            }
                        } catch (EmptyMailboxException ex) {
                            System.out.println("Folder does not exist");
                        }
                        break;
                    case 'C':
                        try {
                            System.out.print("Enter recipient (To): ");
                            in.nextLine();
                            String to = in.nextLine();

                            if(!to.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")){
                                System.out.println("Not a valid email address");
                                break;
                            }

                            System.out.print("Enter carbon copy recipients (CC): ");
                            String cc = in.nextLine();

                            System.out.print("Enter blind carbon copy recipients (BCC): ");
                            String bcc = in.nextLine();

                            System.out.print("Enter subject line: ");
                            String subject = in.nextLine();

                            System.out.print("Enter body: ");
                            in.nextLine();
                            String body = in.nextLine();


                            GregorianCalendar timestamp = new GregorianCalendar();

                            mailbox.composeEmail(to, cc, bcc, subject, body, timestamp);

                            System.out.println("Email successfully added to Inbox");

                            System.out.println("Mailbox\n---------");
                            for (Folder getFolders : mailbox.folders) {
                                System.out.print(getFolders.getName() + "\n");
                            }
                            break;

                        } catch (Exception ex) {
                            System.out.println("Couldn't compose the email, try again.");
                        }
                        break;
                    case 'F':
                        boolean found = false;
                        System.out.print("Enter folder name: ");
                        String enterFolder = in.next();


                        if (mailbox.folders.size() > 0) {
                            for (int i = 0; i < mailbox.folders.size(); i++) {
                                if (enterFolder.equals(mailbox.folders.get(i).getName())) {
                                    found = true;
                                    stepIntoFolder = mailbox.folders.get(i);
                                    stepIntoFolder.toString();
                                }
                            }
                        }
                        if (!found) {
                            throw new Exception("Folder does not exist");
                        }


                        System.out.println("M – Move email\nD – Delete email\nV – View email contents\nSA – Sort by subject line in ascending order\nSD – Sort by subject line in descending order\nDA – Sort by date in ascending order\nDD – Sort by date in descending order\nR – Return to mailbox");

                        System.out.print("Enter a user option: ");
                        sub_menu_option = in.next();

                        while (!sub_menu_option.equals("R")) {
                            switch (sub_menu_option.toUpperCase()) {
                                case "M":
                                    System.out.print("Enter the index of the email to move: ");
                                    int index = in.nextInt();

                                    System.out.println("Folders");
                                    for (Folder getFolders : mailbox.folders) {
                                        System.out.print(getFolders.getName() + "\n");
                                    }

                                    System.out.print("Select a folder to move “Testing” to: ");
                                    String newFolder = in.nextLine();

                                    for(int i = 0; i < mailbox.folders.size(); i++){
                                        if(newFolder.equalsIgnoreCase(mailbox.folders.get(i).getName())){
                                            mailbox.folders.get(i).addEmail(stepIntoFolder.removeEmail(index-1));
                                            System.out.println("“Testing” successfully moved to "+mailbox.folders.get(i).getName());
                                        }
                                    }
                                    break;
                                case "D":
                                    System.out.print("Enter email index: ");
                                    int folderIndex = in.nextInt();
                                    try {
                                        Email deletedEmail = stepIntoFolder.removeEmail(folderIndex);
                                        mailbox.deleteEmail(deletedEmail);
                                    } catch (Exception ex) {
                                        System.out.println("File does not exist");
                                    }
                                    break;
                                case "V":
                                    System.out.println("Enter email index: ");
                                    index = in.nextInt();
                                    stepIntoFolder.getEmails().get(index-1).displayEmailContent();

                                    System.out.println(stepIntoFolder.getName());
                                    System.out.println(String.format("%-10s%5s%-10s", "Index | ", "Time", " | Subject"));
                                    System.out.println("-----------------------------------");
                                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

                                    formatter.setCalendar(stepIntoFolder.getEmails().get(index-1).getTimestamp());
                                    String dateFormatted = formatter.format(stepIntoFolder.getEmails().get(index-1).getTimestamp().getTime());
                                    System.out.println(String.format("%-10d%5s%-10s", index, " | "+dateFormatted, " | "+stepIntoFolder.getEmails().get(index-1).getSubject()));
                                    break;
                                case "SA":
                                    stepIntoFolder.sortBySubjectAscending();
                                    stepIntoFolder.toString();
                                    break;
                                case "SD":
                                    stepIntoFolder.sortByDateDescending();
                                    stepIntoFolder.toString();
                                    break;
                                case "DA":
                                    stepIntoFolder.sortByDateAscending();
                                    stepIntoFolder.toString();
                                    break;
                                case "DD":
                                    stepIntoFolder.sortByDateDescending();
                                    stepIntoFolder.toString();
                                    break;
                            }
                            System.out.println("M – Move email\nD – Delete email\nV – View email contents\nSA – Sort by subject line in ascending order\nSD – Sort by subject line in descending order\nDA – Sort by date in ascending order\nDD – Sort by date in descending order\nR – Return to mailbox");
                            System.out.print("Enter a user option: ");
                            sub_menu_option = in.next();
                        }
                        break;
                    case 'I':
                        mailbox.inbox.toString();
                        System.out.println("M – Move email\nD – Delete email\nV – View email contents\nSA – Sort by subject line in ascending order\nSD – Sort by subject line in descending order\nDA – Sort by date in ascending order\nDD – Sort by date in descending order\nR – Return to mailbox");

                        System.out.print("Enter a user option: ");
                        sub_menu_option = in.next();

                        while (!sub_menu_option.equals("R")) {
                            switch (sub_menu_option.toUpperCase()) {
                                case "M":
                                    System.out.print("Enter the index of the email to move: ");
                                    int index = in.nextInt();

                                    System.out.println("Folders");
                                    for (Folder getFolders : mailbox.folders) {
                                        System.out.print(getFolders.getName() + "\n");
                                    }

                                    System.out.print("Select a folder to move “Testing” to: ");
                                    String newFolder = in.nextLine();

                                    for(int i = 0; i < mailbox.folders.size(); i++){
                                        if(newFolder.equalsIgnoreCase(mailbox.folders.get(i).getName())){
                                            mailbox.folders.get(i).addEmail(mailbox.inbox.removeEmail(index-1));
                                            System.out.println("“Testing” successfully moved to "+ mailbox.folders.get(i).getName());
                                        }
                                    }
                                    in.nextLine();

                                    break;
                                case "D":
                                    System.out.print("Enter email index: ");
                                    int folderIndex = in.nextInt();
                                    try {
                                        Email deletedEmail = stepIntoFolder.removeEmail(0);
                                        mailbox.deleteEmail(deletedEmail);
                                    } catch (Exception ex) {
                                        System.out.println("File does not exist");
                                    }
                                    break;
                                case "V":
                                    System.out.println("Enter email index: ");
                                    index = in.nextInt();
                                    mailbox.inbox.getEmails().get(index-1).displayEmailContent();

                                    System.out.println(mailbox.inbox.getName());
                                    System.out.println(String.format("%-10s%5s%-10s", "Index | ", "Time", " | Subject"));
                                    System.out.println("-----------------------------------");
                                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

                                    formatter.setCalendar(mailbox.inbox.getEmails().get(index-1).getTimestamp());
                                    String dateFormatted = formatter.format(mailbox.inbox.getEmails().get(index-1).getTimestamp().getTime());
                                    System.out.println(String.format("%-10d%5s%-10s", index, " | "+dateFormatted, " | "+mailbox.inbox.getEmails().get(index-1).getSubject()));
                                    break;
                                case "SA":
                                    mailbox.inbox.sortBySubjectAscending();
                                    mailbox.inbox.toString();
                                    break;
                                case "SD":
                                    mailbox.inbox.sortByDateDescending();
                                    mailbox.inbox.toString();
                                    break;
                                case "DA":
                                    mailbox.inbox.sortByDateAscending();
                                    mailbox.inbox.toString();
                                    break;
                                case "DD":
                                    mailbox.inbox.sortByDateDescending();
                                    mailbox.inbox.toString();
                                    break;
                            }
                            System.out.println("\nM – Move email\nD – Delete email\nV – View email contents\nSA – Sort by subject line in ascending order\nSD – Sort by subject line in descending order\nDA – Sort by date in ascending order\nDD – Sort by date in descending order\nR – Return to mailbox");
                            System.out.print("Enter a user option: ");
                            sub_menu_option = in.next();
                        }
                        break;
                    case 'T':
                        mailbox.trash.toString();
                        System.out.println("M – Move email\nD – Delete email\nV – View email contents\nSA – Sort by subject line in ascending order\nSD – Sort by subject line in descending order\nDA – Sort by date in ascending order\nDD – Sort by date in descending order\nR – Return to mailbox");

                        sub_menu_option = in.next();

                        while (!sub_menu_option.equals("R")) {
                            switch (sub_menu_option.toUpperCase()) {
                                case "M":
                                    System.out.print("Enter the index of the email to move: ");
                                    int index = in.nextInt();

                                    System.out.println("Folders");
                                    for (Folder getFolders : mailbox.folders) {
                                        System.out.print(getFolders.getName() + "\n");
                                    }

                                    System.out.print("Select a folder to move “Testing” to: ");
                                    String newFolder = in.nextLine();


                                    for(int i = 0; i < mailbox.folders.size(); i++){
                                        if(newFolder.equalsIgnoreCase(mailbox.folders.get(i).getName())){
                                            mailbox.folders.get(i).addEmail(mailbox.trash.removeEmail(index-1));
                                            System.out.println("“Testing” successfully moved to "+ mailbox.folders.get(i).getName());
                                        }
                                    }

                                    break;
                                case "D":
                                    System.out.print("Enter email index: ");
                                    int folderIndex = in.nextInt();
                                    try {
                                        Email deletedEmail = stepIntoFolder.removeEmail(1);
                                        mailbox.deleteEmail(deletedEmail);
                                    } catch (Exception ex) {
                                        System.out.println("File does not exist");
                                    }
                                    break;
                                case "V":
                                    System.out.println("Enter email index: ");
                                     index = in.nextInt();
                                     mailbox.trash.getEmails().get(index-1).displayEmailContent();

                                    System.out.println(mailbox.trash.getName());
                                    System.out.println(String.format("%-10s%5s%-10s", "Index | ", "Time", " | Subject"));
                                    System.out.println("-----------------------------------");
                                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

                                        formatter.setCalendar(mailbox.trash.getEmails().get(index-1).getTimestamp());
                                        String dateFormatted = formatter.format(mailbox.trash.getEmails().get(index-1).getTimestamp().getTime());
                                        System.out.println(String.format("%-10d%5s%-10s", index, " | "+dateFormatted, " | "+mailbox.trash.getEmails().get(index-1).getSubject()));
                                    break;
                                case "SA":
                                    mailbox.trash.sortBySubjectAscending();
                                    mailbox.trash.toString();
                                    break;
                                case "SD":
                                    mailbox.trash.sortBySubjectDescending();
                                    mailbox.trash.toString();
                                    break;
                                case "DA":
                                    mailbox.trash.sortByDateAscending();
                                    mailbox.trash.toString();
                                    break;
                                case "DD":
                                    mailbox.trash.sortByDateDescending();
                                    mailbox.trash.toString();
                                    break;
                            }
                            System.out.println("M – Move email\nD – Delete email\nV – View email contents\nSA – Sort by subject line in ascending order\nSD – Sort by subject line in descending order\nDA – Sort by date in ascending order\nDD – Sort by date in descending order\nR – Return to mailbox");
                            System.out.print("Enter a user option: ");
                            sub_menu_option = in.next();
                        }
                        break;

                    default:
                        break;
                }
                        System.out.println("\nA – Add folder\nR – Remove folder\nC – Compose email\nF – Open folder\nI – Open Inbox\nT – Open Trash\nQ – Quit\n");
                        System.out.print("Enter a user option: ");
                        menu_option = in.next().charAt(0);


            }
        System.out.println("Program successfully exited and mailbox saved.");

    }
}
