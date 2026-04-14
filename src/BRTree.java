import java.util.LinkedList;

public class BRTree {

    public static void main(String[] args){
        int [] nodes = {10,19,20,30,42,55,77};
        BRTree tree = new BRTree(nodes);
        System.out.print('{');
        tree.printTree(tree.getRoot());

        System.out.println("}\n-----------------");

        tree.inRange(15,20);
        System.out.print('{');
        tree.printTree(tree.getRoot());
        int [] nodes2 = {10,19,20,30,42,55,77};
        tree = new BRTree(nodes2);

        System.out.println("}\n-----------------");

        tree.inRange(0,2);
        System.out.print('{');
        tree.printTree(tree.getRoot());
        int [] nodes3 = {10,19,20,30,42,55,77};
        tree = new BRTree(nodes3);

        System.out.println("}\n-----------------");

        tree.inRange(25,60);
        System.out.print('{');
        tree.printTree(tree.getRoot());
        int [] nodes4 = {10,19,20,30,42,55,77};
        tree = new BRTree(nodes4);
        System.out.print('}');
    }

    BRNode root;

    public BRTree(BRNode root){
        this.root = root;
    }

    //Constructor to convert an array of keys into a tree
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

        balance(node);
    }

    public void removalPrep(BRNode node){
        // do removal prep
        //Go through 6 cases
        // Case 1 node is red or root
        if(node.getColor() == false || node.getParent() == null){
            return;
        }

        //Case 2 Sibling is red
        BRNode parent = node.getParent();
        BRNode sibling = getSibling(node);
        if(sibling != null && sibling.getColor() == false){
            parent.setRed();
            sibling.setBlack();
            if(parent.getLeft() == node){
                rotateLeft(parent);
            }else{
                rotateRight(parent);
            }
        }

        parent = node.getParent();
        sibling = getSibling(node);
        // Case 3 parent and kids are black
        if(sibling != null) {
            if (parent.getColor() == true && (sibling.getRight() == null || sibling.getRight().getColor() == true)
                    && (sibling.getLeft() == null || sibling.getLeft().getColor() == true)) {

                sibling.setRed();
                removalPrep(node.getParent());
                return;
            }
        }

        parent = node.getParent();
        sibling = getSibling(node);
        //Case 4 parent is red and kids are black
        if(sibling != null) {
            if (parent.getColor() == false && (sibling.getRight() == null || sibling.getRight().getColor() == true)
                    && (sibling.getLeft() == null || sibling.getLeft().getColor() == true)) {
                parent.setBlack();
                sibling.setRed();
                return;
            }
        }

        sibling = getSibling(node);
        parent = node.getParent();
        //Case 5
        if(sibling != null) {
            if ((sibling.getLeft() != null && sibling.getLeft().getColor() == false)
                    && (sibling.getRight() == null || sibling.getRight().getColor() == true)
                    && node == parent.getLeft()) {
                getSibling(node).setRed();
                getSibling(node).getLeft().setBlack();
                rotateRight(getSibling(node));
            }
        }

        sibling = getSibling(node);
        parent = node.getParent();
        //Case 6
        if(sibling != null) {
            if ((sibling.getLeft() == null || sibling.getLeft().getColor() == true)
                    && (sibling.getRight() != null && sibling.getRight().getColor() == false)
                    && node == parent.getRight()) {
                getSibling(node).setRed();
                getSibling(node).getRight().setBlack();
                rotateLeft(getSibling(node));
            }
        }

        sibling = getSibling(node);
        parent = node.getParent();
        // Step 7
        if(sibling != null) {
            if (parent.getColor() == true) {
                sibling.setBlack();
            } else {
                sibling.setRed();
            }
        }
        parent.setBlack();

        // Step 8
        if(sibling != null) {
            if (node == parent.getLeft()) {
                if (sibling.getRight() != null) {
                    sibling.getRight().setBlack();
                }
                rotateLeft(parent);
            } else {
                if (sibling.getLeft() != null) {
                    sibling.getLeft().setBlack();
                }
                rotateRight(parent);
            }
        }
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
        BRNode gramps = getGrandparent(node);
        BRNode unc = getUncle(node);

        if(unc != null && !unc.getColor()){
            parent.setBlack();
            unc.setBlack();
            gramps.setRed();
            balance(gramps);
            return;
        }

        if(node == parent.getRight() && parent == gramps.getLeft()){
            rotateLeft(parent);
            node = parent;
            parent = node.getParent();
        } else if(node == parent.getLeft() && parent == gramps.getRight()){
            rotateRight(parent);
            node = parent;
            parent = node.getParent();
        }

        parent.setBlack();
        gramps.setRed();
        if(node == parent.getLeft()){
            rotateRight(gramps);
        }else{
            rotateLeft(gramps);
        }

    }

    public BRNode search(int key, BRNode node){
        if(node == null){
            return null;
        }
        if(key == node.getData()){
            return node;
        }

        if(key < node.getData()){
            return search(key, node.getLeft());
        }else{
            return search(key, node.getRight());
        }
    }

    public void inRange(int min, int max){
        LinkedList<Integer> toBeRemoved = new LinkedList<>();
        addKeysInRange(root,min,max,toBeRemoved);
        while(!toBeRemoved.isEmpty()){
            remove(toBeRemoved.remove());
        }
    }

    public void addKeysInRange(BRNode node, int min, int max, LinkedList<Integer> targets){
        if(node == null){
            return;
        }

        if(node.getData() >= min && node.getData() <= max){
            targets.addFirst(node.getData());
        }
        addKeysInRange(node.getLeft(),min,max,targets);
        addKeysInRange(node.getRight(),min,max,targets);
    }

    public void remove(int key){
        BRNode target = search(key,root);
        if(target == null){
            System.out.println("could not find target");
            return;
        }
        int predKey;
        if(target.getRight() != null && target.getLeft() != null){
            BRNode predecessor = target.getLeft();
            while(predecessor.getRight() != null){
                predecessor = predecessor.getRight();
            }
            predKey = predecessor.getData();

            if(predecessor.getColor() == true) {
                removalPrep(predecessor);
            }

            bstRemove(predecessor);

            target.setData(predKey);

        }else {

            if (target.getColor() == true) {
                removalPrep(target);
            }

            bstRemove(target);

            if (root != null && root.getColor() == false) {
                root.setBlack();
            }
        }
    }

    public void bstRemove(BRNode node){
        if(node == null){
            return;
        }

        // Leaf
        if(node.getRight() == null && node.getLeft() == null){
            if(node.getParent() !=null) {
                if (node == node.getParent().getLeft()) {
                    node.getParent().setLeft(null);
                } else {
                    node.getParent().setRight(null);
                }
            }else{
                root = null;
            }
            return;
        }

        // One child
        if(node.getRight() == null || node.getLeft() == null){
            BRNode child;
            if(node.getRight() != null){
                child = node.getRight();
            }else{
                child = node.getLeft();
            }

            if(node.getParent() == null){
                root = child;
                child.setParent(null);
            }else{
                if(node == node.getParent().getRight()){
                    node.getParent().setRight(child);
                }else{
                    node.getParent().setLeft(child);
                }
                child.setParent(node.getParent());
            }
            return;
        }
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

    public BRNode getSibling(BRNode node){
        if(node.getParent() != null) {
            if (node.getParent().getRight() == node) {
                return node.getParent().getLeft();
            } else {
                return node.getParent().getRight();
            }
        }
        return null;
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

    public void printTree(BRNode root){
        if(root == null){
            return;
        }
        printTree(root.getLeft());
        System.out.print(root.getData() + ",");
        printTree(root.getRight());
    }
}
