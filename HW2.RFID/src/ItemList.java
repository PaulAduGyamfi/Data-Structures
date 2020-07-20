public class ItemList {
    private ItemInfoNode head;
    private ItemInfoNode tail;

    public ItemList(){
        this.head = null;
        this.tail = null;
    }

    public void insertInfo(String name, String rfidTag, double price, String initPosition){
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
    }

    public void removeAllPurchased(){
        if(this.head.getInfo().getCurrent_position().equalsIgnoreCase("out")){
            this.head = this.head.getNext();
            this.head.setPrev(null);
        }
        if(this.tail.getInfo().getCurrent_position().equalsIgnoreCase("out")){
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
        }
        ItemInfoNode pointer = this.head;
        while(pointer != null){
            if(!pointer.getInfo().getCurrent_position().equalsIgnoreCase("out")){
                pointer = pointer.getNext();
            }else {
                ItemInfoNode prev = pointer.getPrev();
                prev.setNext(pointer.getNext());
                prev.getNext().setPrev(prev);
                pointer = prev.getNext();
            }
        }


    }

    public boolean moveItem(String rfidTag, String source, String dest){
        if(dest.equalsIgnoreCase("out")){
            return true;
        }
        ItemInfoNode pointer = this.head;
        while(pointer != null){
            if(pointer.getInfo().getRfidTagNumber().equals(rfidTag) && pointer.getInfo().getCurrent_position().equals(source) && !pointer.getInfo().getCurrent_position().equalsIgnoreCase("out")){
                pointer.getInfo().setCurrent_position(dest);
                return true;
            }
            pointer = pointer.getNext();
        }

        return false;
    }

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
    }

    public void cleanStore(){
        ItemInfoNode pointer = this.head;
        ItemList back_to_original = new ItemList();
        while (pointer != null){
            if(!pointer.getInfo().getOriginal_position().equals(pointer.getInfo().getCurrent_position())){
                back_to_original.insertInfo(pointer.getInfo().getName(),pointer.getInfo().getRfidTagNumber(), pointer.getInfo().getPrice(), pointer.getInfo().getCurrent_position());
                pointer.getInfo().setCurrent_position(pointer.getInfo().getOriginal_position());
            }
            pointer = pointer.getNext();
        }
        back_to_original.printAll();
    }

    public double checkOut(String cartNumber){
        ItemList purchased = new ItemList();
        ItemInfoNode pointer = this.head;
        double checkout_total = 0;

        while(pointer != null){
            if(pointer.getInfo().getCurrent_position().equals(cartNumber)){
                checkout_total += pointer.getInfo().getPrice();
                purchased.insertInfo(pointer.getInfo().getName(), pointer.getInfo().getRfidTagNumber(), pointer.getInfo().getPrice(), pointer.getInfo().getOriginal_position());
                purchased.moveItem(pointer.getInfo().getRfidTagNumber(), pointer.getInfo().getOriginal_position(), pointer.getInfo().getCurrent_position());

                pointer.getInfo().setCurrent_position("out");
            }
            pointer = pointer.getNext();
        }
        purchased.printAll();
        System.out.print("\nThe total cost for all merchandise in cart "+cartNumber+ " was $");
        System.out.printf("%.2f", checkout_total);
        System.out.println();
        return checkout_total;
    }



    public boolean findRFID(String id){
        ItemInfoNode pointer = this.head;
        boolean is_in_the_list = false;
        while(pointer != null){
            if(pointer.getInfo().getRfidTagNumber().equals(id)){
                is_in_the_list = true;
                break;
            }
            pointer = pointer.getNext();
        }

        return is_in_the_list;
    }

    public void addEnd(ItemInfoNode node){
        this.tail.setNext(node);
        node.setPrev(this.tail);
        this.tail = node;
    }

    public void printAll(){
        System.out.println(String.format("%-20s%-14s%-14s%-14s%10s", " ", " ", "Original", "Current", " "));
        System.out.println(String.format("%-20s%-14s%-14s%-14s%10s", "Item Name", "RFID", "Location", "Location", "Price"));
        System.out.println(String.format("%-20s%-14s%-14s%-14s%10s", "---------", "---------", "---------", "---------", "-------"));
        ItemInfoNode pointer = this.head;
        while(pointer != null){
            System.out.println(String.format("%-20s%-14s%-14s%-14s%10.2f", pointer.getInfo().getName(), pointer.getInfo().getRfidTagNumber(), pointer.getInfo().getOriginal_position(), pointer.getInfo().getCurrent_position(), pointer.getInfo().getPrice()));
            pointer = pointer.getNext();
        }

    }
}










/*

if(head == null){
            this.head = item;
            this.tail = item;
            item.setPrev(null);
            item.setNext(null);
            return;
        }
        if(findRFID(rfidTag)){
            if(this.tail.getInfo().getRfidTagNumber().equals(rfidTag)){
                addEnd(item);
                return;
            }
            ItemInfoNode pointer = this.head;
            while (pointer != null){
                if(pointer.getInfo().getRfidTagNumber().equals(rfidTag)){
                    break;
                }
                pointer = pointer.getNext();
            }
            ItemInfoNode next = pointer.getNext();
            item.setNext(next);
            item.setPrev(pointer);
            next.setPrev(item);
            pointer.setNext(item);
            return;
        }
       addEnd(item);
 */