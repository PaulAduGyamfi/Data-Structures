import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TreeDriver {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println(("L - Load a Tree."));
        System.out.println(("H - Begin a Help Session."));
        System.out.println(("T - Traverse the Tree in preorder.."));
        System.out.println(("Q - Quit."));

        System.out.print("Choice>");
        char choice = in.next().charAt(0);

        Tree triTree;

        while (choice != 'Q'){

            switch (Character.toUpperCase(choice)){
                case 'L':
                    String label;
                    String message;
                    String prompt;
                    String numOfChildren;

                    System.out.println("Enter the file name>");
                    String file = in.nextLine();


                    try{

                        File txtFile = new File(file);

                        Scanner content = new Scanner(file);
                        if(content.hasNextLine()){
                            label = content.nextLine().trim();
                            message = content.nextLine().trim();
                            prompt = content.nextLine().trim();

                            TreeNode root  = new TreeNode();

                            root.setLabel(label);
                            root.setMessage(message);
                            root.setPrompt(prompt);

                            triTree = new Tree();
                        }
                        while(content.hasNextLine()){

                        }

                    }catch (Exception f){
                        System.out.println("File cannot be found!");
                    }


                    break;
                case 'H':

                    break;

                case 'T':

                    break;

                default:
                    break;
            }


        }

    }
}
