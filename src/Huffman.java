public class Huffman {

    public int[] frequency;

    public Huffman(){
        frequency = new int[27];
    }

    public void frequencyCount(String text){
        for(int i=0; i<frequency.length;i++){
            frequency[i] = 0;
        }

        for(int j=0; j<text.length(); j++){
            frequency[charToNum(text.charAt(j))]++;
        }
    }

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

    public void printStats(){
        
    }

}
