import java.util.ArrayList;
import java.util.List;

public class GreatestNumCandies {
  public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies){
      /**
       *  1. Loop through the array and find the max
       *  2. Create an array list to hold boolean values
       *  2. Loop through the array and check:
       *    a. if value in array + extraCandies >= max add true to list
       *    b. else add false to list
       *  3. Return array list
       *
       *  Time Complexity: O(n)
       */

      int max = candies[0];
      int pointer = 0;

      while(pointer < candies.length){
          if(candies[pointer] > max){
              max = candies[pointer];
          }
          pointer++;
      }

      List<Boolean> kidsCandies = new ArrayList<Boolean>();

      for(int candy : candies){
          kidsCandies.add(candy + extraCandies >= max);
      }
        return kidsCandies;
  }

    public static void main(String[] args) {
        int[] arr = {4,2,1,1,2};
        int n = 1;

        System.out.print("Input: ");
        for (int number : arr) {
            System.out.print(number + " ");
        }

        System.out.println();

        System.out.print("Output: ");
        for (boolean bool : kidsWithCandies(arr, n)) {
            System.out.print(bool + " ");
        }
    }
}
