public class CheckSum {
    public static int[] twoNumbersAddToN(int[] arr, int n){
        /*
        *  1. Set pointers and empty array
        *  2. While pointerB < arr.length && pointerA < arr.length
        *       a. Check if arr[pointerA] + arr[pointerB] = n && pointerA != pointerB
        *           i. If true break;
        *       b. If pointerB == arr.length-1
        *           i. if true pointerA++
        *           ii. pointerB = pointerA
        *       c. else pointerB++
        * 3. If arr[pointerA] + arr[pointerB] != n
        *       a. Then return result
        * 4. Else
        *       a. result[0] = arr[pointerA]
        *       b. result[1] = arr[pointerB]
        * 5. Finally return result
        *
        * Time Complexity: O(n)
        * */

        int[] result = new int[2];
        int pointerA = 0, pointerB = 0;

        while(pointerB < arr.length && pointerA < arr.length){
            if(arr[pointerA] + arr[pointerB] == n && pointerA != pointerB){
                break;
            }
            if(pointerB == arr.length-1){
                pointerA++;
                pointerB = pointerA;
            }else {
                pointerB++;
            }
        }

        if(arr[pointerA] + arr[pointerB] != n){
            return result;
        }

        result[0] = arr[pointerA];
        result[1] = arr[pointerB];

        return result;
    }

    public static void main(String args[]) {

        int n = 4;
        int[] arr1 = {2, 1, 1, 5, 7, 3};
        if(arr1.length > 0){
            int[] arr2 = twoNumbersAddToN(arr1, n);
            int num1 = arr2[0];
            int num2 = arr2[1];

                System.out.println("Number 1 = " + num1);
                System.out.println("Number 2 = " + num2);
                System.out.println("Sum = " +  (n) );

        } else {
            System.out.println("Not Found");
        }
    }
}
