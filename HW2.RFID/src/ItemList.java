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
    }

    public void removeAllPurchased(){
//        if(this.head.getInfo().getCurrent_position().equalsIgnoreCase("out")){
//            this.head = this.head.getNext();
//            this.head.setPrev(null);
//        }
//        if(this.tail.getInfo().getCurrent_position().equalsIgnoreCase("out")){
//            this.tail = this.tail.getPrev();
//            this.tail.setNext(null);
//        }
//        ItemInfoNode pointer = this.head;
//        while(pointer != null){
//            if(!pointer.getInfo().getCurrent_position().equalsIgnoreCase("out")){
//                pointer = pointer.getNext();
//            }else {
//                ItemInfoNode prev = pointer.getPrev();
//                prev.setNext(pointer.getNext());
//                prev.getNext().setPrev(prev);
//                pointer = prev.getNext();
//            }
//        }


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
