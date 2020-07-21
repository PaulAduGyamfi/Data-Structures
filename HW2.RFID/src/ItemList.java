/**
 * This class represents a list which has items from the store
 *
 * @author Paul Adu-Gyamfi
 */
public class ItemList {
    private ItemInfoNode head;
    private ItemInfoNode tail;

    public ItemList(){
        this.head = null;
        this.tail = null;
    }

    /**
     *
     * @param name
     * ...name of the item to add to the list
     * @param rfidTag
     * ...rfid tag number of item to add to the list
     * @param price
     * ...cost of the item to add to the list
     * @param initPosition
     * ...the original position of item to add to list
     */
    public void insertInfo(String name, String rfidTag, double price, String initPosition){
        try {
            ItemInfoNode item = new ItemInfoNode();
            item.setInfo(new ItemInfo(name, rfidTag, price, initPosition));

            if(head == null){
                this.head = item;
                this.tail = item;
                item.setPrev(null);
                item.setNext(null);
                return;
            }

            if(this.head.getInfo().getRfidTagNumber().compareTo(rfidTag) > 0){
                item.setNext(this.head);
                this.head.setPrev(item);
                this.head = item;
                return;
            }

            ItemInfoNode pointer = this.head.getNext();
            while(pointer != null){
                if(pointer.getInfo().getRfidTagNumber().compareTo(rfidTag) > 0){
                    ItemInfoNode prev  = pointer.getPrev();
                    item.setNext(pointer);
                    item.setPrev(prev);
                    prev.setNext(item);
                    pointer.setPrev(item);
                    return;
                }
                pointer = pointer.getNext();
            }
            addEnd(item);
        }catch (InvalidRfid | InvalidShelfPosition invalidRfid) {
            invalidRfid.printStackTrace();
        }
        // Time Complexity: O(n), because worst case the list is not empty so we traverse it to find the correct location to put it
    }

    /**
     * remove all purchased items from the list
     */
    public void removeAllPurchased(){
        ItemList deleted = new ItemList();
        ItemInfoNode pointer = this.head;

        while(pointer != null){
            if(pointer.getInfo().getCurrent_position().equalsIgnoreCase("out")){
                deleted.insertInfo(pointer.getInfo().getName(), pointer.getInfo().getRfidTagNumber(), pointer.getInfo().getPrice(), pointer.getInfo().getOriginal_position());

                if(pointer.getPrev() == null){
                    removeFront(pointer);
                }
                else if(pointer.getNext() == null){
                    removeEnd(pointer);
                }
                else {
                    removeMiddle(pointer);
                }
            }
            pointer = pointer.getNext();
        }
        deleted.printAll();
        // Time Complexity: O(n), because we have to traverse the list to find all the nodes that have a current position of out
    }

    /**
     *
     * @param rfidTag
     * ...rfid tag number of the item to move
     * @param source
     * ...location of the item
     * @param dest
     * ...where it should be moved to
     * @return
     * ...true if it can be moved to destination otherwise false
     */
    public boolean moveItem(String rfidTag, String source, String dest){
        if(dest.equalsIgnoreCase("out")){
            return true;
        }

            ItemInfoNode pointer = this.head;
            while(pointer != null){
                if(pointer.getInfo().getRfidTagNumber().equals(rfidTag) && pointer.getInfo().getCurrent_position().equals(source) && !pointer.getInfo().getCurrent_position().equalsIgnoreCase("out")){
                    try {
                        pointer.getInfo().setCurrent_position(dest);
                    } catch (InvalidCurrentPosition invalidCurrentPosition) {
                        System.err.println("Sorry you can't put that there");
                    }
                    return true;
                }
                pointer = pointer.getNext();
            }


        return false;
         // Time Complexity: O(n), because we have to traverse the list to find the specific item
    }

    /**
     *
     * @param location
     * ...location to search and print items by
     */
    public void printByLocation(String location){
        ItemList location_list = new ItemList();
        ItemInfoNode pointer  = this.head;
        while(pointer != null){
            if(pointer.getInfo().getCurrent_position().equals(location)){
                location_list.insertInfo(pointer.getInfo().getName(), pointer.getInfo().getRfidTagNumber(), pointer.getInfo().getPrice(), pointer.getInfo().getOriginal_position());
                location_list.moveItem(pointer.getInfo().getRfidTagNumber(), pointer.getInfo().getOriginal_position(), pointer.getInfo().getCurrent_position());
            }
            pointer = pointer.getNext();
        }
        location_list.printAll();
        // Time Complexity: O(n), because we have to traverse the list to find the item with specified location
    }

