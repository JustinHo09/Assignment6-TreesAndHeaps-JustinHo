public class BRNode {

    private int data;

    private BRNode left;
    private BRNode right;
    private BRNode parent;

    // True is black and False is red
    private boolean color;

    public BRNode(int data){
        this.data = data;
        color = false;
    }

    public BRNode getLeft(){
        return left;
    }

    public BRNode getRight(){
        return right;
    }

    public BRNode getParent(){
        return parent;
    }

    public int getData(){
        return data;
    }

    public boolean getColor(){
        return color;
    }

    public void setBlack(){
        color = true;
    }

    public void setRed(){
        color = false;
    }

    public void setParent(BRNode parent){
        this.parent = parent;
    }

    public void setLeft(BRNode left){
        this.left = left;
    }

    public void setRight(BRNode right){
        this.right = right;
    }

}
