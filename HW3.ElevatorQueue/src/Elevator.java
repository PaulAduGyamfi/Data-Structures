/**
 * This class represents an elevator object
 *
 * @author Paul Adu-Gyamfi
 *
 */
public class Elevator {

    private int currentFloor;
    private int elevatorState;
    private final int IDLE = 1;
    private final int TO_SOURCE = 2;
    private final int TO_DESTINATION = 3;

    private Request request;

    public Elevator(){
        setRequest(null);
        setElevatorState(IDLE);
        setCurrentFloor(1);

    }

    /**
     *
     * @return
     * the floor that elevator is on
     */
    public int getCurrentFloor() {
        return currentFloor;
    }

    /**
     *
     * @param currentFloor
     * elevators current floor
     */
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    /**
     *
     * @return
     * if the elevator is idle, at source, or at destination
     */
    public int getElevatorState() {
        return elevatorState;
    }

    /**
     *
     * @param elevatorState
     * set the elevator's state: idle, at source, or at destination
     */
    public void setElevatorState(int elevatorState) {
        this.elevatorState = elevatorState;
    }

    /**
     *
     * @return
     *  the request that was made
     */
    public Request getRequest() {
        return request;
    }

    /**
     *
     * @param request
     * set the request
     */
    public void setRequest(Request request) {
        this.request = request;
    }
}
