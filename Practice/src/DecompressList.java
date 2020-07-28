public class DecompressList {
        public static int[] decompressRLElist(int[] nums) {

            int length = 0;
            for(int i = 0; i<nums.length; i+=2){
                length += nums[i];
            }

            int[] result = new int[length];

            int i = 0, j = 0;
            int freq = nums[0];
            while(j < result.length && (2*i+1) < nums.length){
                if(freq > 0){
                    result[j++] = nums[2*i+1];
                    freq--;
                }else{
                    i++;
                    freq = nums[2*i];
                }
            }
            return result;
        }

    public static void main(String[] args) {
        int[] input_arr = {1,2,3,4};
        System.out.print("Input: ");
        for (int number : input_arr){
            System.out.print(number+ " ");
        }

        System.out.println();

        System.out.print("Output: ");
        for (int number : decompressRLElist(input_arr)){
            System.out.print(number+ " ");
        }

    }
}
