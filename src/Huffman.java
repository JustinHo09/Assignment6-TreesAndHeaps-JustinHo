public class Huffman {

    public int[] frequency;
    public HeapNode root;
    public String[] codes;
    public String ogText;

    public Huffman(){
        frequency = new int[27];
        codes = new String[27];
        root = null;
    }

    //O(m) since it reset is O(27)
    // Second one is length of input string, upperbounded by m
    // O(1) space since only happen 2 time no matter what
    public void frequencyCount(String text){
        ogText = text;
        // reset the frequency
        for(int i=0; i<frequency.length;i++){
            frequency[i] = 0;
        }
        // calculate frequency
        for(int j=0; j<text.length(); j++){
            frequency[charToNum(text.charAt(j))]++;
        }
    }

    //O(1) since freq is always 27, and merges is upper bounded by 27
    //O(1) space since cariabes happen 1 and array is awlays 53
    public void buildHuffman(){
        HeapNode [] nodes = new HeapNode[53];
        int currentSize = 0;

        // Makes the character leaves and adds it to the array
        for(int i=0; i< frequency.length;i++){
            if(frequency[i] >0){
                nodes[currentSize] = new HeapNode(numToChar(i),frequency[i]);
                currentSize++;
            }
        }
        //  It is empty
        if(currentSize == 0){
            return;
        }
        // Merge the nodes
        int merges = currentSize -1;
        int leftIndex;
        int rightIndex;
        HeapNode left;
        HeapNode right;

        for(int i=0; i<merges; i++){

            // Find the first smallest one
            leftIndex = findSmallest(nodes, currentSize);
            left = nodes[leftIndex];
            nodes[leftIndex] = null;

            // Find the second smallest one
            rightIndex = findSmallest(nodes, currentSize);
            right = nodes[rightIndex];
            nodes[rightIndex] = null;

            nodes[currentSize] = new HeapNode(left,right);
            currentSize++;
        }
        root = nodes[currentSize -1];
        
        genCode();
    }

    //O(largest size), but since 53 is always in it, its O(1)
    //O(1) space cinde thosee 2 only happen once no matter how large input
    public int findSmallest(HeapNode[] nodes, int largestSize){
        int smallestIndex = -1;
        for(int i=0; i<largestSize; i++){
            if(nodes[i] != null){
                if(smallestIndex == -1 || nodes[i].getFrequency() < nodes[smallestIndex].getFrequency()){
                    smallestIndex = i;
                }
            }
        }
        return smallestIndex;
    }

    //O(1) since codes.leng is alway 27, frequency is 27
    //O(1) since i and target will only happen once
    public void genCode(){
        if(root == null){
            return;
        }

        // Reset the codes
        for(int i=0; i< codes.length;i++){
            codes[i] = null;
        }

        // Fill the codes in for valid ones
        char target;
        for(int i=0; i< frequency.length; i++){
            if(frequency[i] > 0){
                target = numToChar(i);
                codes[i] = getPath(root,target,"");
            }
        }
    }

    //O(1) since at most it will just have 27 levels in the tree
    // This also means that string concat in worst case will be
    // make a string from 0 to k = k^2 but k is always <= 27 since
    // There are only 27 valid paths to reach before a character in case
    // where is is a linked list.
    // Space follows the same logic
    public String getPath(HeapNode node,char target, String path){
        if(node == null){
            return null;
        }
        // We encounter the desired node
        if(target == node.getData()){
            return path;
        }
        String left = getPath(node.getLeft(),target,path+"0");
        if(left != null){
            return left;
        }
        return getPath(node.getRight(),target,path+"1");
    }

    // This is O(m^2) since the strings go from 0 to 1*c to m*c
    // byt c is upper bounded by 27 since we only have 27 charactres
    public String encode(String text){
        String result = "";
        for(int i=0; i<text.length();i++){
            if(codes[charToNum(text.charAt(i))] != null) {
                result += codes[charToNum(text.charAt(i))];
            }
        }
        return result;
    }

    //O(1) no matter what
    public int charToNum(char c){
        if(c == ' '){
            return 0;
        }else if(c == 'a'){
            return 1;
        }else if(c == 'b'){
            return 2;
        }else if(c == 'c'){
            return 3;
        }else if(c == 'd'){
            return 4;
        }else if(c == 'e'){
            return 5;
        }else if(c == 'f'){
            return 6;
        }else if(c == 'g'){
            return 7;
        }else if(c == 'h'){
            return 8;
        }else if(c == 'i'){
            return 9;
        }else if(c == 'j'){
            return 10;
        }else if(c == 'k'){
            return 11;
        }else if(c == 'l'){
            return 12;
        }else if(c == 'm'){
            return 13;
        }else if(c == 'n'){
            return 14;
        }else if(c == 'o'){
            return 15;
        }else if(c == 'p'){
            return 16;
        }else if(c == 'q'){
            return 17;
        }else if(c == 'r'){
            return 18;
        }else if(c == 's'){
            return 19;
        }else if(c == 't'){
            return 20;
        }else if(c == 'u'){
            return 21;
        }else if(c == 'v'){
            return 22;
        }else if(c == 'w'){
            return 23;
        }else if(c == 'x'){
            return 24;
        }else if(c == 'y'){
            return 25;
        }else if(c == 'z'){
            return 26;
        }
        return -1;
    }
    //O(1) no matter what
    public char numToChar(int i){
        if(i == 0){
            return ' ';
        }else if(i == 1){
            return 'a';
        }else if(i == 2){
            return 'b';
        }else if(i == 3){
            return 'c';
        }else if(i == 4){
            return 'd';
        }else if(i == 5){
            return 'e';
        }else if(i == 6){
            return 'f';
        }else if(i == 7){
            return 'g';
        }else if(i == 8){
            return 'h';
        }else if(i == 9){
            return 'i';
        }else if(i == 10){
            return 'j';
        }else if(i == 11){
            return 'k';
        }else if(i == 12){
            return 'l';
        }else if(i == 13){
            return 'm';
        }else if(i == 14){
            return 'n';
        }else if(i == 15){
            return 'o';
        }else if(i == 16){
            return 'p';
        }else if(i == 17){
            return 'q';
        }else if(i == 18){
            return 'r';
        }else if(i == 19){
            return 's';
        }else if(i == 20){
            return 't';
        }else if(i == 21){
            return 'u';
        }else if(i == 22){
            return 'v';
        }else if(i == 23){
            return 'w';
        }else if(i == 24){
            return 'x';
        }else if(i == 25){
            return 'y';
        }else if(i == 26){
            return 'z';
        }
        return '!';
    }


    public void printStats(){
        // Frequency Table
        System.out.println("Frequencies:");
        //O(1) time since its always 27
        // Space is also O(1) always
        for(int i=0; i<frequency.length;i++){
            if(frequency[i] >0){
                if(numToChar(i) == ' '){
                    System.out.println("(space) : " +frequency[i]);
                }else{
                    System.out.println(numToChar(i)+ " : " +frequency[i]);
                }

            }
        }
        //Huffman Code mapping
        //O(1) space since codes is always 27
        // Space is also always O(1)
        System.out.println("Huffman Codes:");
        for(int i=0; i<codes.length; i++){
            if(codes[i] != null){
                if(numToChar(i) ==' ') {
                    System.out.println("(space) : " + codes[i]);
                }else {
                    System.out.println(numToChar(i) + ": " + codes[i]);
                }
            }
        }
        //encoded string;
        // O(m^2) since encode is m^2
        System.out.println("Encoded \n" + encode(ogText));
    }

}
