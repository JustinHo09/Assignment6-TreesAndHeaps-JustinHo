public class AllLess {

    public static void main(String[] args){
        String[] input = {"zero","size","nutella","jojo","luna","isse","astor",
                "as","entretien","","cal"};
        int x = 3;
        printLess(input,x);
    }

    public static void printLess(String[] input, int max){

        if(input.length == 0){
            System.out.println("[]");
            return;
        }

        boolean first = true;

        System.out.print("[");
        for(int i=0; i<input.length; i++){

            String current = input[i];

            if(current.length() < max){

                if(!first) {
                    System.out.print(", ");
                }

                System.out.print("\"");
                System.out.print(current);
                System.out.print("\"");

                first = false;
            }
        }
        System.out.print("]\n");
    }

}
