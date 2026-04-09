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
}
