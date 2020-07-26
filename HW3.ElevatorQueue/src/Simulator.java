public class Simulator {
    public static void simulate(double probabilityReq, int numFloors, int numElevators, int simLength) throws QueueFullException, QueueEmptyException{
        RequestQueue<Request> queue = new RequestQueue<Request>();

        BooleanSource arrival = new BooleanSource(probabilityReq);

        int wait_time = 0, req_complete = 1, current_time = 1;

        double avg_wait_time =   (double)wait_time / req_complete ;

        Elevator[] BuildingElevators = new Elevator[numElevators];

        int j=0;
        for (int i = 0; i <= simLength; i++){
            if(arrival.requestArrived()){
                queue.enqueue(new Request(numFloors));
//                queue.get(0).setTimeEntered(current_time);
            }
        }

        for(int i = 0; i < BuildingElevators.length; i++){
            BuildingElevators[i] = new Elevator();
        }

        if(!queue.isEmpty()){
            for(int i =0; i<BuildingElevators.length; i++){

                if(BuildingElevators[i].getElevatorState() == 1){
                    BuildingElevators[i].setRequest(queue.dequeue());
//                    queue.dequeue();
                    BuildingElevators[i].setElevatorState(2);
                }

                if(BuildingElevators[i].getElevatorState() == 2){
                    while(BuildingElevators[i].getCurrentFloor() != BuildingElevators[i].getRequest().getDestinationFloor()){
                        if(BuildingElevators[i].getCurrentFloor() < BuildingElevators[i].getRequest().getDestinationFloor()){
                            BuildingElevators[i].setCurrentFloor(BuildingElevators[i].getCurrentFloor() + 1);
                        }else{
                            BuildingElevators[i].setCurrentFloor(BuildingElevators[i].getCurrentFloor() - 1);
                        }
                        wait_time++;
                    }
                    BuildingElevators[i].setElevatorState(3);
                    req_complete++;
                }

                current_time++;
            }
            if (req_complete != 0) { //If elevator have some request

                //Calculate total Time, Request and Average time for all requests
                System.out.println("Total Wait Time: " + wait_time);
                System.out.println("Total requests: " + req_complete);
                System.out.println("Average Wait Time: " + (double)Math.round(avg_wait_time*100)/100);
                System.out.println(req_complete);
            } else {
                System.out.println("Total Wait Time: " + 0);
                System.out.println("Total requests: " + 0);
                System.out.println("Average Wait Time: " + 0);
                System.out.println(0);
            }
        }
    }
}
