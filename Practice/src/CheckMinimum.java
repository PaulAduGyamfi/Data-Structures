public class CheckMinimum {
    public static int findMinimum(int[] arr) {
        /**
         *  1. Set initial min to first element
         *  2. traverse the list and look for an element less than min with pointer
         *      if found set to min
         *      else advance pointer
         *  3. return min
         *
         *  Time Complexity: O(n)
         */
        int pointerB = 0;

        int min = arr[0];
        while(pointerB < arr.length){
            if(arr[pointerB] < min){
                min = arr[pointerB];
            }
            pointerB++;
        }
        return min;
    }

    public static void main(String[] args) {

        int[] arr = { 9, 2, 3, 6};

        System.out.print("Array : ");
        for (int value : arr) {
            System.out.print(value + " ");
        };
        System.out.println();

        int min = findMinimum(arr);
        System.out.println("Minimum in the Array: " + min);

    }
}
