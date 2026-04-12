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

        // Fill the encoded array with all of the encoded strings
        for(int i=0; i< texts.length; i++){
            huff.frequencyCount(texts[i]);
            huff.buildHuffman();
            encoded[i] = huff.encode(texts[i]);
        }
    }
}
