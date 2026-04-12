import java.util.Random;

public class EncodingSystem {

    public Huffman huff;
    public String[] inputs;
    public String[] encoded;

    public static void main(String[] args){
        String[] texts = {"marcus fenix is a gear"};
        EncodingSystem test = new EncodingSystem(texts);
    }

    public EncodingSystem(String[] texts){
        huff = new Huffman();
        inputs = texts;
        encoded = new String[texts.length];

        // Fill the encoded array with all the encoded strings
        for(int i=0; i< texts.length; i++){
            huff.frequencyCount(texts[i]);
            huff.buildHuffman();
            encoded[i] = huff.encode(texts[i]);
        }
    }

    public String highestCode(){
        if(encoded.length == 0){
            return null;
        }
        int longest = 0;
        for(int i=0; i< encoded.length;i++){
            if(encoded[i].length() > encoded[longest].length()){
                longest = i;
            }
        }
        return encoded[longest];
    }

    public String[] shuffleCodes(){
        Random gen = new Random();
        int rand;
        for(int i = 0; i<encoded.length; i++){
            rand = gen.nextInt(i,encoded.length);

            String temp = encoded[i];
            encoded[i] = encoded[rand];
            encoded[rand] = temp;
        }
        return encoded;
    }

    public void printCodes(){
        for(int i=0; i<encoded.length; i++){
            System.out.println(encoded[i]);
        }
    }
}
