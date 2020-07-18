public class mergeSortedArrays {
    public static int[] mergeArrays(int[] arr1, int[] arr2)
    {
      /*
        1. Iterate through both arrays at the same time
          a. Compare the values at the pointer
          b. push the smaller to the new array and advance the pointer
        2. When one pointer reaches its end we can add all the element of the remaining array to the new array
        3. Finally return array

        Time Complexity: O(n+m)
      */

        int pointerA = 0, pointerB = 0, cursor = 0;
        int[] resultant = new int[arr1.length + arr2.length];

        while(pointerA < arr1.length && pointerB < arr2.length){
            if(arr1[pointerA] < arr2[pointerB]){
                resultant[cursor++] = arr1[pointerA++];
            }else{
                resultant[cursor++] = arr2[pointerB++];
            }
        }

        while(pointerA < arr1.length){
            resultant[cursor++] = arr1[pointerA++];
        }
        while(pointerB < arr2.length){
            resultant[cursor++] = arr2[pointerB++];
        }

        return resultant;
    }

    public static void main(String[] args) {

        int[] arr1 = {1,12,14,17,23};
        int[] arr2 = {11,19,27};

        int[] resultantArray = mergeArrays(arr1, arr2);

        System.out.print("Arrays after merging: ");
        for(int i = 0; i < arr1.length + arr2.length; i++) {
            System.out.print(resultantArray[i] + " ");
        }
    }
}
