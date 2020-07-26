/**
 * This class represents the simulation of the building's elevators and requests
 *
 * @author Paul Adu-Gyamfi
 *
 */
public class Simulator {
    /**
     *
     * @param probabilityReq
     * probability of a request
     * @param numFloors
     * total number of floors in the building
     * @param numElevators
     * total number of elevators in the building
     * @param simLength
     * how long the simulation should run
     * @throws QueueFullException
     * if the queue is full
     * @throws QueueEmptyException
     * if the queue is empty
     */
    public static void simulate(double probabilityReq, int numFloors, int numElevators, int simLength) throws QueueFullException, QueueEmptyException{
        RequestQueue<Request> queue = new RequestQueue<Request>();

        BooleanSource arrival = new BooleanSource(probabilityReq);

        int wait_time = 0, req_complete = 1, current_time = 1;


        Elevator[] BuildingElevators = new Elevator[numElevators];

        for (int i = 0; i <= simLength; i++){
            if(arrival.requestArrived()){
                Request request = new Request(numFloors);
                request.setTimeEntered(current_time);
                queue.enqueue(request);
            }
        }

        for(int i = 0; i < BuildingElevators.length; i++){
            BuildingElevators[i] = new Elevator();
        }

        if(!queue.isEmpty()){
            for(int i =0; i<BuildingElevators.length; i++){

                if(BuildingElevators[i].getElevatorState() == 1){
                    BuildingElevators[i].setRequest(queue.dequeue());
                    BuildingElevators[i].setElevatorState(2);
                    current_time++;
                }

                if(BuildingElevators[i].getElevatorState() == 2){
                    while(BuildingElevators[i].getCurrentFloor() != BuildingElevators[i].getRequest().getDestinationFloor()){
                        if(BuildingElevators[i].getCurrentFloor() < BuildingElevators[i].getRequest().getDestinationFloor()){
                            BuildingElevators[i].setCurrentFloor(BuildingElevators[i].getCurrentFloor() + 1);
                        }else{
                            BuildingElevators[i].setCurrentFloor(BuildingElevators[i].getCurrentFloor() - 1);
                        }
                        current_time++;
                    }
                    BuildingElevators[i].setElevatorState(3);
                    req_complete++;
                    wait_time += current_time - BuildingElevators[i].getRequest().getTimeEntered();
                }

                current_time++;
            }

        }
        if (req_complete != 0) {

            System.out.println("Total Wait Time: " + wait_time);
            System.out.println("Total requests: " + req_complete);
            System.out.print("Average Wait Time: ");
            System.out.println(String.format("%.2f",(double)Math.round((double) wait_time/req_complete*100.0)/100.0));
            System.out.println();
        }
    }
}
