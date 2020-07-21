/**
 * This class represents the info about a store item,  the name of the item, the item's rfitag number, item's price,original position and current position
 *
 * @author Paul Adu-Gyamfi
 *
 */
public class ItemInfo {
    private String name;
    private double price;
    private String rfidTagNumber;
    private String original_position;
    private String current_position;

    /**
     *
     * @param name
     * ...name of the item
     * @param rfidTagNumber
     * ...the item's rfidtag number, which has a string length of 9 and numbers 0-9 or A-F
     * @param price
     * ...price of the item
     * @param original_position
     * ...position of the item either on shelf starts with s followed by 5 numbers, or in a cart starts with a c followed by 3 numbers, our it has been purchased
     * @throws InvalidRfid
     * ...if the rfitag number doesn't meet the specified format
     * @throws InvalidShelfPosition
     * ...if the position of the item doesn't meet the specified format
     */
    public ItemInfo(String name, String rfidTagNumber, double price, String original_position) throws InvalidRfid, InvalidShelfPosition {
        this.name = name;
        if(isAHexadecimal(rfidTagNumber)){
            this.rfidTagNumber = rfidTagNumber;
        }else{
            throw new InvalidRfid();
        }
        this.price = price;
        if (validShelfPosition(original_position)){
            this.original_position = original_position;
        }else {
            throw new InvalidShelfPosition();
        }
        this.current_position = original_position;
    }

    /**
     *
     * @return
     * ...the item's name
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @param name
     * sets the item's name
     */
    public void setName(String name){
        this.name = name;
    }


    /**
     *
     * @return
     * ...the item's price
     */
    public double getPrice(){
        return this.price;
    }

    /**
     *
     * @param price
     * ...sets the price of the item
     */
    public void setPrice(double price){
        this.price = price;
    }

    /**
     *
     * @return
     * ...the rfid tag number an item
     */
    public String getRfidTagNumber(){
        return this.rfidTagNumber;
    }

    /**
     *
     * @param rfidTagNumber
     * ...sets the rfid tag number of an item
     */
    public void setRfidTagNumber(String rfidTagNumber){
        this.rfidTagNumber = rfidTagNumber;
    }

    /**
     *
     * @return
     * ...the inital position an item
     */
    public String getOriginal_position(){
        return this.original_position;
    }

    /**
     *
     * @param original_position
     * ...sets the original position of an item
     */
    public void setOriginal_position(String original_position){
        this.original_position = original_position;
        this.current_position = original_position;
    }

    /**
     *
     * @return
     * ...the most up to date position of an item
     */
    public String getCurrent_position(){
        return this.current_position;
    }

    /**
     *
     * @param current_position
     * ...change the position of an item
     * @throws InvalidCurrentPosition
     * ...if it is placed in an invalid position
     */
    public void setCurrent_position(String current_position) throws InvalidCurrentPosition {
        if(validShelfPosition(current_position)){
            this.current_position = current_position;
        }
        else if(validCart(current_position)){
            this.current_position = current_position;
        }
        else if(current_position.equalsIgnoreCase("out")){
            this.current_position = current_position;
        }
        else {
            throw new InvalidCurrentPosition();
        }
    }

    /**
     *
     * @param rfidTagNumber
     * ...an items rfid tag number
     * @return
     * ...true if it is a valid rfid tag number otherwise false
     */
    public static boolean isAHexadecimal(String rfidTagNumber){
        boolean result = false;
        if(rfidTagNumber.length() != 9){
            return false;
        }
        for(int i = 0; i<rfidTagNumber.length(); i++){
            char c = rfidTagNumber.charAt(i);
            if(Character.isDigit(c)){
               if(47 < (int)c && (int)c < 58){
                   result = true;
               }else {
                   return false;
               }
            }
            else if(Character.isLetter(c)){
                if(64 < (int)Character.toUpperCase(c) && (int)Character.toUpperCase(c) < 71){
                    result = true;
                }else {
                    return false;
                }
            }
        }
        return result;
    }

    /**
     *
     * @param original_position
     * ...the position to place item
     * @return
     * ...true if it is a valid position otherwise false
     */
    public boolean validShelfPosition(String original_position){
        boolean result = false;

        if(original_position.length() != 6){
            return false;
        }
        if((int)Character.toUpperCase(original_position.charAt(0)) != 83){
            return false;
        }

        for (int i = 1; i < original_position.length(); i++){
            char c = original_position.charAt(i);
            if(Character.isDigit(c)){
                result = true;
            }else{
                return false;
            }
        }

        return result;
    }

    /**
     *
     * @param cart
     * ...a cart to place items in
     * @return
     * ...true if it is a valid cart otherwise false
     */
    public boolean validCart(String cart){
        boolean result = false;

        if(cart.length() != 4){
            return false;
        }
        if((int)Character.toUpperCase(cart.charAt(0)) != 67){
            return false;
        }

        for (int i = 1; i < cart.length(); i++){
            char c = cart.charAt(i);
            if(Character.isDigit(c)){
                result = true;
            }else{
                return false;
            }
        }

        return result;
    }
}
