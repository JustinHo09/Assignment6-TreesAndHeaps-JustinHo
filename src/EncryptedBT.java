public class EncryptedBT {

    public static void main(String[] args){
        int[] bt = {-2,-2,-1,-2,-1};
        int t=1;
        System.out.println(isInBT(bt,t));

        int[] bt2 = {-1,-2,-1,-2,-1};
        t=1;
        System.out.println(isInBT(bt2,t));

        int[] bt3 = {-2,-1,-2,-2,-1};
        t=4;
        System.out.println(isInBT(bt2,t));
    }

    public static boolean isInBT(int[] input, int target){

        // Enpty or null tree or doesn't meet the condition that root = -1
        if(input.length == 0 || input == null || input[0] == -1){
            return false;
        }

        int[] unencryped = new int[input.length];
        unencryped[0] = 1;

        if(target == 1){
            return true;
        }

        int left;
        int right;
        int x;

        // decode the rest
        for(int i=0; i<input.length; i++){
            // only decode if the input at the index is valid
            // and its parent is a valid node.
            if(input[i] == -2 && unencryped[i] != 0){
                x = unencryped[i];
                // check the left
                left = 2 * i + 1;
                if(left < input.length && input[left] == -2){
                    unencryped[left] = 3 * x +1;;
                    if(unencryped[left] == target){
                        return true;
                    }
                }

                //check the right
                right = 2 * i +2;
                if(right < input.length && input[right] == -2){
                    unencryped[right] = 2  * x + 5;
                    if(unencryped[right] == target){
                        return true;
                    }
                }

            }
        }

        return false;
    }
}
