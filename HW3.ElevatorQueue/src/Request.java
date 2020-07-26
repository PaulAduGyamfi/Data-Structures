/**
 * This class represents an elevator request being made inside the building,
 *
 * @author Paul Adu-Gyamfi
 *
 */
public class Request {
    private int sourceFloor;
    private int destinationFloor;
    private int timeEntered;

    public Request(int totalFloors) {
        setSourceFloor(totalFloors);
        setDestinationFloor(totalFloors);
        timeEntered = 0;
    }

    /**
     *
     * @return
     * the current floor of the request
     */
    public int getSourceFloor() {
        return sourceFloor;
    }

    /**
     *
     * @param totalFloors
     * total number of floors in tje building
     */
    public void setSourceFloor(int totalFloors) {
        this.sourceFloor = (int) (Math.random() * totalFloors + 1);
    }

    /**
     *
     * @return
     * the requesting destination floor
     */
    public int getDestinationFloor() {
        return destinationFloor;
    }

    /**
     *
     * @param totalFloors
     * total number of floors in the building
     */
    public void setDestinationFloor(int totalFloors) {
        this.destinationFloor = (int) (Math.random() * totalFloors + 1);
    }

    /**
     *
     * @return
     * the time entered
     */
    public int getTimeEntered() {
        return timeEntered;
    }

    /**
     *
     * @param timeEntered
     * the time entered
     */
    public void setTimeEntered(int timeEntered) {
        this.timeEntered = timeEntered;
    }
}
