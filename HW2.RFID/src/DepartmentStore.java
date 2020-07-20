import java.util.Scanner;
public class DepartmentStore {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ItemList inventory = new ItemList();

        System.out.println("Welcome!");

        System.out.println(("C - Clean store"));
        System.out.println(("I - Insert an item into the list"));
        System.out.println(("L - List by location"));
        System.out.println(("M - Move an item in the store"));
        System.out.println(("O - Checkout"));
        System.out.println(("P - Print all items in store"));
        System.out.println(("R - Print by RFID tag number"));
        System.out.println(("U - Update inventory system"));
        System.out.println(("Q - Exit the program.\n"));

        System.out.print("Please select an option: ");
        char menu_option = in.next().charAt(0);

        while(menu_option != 'Q'){

            String name, rfid, original_location, current_location, cart;
            double price;

            switch (Character.toUpperCase(menu_option)){
                case 'C':
                    System.out.println("The following item(s) have been moved back to their original locations:");
                    inventory.cleanStore();
                    break;
                case 'I':
                    System.out.print("Enter the name: ");
                    in.nextLine();
                    name = in.nextLine();
                    System.out.print("Enter the RFID: ");
                    rfid = in.nextLine();
                    System.out.print("Enter the original location: ");
                    original_location = in.nextLine();
                    System.out.print("Enter the price: ");
                    price = in.nextDouble();

                    try{
                        ItemInfo info  = new ItemInfo(name,rfid,price,original_location);
                        ItemInfoNode item = new ItemInfoNode();
                        item.setInfo(info);
                        inventory.insertInfo(item.getInfo().getName(), item.getInfo().getRfidTagNumber(), item.getInfo().getPrice(), item.getInfo().getOriginal_position());
                    }catch (InvalidRfid invalidRfid){
                        System.out.println("\nInvalid RfidTag Number");
                    }catch (InvalidShelfPosition invalidShelfPosition){
                        System.out.println("\nInvalid Shelf Position");
                    }
                    break;
                case 'L':
                    System.out.print("Enter the location: ");
                    current_location = in.next();

                    try {
                        inventory.printByLocation(current_location);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'M':
                    System.out.print("Enter the RFID: ");
                    in.nextLine();
                    rfid = in.nextLine();
                    System.out.print("Enter the original location: ");
                    original_location = in.nextLine();
                    System.out.print("Enter the new location: ");
                    current_location = in.nextLine();

                    inventory.moveItem(rfid,original_location,current_location);
                    break;
                case 'O':
                    System.out.print("Enter the cart number: ");
                    cart = in.next();

                    try {
                        inventory.checkOut(cart);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'P':
                    inventory.printAll();
                    break;
                case 'R':
                    break;
                case 'U':
                    inventory.removeAllPurchased();
                    break;
                default:
                    break;
            }

            System.out.println(("\nC - Clean store"));
            System.out.println(("I - Insert an item into the list"));
            System.out.println(("L - List by location"));
            System.out.println(("M - Move an item in the store"));
            System.out.println(("O - Checkout"));
            System.out.println(("P - Print all items in store"));
            System.out.println(("R - Print by RFID tag number"));
            System.out.println(("U - Update inventory system"));
            System.out.println(("Q - Exit the program.\n"));

            System.out.print("Please select an option: ");
            menu_option = in.next().charAt(0);
        }
        System.out.println("Goodbye!");
    }
}

























/*



ItemInfo i = new ItemInfo("Dress Shirt","00A5532FF",10.00, "s12345");
        ItemInfoNode node = new ItemInfoNode();
        node.setInfo(i);
        node.getInfo().setCurrent_position("c154");

        ItemInfo i1 = new ItemInfo("Ksubi Jeans","048HH2FFF",30.00, "s13345");
        ItemInfoNode node1 = new ItemInfoNode();
        node1.setInfo(i1);


        ItemInfo i2 = new ItemInfo("Richard Mille","348LL2SDF",205.00, "s02335");
        ItemInfoNode node2 = new ItemInfoNode();
        node2.setInfo(i2);

        ItemInfo i3 = new ItemInfo("Rolex","9I8XX2SDC",100.00, "s00001");
        ItemInfoNode node3 = new ItemInfoNode();
        node3.setInfo(i3);
//        System.out.println(node.getInfo().getRfidTagNumber());
        ItemList list = new ItemList();
        list.insertInfo(node2.getInfo().getName(),node2.getInfo().getRfidTagNumber(),node2.getInfo().getPrice(),node2.getInfo().getOriginal_position());
        list.insertInfo(node3.getInfo().getName(),node3.getInfo().getRfidTagNumber(),node3.getInfo().getPrice(),node3.getInfo().getOriginal_position());
        list.insertInfo(node.getInfo().getName(),node.getInfo().getRfidTagNumber(),node.getInfo().getPrice(),node.getInfo().getOriginal_position());
        list.insertInfo(node.getInfo().getName(),node.getInfo().getRfidTagNumber(),node.getInfo().getPrice(),node.getInfo().getOriginal_position());
        list.insertInfo(node.getInfo().getName(),node.getInfo().getRfidTagNumber(),node.getInfo().getPrice(),node.getInfo().getOriginal_position());
        list.insertInfo(node1.getInfo().getName(),node1.getInfo().getRfidTagNumber(),node1.getInfo().getPrice(),node1.getInfo().getOriginal_position());
        list.insertInfo(node1.getInfo().getName(),node1.getInfo().getRfidTagNumber(),node1.getInfo().getPrice(),node1.getInfo().getOriginal_position());
        list.moveItem("00A5532FF", "s12345", "c202");
        list.moveItem("00A5532FF", "s12345", "s10000");
//        list.cleanStore();
        list.checkOut("c202");
        list.removeAllPurchased();
        list.printAll();
//       System.out.println("---------");
//        list.printByLocation("c202");



 */