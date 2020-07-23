public class JewelsAndStones {
    public static int numJewelsInStones(String J, String S){
        /**
         *  1. Looop through Sting S and check for each letter using substring method
         *      if String J contains it using contains method if so increment num of jewels
         *  2. Return num of jewels
         *
         *  Time Complexity: O(n)
         */

        int num_of_jewels = 0;
        for(int i =0; i<S.length(); i++){
            if(J.contains(S.substring(i,i+1))){
                num_of_jewels++;
            }
        }
        return num_of_jewels;
    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";

        System.out.println("Input: ");
        System.out.println(J);
        System.out.println(S);

        System.out.println();

        System.out.println("Output: " + numJewelsInStones(J,S));
    }
}
