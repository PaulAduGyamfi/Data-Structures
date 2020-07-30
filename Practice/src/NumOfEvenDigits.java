public class NumOfEvenDigits {
    public static int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums){
            int digits = 0;
            while(num > 0){
                num /= 10;
                digits++;
            }
            if(digits % 2 == 0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {555,901,482,1771};
        System.out.print("Input: ");
        for(int number : arr){
            System.out.print(number + " ");
        }

        System.out.println();

        System.out.print("Output: " + findNumbers(arr));

    }
}
