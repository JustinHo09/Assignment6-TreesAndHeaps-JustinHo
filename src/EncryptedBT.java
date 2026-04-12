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
        System.out.println(isInBT(bt3,t));
    }

    public static boolean isInBT(int[] input, int target){

        // Enpty or null tree or doesn't meet the condition that root = -1
        if(input == null || input.length == 0 || input[0] == -1){
            return false;
        }

        if(target == 1){
            return true;
        }

        int[] unencrypted = new int[input.length];
        unencrypted[0] = 1;

        int left;
        int right;
        int x;

        // decode the rest
        for(int i=0; i<input.length; i++){
            // only decode if the input at the index is valid
            // and its parent is a valid node.
            if(input[i] == -2 && unencrypted[i] != 0){
                x = unencrypted[i];

                // check the left
                left = 2 * i + 1;
                if(left < input.length && input[left] == -2){
                    unencrypted[left] = 3 * x +1;
                    if(unencrypted[left] == target){
                        return true;
                    }
                }

                //check the right
                right = 2 * i +2;
                if(right < input.length && input[right] == -2){
                    unencrypted[right] = 2  * x + 5;
                    if(unencrypted[right] == target){
                        return true;
                    }
                }

            }
        }
        return false;
    }
}
