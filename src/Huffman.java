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
        System.out.println("Frequencies:");
        for(int i=0; i<frequency.length;i++){
            if(frequency[i] >0){
                System.out.println(numToChar(i)+ " : " +frequency[i]);
            }
        }
    }

}
