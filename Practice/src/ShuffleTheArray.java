public class ShuffleTheArray {
    public static int[] shuffle(int[] nums, int n) {
        /**
         * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
         * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
         *
         *  1. intizialize a new array of length nums.length
         *  2. initialize pointerA at beginning and pointerB at n; initialize index tracker for new array
         *  3. while pointerB < nums.length
         *      a. add value at pointerA to new array at index i
         *      b. then add value at pointerB to new array at index i+1
         *      3. increment i
         *  4. return the new array
         *
         * Time Complexity: O(n)
         */

        int[] result = new int[nums.length];
        int pointerA = 0, pointerB = n, i = 0;

        while (pointerB < nums.length && i<result.length){
            result[i] = nums[pointerA++];
            result[++i] = nums[pointerB++];
            i++;

        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,3,2,1};
        int n=4;

        System.out.print("Input: ");
        for (int number : arr){
            System.out.print(number +" ");
        }

        System.out.println();

        System.out.print("Output: ");
        for(int number: shuffle(arr,n)){
            System.out.print(number + " ");
        }
    }
}
