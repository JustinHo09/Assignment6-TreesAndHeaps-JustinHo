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
            root.setBlack();
            root.setParent(null);
            return;
        }

        // Find where to add and add
        BRNode current = root;
        while(current != null){
            //left
            if(node.getData() < current.getData()){
                if(current.getLeft() == null){
                    current.setLeft(node);
                    node.setParent(current);
                    current = null;
                }else{
                    current = current.getLeft();
                }
            }else{
                if(current.getRight() == null){
                    current.setRight(node);
                    node.setParent(current);
                    current = null;
                }else{
                    current = current.getRight();
                }
            }
        }

        node.setRed();

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

    public void balance(BRNode node){

        // it is root
        if(node.getParent() == null){
            node.setBlack();
            return;
        }


        if(node.getParent().getColor()){
            return;
        }

        BRNode parent = node.getParent();

    }

    public BRNode getGrandparent(BRNode node){
        if(node.getParent() == null){
            return null;
        }

        return node.getParent().getParent();

    }

    public BRNode getUncle(BRNode node){
        if(node.getParent() == null || getGrandparent(node) == null){
            return null;
        }

        if(getGrandparent(node).getLeft() == node.getParent()){
            return getGrandparent(node).getRight();
        }else{
            return getGrandparent(node).getLeft();
        }

    }

    public void rotateRight(BRNode node){
        BRNode left = node.getLeft();
        BRNode parent = node.getParent();

        // set its left's right to be its left
        node.setLeft(left.getRight());
        if(left.getRight() != null) {
            left.getRight().setParent(node);
        }

        // set it to be its left's right
        left.setRight(node);
        node.setParent(left);
        left.setParent(parent);

        // update parent if exists
        if(parent == null){
            root = left;
        }else if(parent.getLeft() == node){
            parent.setLeft(left);
        }else{
            parent.setRight(left);
        }
    }

    public void rotateLeft(BRNode node){
        BRNode right = node.getRight();
        BRNode parent = node.getParent();

        node.setRight(right.getLeft());
        if(right.getLeft() != null){
            right.getLeft().setParent(node);
        }

        right.setLeft(node);
        node.setParent(right);
        right.setParent(parent);

        if(parent == null){
            root = right;
        }else if(parent.getRight() == node){
            parent.setRight(right);
        }else{
            parent.setLeft(right);
        }
    }
}
