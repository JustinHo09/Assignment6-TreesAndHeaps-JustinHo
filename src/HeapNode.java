public class HeapNode {

    public char data;
    public HeapNode left;
    public HeapNode right;
    public int frequency;

    public HeapNode(char letter, int freq){
        data = letter;
        frequency = freq;
    }

    //! used since it is not a vlid input
    public HeapNode(HeapNode l, HeapNode r){
        left = l;
        right = r;
        data = '!';
        frequency = l.getFrequency() + r.getFrequency();
    }

    public int getFrequency(){
        return frequency;
    }

    public HeapNode getLeft(){
        return left;
    }

    public HeapNode getRight(){
        return right;
    }

    public char getData(){
        return data;
    }
}
