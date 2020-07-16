public class CheckRemoveEven {
    public static void main(String[] args){
        int[] test_case = {32, 37, 10, 40, 11, 5};

        System.out.print("[");
        for(int i = 0; i< removeEven(test_case).length-1; i++){
            System.out.print(removeEven(test_case)[i]+", ");
        }
        System.out.print(removeEven(test_case)[removeEven(test_case).length-1]+"]");
    }

    public static int[] removeEven(int[] arr){

        /*
			1. Iterate through the array to find the number of odd integers
			2. Initialize new int array for odd integers
			3. Iterate through array again and add the odd integers to new array
			4. Return new array

			Time complexity: O(n)
		*/


        int num_of_odd = 0;
        for (int value : arr) {
            if (value % 2 != 0) {
                num_of_odd++;
            }
        }
        int index = 0;
        int[] odd_array = new int[num_of_odd];
        for (int value : arr) {
            if (value % 2 != 0) {
                odd_array[index++] = value;
            }
        }

        return odd_array;
    }
}
