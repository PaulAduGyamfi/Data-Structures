public class Request {
    private int sourceFloor;
    private int destinationFloor;
    private int timeEntered;

    public Request(int totalFloors) {
        setSourceFloor(totalFloors);
        setDestinationFloor(totalFloors);
        timeEntered = 0;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }

    public void setSourceFloor(int totalFloors) {
        this.sourceFloor = (int) (Math.random() * totalFloors + 1);
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int totalFloors) {
        this.destinationFloor = (int) (Math.random() * totalFloors + 1);
    }

    public int getTimeEntered() {
        return timeEntered;
    }

    public void setTimeEntered(int timeEntered) {
        this.timeEntered = timeEntered;
    }
}
