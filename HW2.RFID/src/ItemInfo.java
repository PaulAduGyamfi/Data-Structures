public class ItemInfo {
    private String name;
    private double price;
    private String rfidTagNumber;
    private String original_position;
    private String current_position;

    public ItemInfo(String name, String rfidTagNumber, double price, String original_position){
        this.name = name;
        this.rfidTagNumber = rfidTagNumber;
        this.price = price;
        this.original_position = original_position;
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
    public void setCurrent_position(String current_position){
        this.current_position = current_position;
    }
}
