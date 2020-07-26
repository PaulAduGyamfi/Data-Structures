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


    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getElevatorState() {
        return elevatorState;
    }

    public void setElevatorState(int elevatorState) {
        this.elevatorState = elevatorState;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
