
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;



class Main
{
	// Traverse the Huffman Tree and store Huffman Codes in a map.


	public static void main(String[] args) throws IOException {
	 
		String text = args[1].toString();
		huffman.buildHuffmanTree(text);
		 
			
	}
}