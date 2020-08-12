import java.util.Scanner;
/**
 * Paul Adu-Gyamfi
 *
 * paul.adu-gyamfi@stonybrook.edu
 *
 * CSE 214.R30
 * Juan Tarquino
 */
public class Analyzer {
    public static void main (String[] args) throws QueueEmptyException, QueueFullException {

        Scanner in = new Scanner(System.in);


        System.out.print("Please enter the probability of arrival for Requests: ");
        double probability = in.nextDouble();

        while((probability < 0.0) || (probability > 1.0)){
            System.out.println();
            System.out.println("The probability must be between 0 and 1!");
            System.out.print("Please enter the probability of arrival for Requests: ");
             probability = in.nextDouble();
        }

        System.out.print("Please enter the number of floors: ");
        int totalFloors = in.nextInt();
        while(totalFloors <= 1){
            System.out.println("There has to be more than 1 floor in the building!");
            System.out.print("Please enter the number of floors: ");
            totalFloors = in.nextInt();
        }

        System.out.print("Please enter the number of elevators: ");
        int totalElevators = in.nextInt();
        while(totalElevators <= 0){
            System.out.println("The number of elevators must be greater than 0!");
            System.out.print("Please enter the number of elevators: ");
            totalElevators = in.nextInt();

        }

        System.out.print("Please enter the length of the simulation (in time units): ");
        int simulationLength = in.nextInt();
        while(simulationLength <= 0){
            System.out.println("The length of the simulation must be greater than 0! ");
            System.out.print("Please enter the length of the simulation (in time units): ");
            simulationLength = in.nextInt();
        }

        Simulator.simulate(probability, totalFloors, totalElevators, simulationLength);
    }
}
