public class ProductArray {
    public static int[] findProduct(int[] arr){
        int[] result = new int[arr.length];

        /**
         *  1. Loop through the array
         *  2. Set a pointer that will iterate and find values in array
         *  3. if the value at the pointer is not at the index of the first loop then multiply it to product
         *      else advance the pointer
         *  4. When pointer reaches the end of the list push product to respective index in new array
         *      Reset pointer to beginning of list
         *      Reset product
         *    5. Return new array
         *
         *    Time Complexity: O(n^2)
         */
        int pointer = 0;

        for(int i = 0; i < arr.length; i++){
            int temp = 1;
            while(pointer < arr.length){
                if(pointer != i){
                    temp *= arr[pointer];
                }
                pointer++;
            }
            result[i] = temp;
            pointer = 0;

        }


        return result;
    }

    public static void main(String[] args) {

        int[] arr = {-1, 2, -3, 4, -5};

        System.out.println("Array before product: ");
        for(int number : arr){
            System.out.print(number+ " ");
        }

        System.out.println();

        System.out.println("Array after product: ");
        for(int number : findProduct(arr)){
            System.out.print(number+ " ");
        }
    }
}
