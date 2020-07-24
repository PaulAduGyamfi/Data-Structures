public class CheckSecondMax {
    public static int findSecondMaximum(int[] arr){

        /**
         *  1. Set the max to Integer.MIN_VALUE
         *  2. Loop through the array and compare the values to the max if > than max than set max to that value
         *  3. Set second max to Integer.MIN_VALUE
         *  4. Loop through the array again and find value that is > second max BUT less than first max
         *  5. Return second max
         *
         *  Time Complexity: O(n)
         */

        int first_max = Integer.MIN_VALUE;
        for (int item : arr) {
            if (item > first_max) {
                first_max = item;
            }
        }

        int second_max = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > second_max && value < first_max) {
                second_max = value;
            }
        }

        return second_max;
    }

    public static void main(String[] args) {

        int[] arr = {-2, -33, -10, -456};

        System.out.println("Array: ");
        for(int number : arr){
            System.out.print(number + " ");
        }

        System.out.println();

        int secMax = findSecondMaximum(arr);

        System.out.println("Second maximum: " + secMax);

    }
}
