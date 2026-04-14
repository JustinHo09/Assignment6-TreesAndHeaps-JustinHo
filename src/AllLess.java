public class AllLess {

    public static void main(String[] args){
        String[] input = {"zero","size","nutella",null,"jojo","luna","isse","astor",
                "as","entretien","","cal"};
        int x = 3;
        printLess(input,x);

        x = 0;
        printLess(input, x);

        x = -2;
        printLess(input, x);

        x = 5;
        printLess(input, x);

        String[] input2 = {};
        x = 7;
        printLess(input2, x);
    }

    public static void printLess(String[] input, int max){

        if(input.length == 0 || max <= 0){
            System.out.println("[]");
            return;
        }

        boolean first = true;

        System.out.print("[");
        for(int i=0; i<input.length; i++){

            String current = input[i];

            if(current != null && current.length() < max){

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
