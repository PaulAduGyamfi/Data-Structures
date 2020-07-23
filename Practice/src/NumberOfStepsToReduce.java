public class NumberOfStepsToReduce {
    public static int numberOfSteps(int num){
        /**
         *  1. If num is even divide num by 2
         *  2. Else if num is odd subtract 1
         *  3. Increment number of steps
         *  4. Continually do this until numm == 0
         *
         *  Time Complexity: O(n)
         */
        int num_of_steps = 0;
        while(num != 0){
            if(num % 2 == 0){
                num /= 2;
            }else{
                num--;
            }
            num_of_steps++;
        }
        return num_of_steps;
    }

    public static void main(String[] args) {
        int n = 14;
        System.out.println("Input: " + n);
        System.out.println("Output: " + numberOfSteps(n));
    }
}
