public class ItemInfoNode {
    private ItemInfo item;
    private ItemInfoNode prev;
    private ItemInfoNode next;

    public ItemInfoNode(){
        this.item = null;
        this.prev = null;
        this.next = null;
    }


    public ItemInfo getInfo(){
        return this.item;
    }
    public void setInfo(ItemInfo info){
        this.item = info;
    }


    public void setNext(ItemInfoNode node){
        this.next = node;
    }
    public void setPrev(ItemInfoNode node){
        this.prev = node;
    }


    public ItemInfoNode getNext(){
        return this.next;
    }
    public ItemInfoNode getPrev(){
        return this.prev;
    }
}
