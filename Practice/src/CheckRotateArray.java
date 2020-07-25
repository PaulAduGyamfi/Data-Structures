public class CheckRotateArray {
    public static void rotateArray(int[] arr){
        /**
         *  1. Save the last element in the array
         *  2. Shift all the elements in the array to the right
         *  3. Add the saved last element to the beginning of the array
         *
         *  Time Complexity: O(n)
         */
        int last_number = arr[arr.length-1];

        for(int i = arr.length-1; i>0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = last_number;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 1, 8, 4, 2};

        System.out.print("Array before rotation: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }

        rotateArray(arr);
        System.out.println();
        System.out.print("Array after rotation: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }

    }
}
