public class BalancedString {
    public static int balancedStringSplit(String s) {
        int pointer = 0, balance = 0, max = 0;
        while(pointer < s.length()){
            if(s.charAt(pointer) ==  'R'){
                balance++;
            }
            else if(s.charAt(pointer) ==  'L'){
                balance--;
            }

            if(balance == 0){
                max++;
            }
            pointer++;
        }
        return max;
    }

    public static void main(String[] args) {
        String test = "RLRRRLLRLL";
        System.out.println("Input: " + test);

        System.out.println("Output: "+ balancedStringSplit(test));
    }
}
