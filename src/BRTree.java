public class BRTree {

    BRNode root;

    public BRTree(BRNode root){
        this.root = root;
    }

    public BRTree(int[] array){
        arrayToBR(array);
    }

    public BRNode getRoot(){
        return root;
    }

    public void insertNode(BRNode node){
        if(root == null){
            root = node;
            root.changeColor();
        }
        // Find where to add and add

        //Rebalance if needed
    }

    public void removeNode(int value){
        // Search for node with that value

        //Go through 6 cases

        // Do bst remove
    }

    public void arrayToBR(int[] array){
        for(int i=0; i< array.length;i++){
            insertNode(new BRNode(array[i]));
        }
    }
}