    /**
     *
     * @param rfidtagnumber
     * ...rfid tag number to search and print items by
     */
    public void printByRfidTagNumber(String rfidtagnumber){
        ItemList rfidtagnumber_list = new ItemList();
        ItemInfoNode pointer  = this.head;
        while(pointer != null){
            if(pointer.getInfo().getRfidTagNumber().equals(rfidtagnumber)){
                rfidtagnumber_list.insertInfo(pointer.getInfo().getName(), pointer.getInfo().getRfidTagNumber(), pointer.getInfo().getPrice(), pointer.getInfo().getOriginal_position());
                rfidtagnumber_list.moveItem(pointer.getInfo().getRfidTagNumber(), pointer.getInfo().getOriginal_position(), pointer.getInfo().getCurrent_position());
            }
            pointer = pointer.getNext();
        }
        rfidtagnumber_list.printAll();
        // Time Complexity: O(n), because we have to traverse the list to find the item with specified rfid tag number
    }

    /**
     * put all items back in thir original position, only if is not already purchased
     */
    public void cleanStore(){

            ItemInfoNode pointer = this.head;
            ItemList back_to_original = new ItemList();
            while (pointer != null){
                if(!(pointer.getInfo().getOriginal_position().equals(pointer.getInfo().getCurrent_position())) && !(pointer.getInfo().getCurrent_position().equalsIgnoreCase("out"))){
                    back_to_original.insertInfo(pointer.getInfo().getName(),pointer.getInfo().getRfidTagNumber(), pointer.getInfo().getPrice(), pointer.getInfo().getCurrent_position());
                    try {
                        pointer.getInfo().setCurrent_position(pointer.getInfo().getOriginal_position());
                    } catch (InvalidCurrentPosition invalidCurrentPosition) {
                        invalidCurrentPosition.printStackTrace();
                    }
                }
                pointer = pointer.getNext();
            }
            back_to_original.printAll();
// Time Complexity: O(n), because we have to traverse the list to find all items not in their original location
    }

    /**
     *
     * @param cartNumber
     * ...cart to make purchase of items in
     * @return
     * ...total amount spent
     */
    public double checkOut(String cartNumber){
        double checkout_total = 0;
            ItemList purchased = new ItemList();
            ItemInfoNode pointer = this.head;


            while(pointer != null){
                if((pointer.getInfo().getCurrent_position().equals(cartNumber)) && !(pointer.getInfo().getCurrent_position().equalsIgnoreCase("out"))){
                    checkout_total += pointer.getInfo().getPrice();
                    purchased.insertInfo(pointer.getInfo().getName(), pointer.getInfo().getRfidTagNumber(), pointer.getInfo().getPrice(), pointer.getInfo().getOriginal_position());
                    purchased.moveItem(pointer.getInfo().getRfidTagNumber(), pointer.getInfo().getOriginal_position(), pointer.getInfo().getCurrent_position());

                    try {
                        pointer.getInfo().setCurrent_position("out");
                    } catch (InvalidCurrentPosition invalidCurrentPosition) {
                        System.err.println("Sorry you can't put that there");
                    }
                }
                pointer = pointer.getNext();
            }
            purchased.printAll();
            System.out.print("\nThe total cost for all merchandise in cart "+cartNumber+ " was $");
            System.out.printf("%.2f", checkout_total);
            System.out.println();

        return checkout_total;
        // Time Complexity: O(n), because we have to traverse the list to purchase all the items in the cart
    }


    /**
     *
     * @param node
     * ...item to add to the end of list
     */
    public void addEnd(ItemInfoNode node){
        this.tail.setNext(node);
        node.setPrev(this.tail);
        this.tail = node;
        // Time Complexity: O(1), because we have access tail and previous item
    }

    /**
     *
     * @param node
     * ...item to remove from front of list
     */
    public void removeFront(ItemInfoNode node){
        if(this.head.getNext() != null){
            this.head = node.getNext();
            this.head.setPrev(null);
        }else{
            this.head = this.tail = null;
        }
// Time Complexity: O(1), because we have access to head
    }

    /**
     *
     * @param node
     * ...item to remove from end of list
     */
    public void removeEnd(ItemInfoNode node){
        if(this.tail.getPrev() != null){
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
        }else{
            this.head = this.tail = null;
        }
        // Time Complexity: O(1), because we have access tail and previous item
    }

    /**
     *
     * @param node
     * ...item to remove from middle of list
     */
    public void removeMiddle(ItemInfoNode node){
        ItemInfoNode prev = node.getPrev();
        ItemInfoNode next = node.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        // Time Complexity: O(1), because we have access to previous item
    }

    /**
     * print all the items in list
     */
    public void printAll(){
        System.out.println(String.format("%-20s%-14s%-14s%-14s%10s", " ", " ", "Original", "Current", " "));
        System.out.println(String.format("%-20s%-14s%-14s%-14s%10s", "Item Name", "RFID", "Location", "Location", "Price"));
        System.out.println(String.format("%-20s%-14s%-14s%-14s%10s", "---------", "---------", "---------", "---------", "-------"));
        ItemInfoNode pointer = this.head;
        while(pointer != null){
            System.out.println(String.format("%-20s%-14s%-14s%-14s%10.2f", pointer.getInfo().getName(), pointer.getInfo().getRfidTagNumber(), pointer.getInfo().getOriginal_position(), pointer.getInfo().getCurrent_position(), pointer.getInfo().getPrice()));
            pointer = pointer.getNext();
        }
// Time Complexity: O(1), just printing
    }
}