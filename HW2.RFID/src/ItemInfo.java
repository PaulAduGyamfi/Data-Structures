public class ItemInfo {
    private String name;
    private double price;
    private String rfidTagNumber;
    private String original_position;
    private String current_position;

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

    public String getName() {
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }


    public double getPrice(){
        return this.price;
    }
    public void setPrice(double price){
        this.price = price;
    }


    public String getRfidTagNumber(){
        return this.rfidTagNumber;
    }
    public void setRfidTagNumber(String rfidTagNumber){
        this.rfidTagNumber = rfidTagNumber;
    }


    public String getOriginal_position(){
        return this.original_position;
    }
    public void setOriginal_position(String original_position){
        this.original_position = original_position;
        this.current_position = original_position;
    }


    public String getCurrent_position(){
        return this.current_position;
    }
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
