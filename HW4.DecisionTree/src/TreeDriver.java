import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Paul Adu-Gyamfi
 * #111607347
 * paul.adu-gyamfi@stonybrook.edu
 *
 * CSE 214.R30
 * Juan Tarquino
 */
public class TreeDriver {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println(("L - Load a Tree."));
        System.out.println(("H - Begin a Help Session."));
        System.out.println(("T - Traverse the Tree in preorder.."));
        System.out.println(("Q - Quit."));

        System.out.print("Choice>");
        char choice = in.next().charAt(0);

        Tree triTree = new Tree();
        boolean treeLoad = false;

        while (choice != 'Q'){

            switch (Character.toUpperCase(choice)){
                case 'L':
                    String label;
                    String message;
                    String prompt;
                    String numOfChildren;
                    String parent;

                    System.out.print("Enter the file name>");
                    in.nextLine();
                    String filename = in.nextLine();


                    try{

                        File txtFile = new File(filename);

                        Scanner content = new Scanner(txtFile);

                        if(content.hasNextLine()){
                            label = content.nextLine();
                            message = content.nextLine();
                            prompt = content.nextLine();

                            triTree.getRoot().setLabel(label);
                            triTree.getRoot().setMessage(message);
                            triTree.getRoot().setPrompt(prompt);

                            label = content.nextLine();
                            message = content.nextLine();
                            prompt = content.nextLine();
                            TreeNode left = new TreeNode(label,message,prompt);
                            triTree.getRoot().setLeft(left);


                            label = content.nextLine();
                            message = content.nextLine();
                            prompt = content.nextLine();
                            TreeNode middle = new TreeNode(label,message,prompt);
                            triTree.getRoot().setMiddle(middle);

                            label = content.nextLine();
                            message = content.nextLine();
                            prompt = content.nextLine();
                            TreeNode right = new TreeNode(label,message,prompt);
                            triTree.getRoot().setRight(right);

                            treeLoad = true;
                        }
//                        while(content.hasNextLine()){
//                            parent = content.nextLine();
//                            numOfChildren = content.nextLine().trim();
//                            int children = Integer.parseInt(numOfChildren);
//                            for(int i = 1; i<=children; i++){
//                                label= content.nextLine();
//                                message= content.nextLine();
//                                prompt = content.nextLine();
//                                triTree.addNode(label,prompt,message,parent);
//                            }
//                        }

                        content.close();

                    }catch (Exception f){
                        System.out.println("File cannot be found!");
                    }
                    break;
                case 'H':
                    System.out.println("Help Session Starting...");
                    System.out.println("What Model is the Washing Machine?");
                    System.out.println("1 Machine won't start.\n" +
                            "2 Machine ends too early.\n" +
                            "3 Machine knobs are broken.\n" +
                            "0 Exit Session.");
                    System.out.print("Choice> ");
                    int model = in.nextInt();

                    TreeNode node;
                    switch (model){
                        case 1:
                            node = triTree.getRoot().getLeft();
                            System.out.println(node.getLabel());
                            break;
                        case 2:
                            node = triTree.getRoot().getMiddle();
                            System.out.println(node.getLabel());
                            break;
                        case 3:
                            node = triTree.getRoot().getRight();
                            System.out.println(node.getLabel());
                            break;
                        default:
                            break;
                    }
                    break;

                case 'T':
                    if(treeLoad){
                        triTree.preOrder();
                    }else{
                        System.out.println("You must first load a tree!");
                    }
                    break;

                default:
                    break;
            }

            System.out.println(("L - Load a Tree."));
            System.out.println(("H - Begin a Help Session."));
            System.out.println(("T - Traverse the Tree in preorder.."));
            System.out.println(("Q - Quit."));

            System.out.print("Choice>");
            choice = in.next().charAt(0);

        }

    }
}
