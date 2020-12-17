package hufman;

public class HuffmanMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     //Symbols:
        //String str = "12345678"; 
       char[] test2 = HuffmanData.readDatachars();
        //Frequency (of the symbols above):
        int[] charFreqs =HuffmanData.ReadDatafrequncy() ;

		//HuffmanData.ReadData();
        // build tree
        HuffmanTree tree = Huffman.buildTree(charFreqs,test2);

        // print out results
        System.out.println("SYMBOL\tFREQ\tHUFFMAN CODE");
        Huffman.printCodes(tree, new StringBuffer());
    }
	

}
