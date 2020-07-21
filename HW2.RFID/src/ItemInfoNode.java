/**
 * This class represents a store item node it has the item's information and it contains the pointer of the next and previous item,
 *
 * @author Paul Adu-Gyamfi
 *
 */
public class ItemInfoNode {
    private ItemInfo item;
    private ItemInfoNode prev;
    private ItemInfoNode next;

    public ItemInfoNode(){
        this.item = null;
        this.prev = null;
        this.next = null;
    }

    /**
     *
     * @return
     * ...an item object
     */
    public ItemInfo getInfo(){
        return this.item;
    }

    /**
     *
     * @param info
     * ...set the item object's information
     */
    public void setInfo(ItemInfo info){
        this.item = info;
    }

    /**
     *
     * @param node
     * ...point to the next item in list
     */
    public void setNext(ItemInfoNode node){
        this.next = node;
    }

    /**
     *
     * @param node
     * ...point to the previous item in list
     */
    public void setPrev(ItemInfoNode node){
        this.prev = node;
    }

    /**
     *
     * @return
     * ...the next item in list
     */
    public ItemInfoNode getNext(){
        return this.next;
    }

    /**
     *
     * @return
     * ...the previous item in list
     */
    public ItemInfoNode getPrev(){
        return this.prev;
    }
}
