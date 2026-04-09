public class EncryptedBT {

    public static void main(String[] args){
        int[] bt = {-2,-2,-1,-2,-1};
        int t=1;
    }

    public static boolean isInBT(int[] input, int target){

        // Enpty or null tree or doesn't meet thee condition that root = -1
        if(input.length == 0 || input == null || input[0] == -1){
            return false;
        }

        int[] unencryped = new int[input.length];
        unencryped[0] = 1;
    }
}
