package hufman;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HuffmanMain implements Serializable {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	     //Symbols:
        //String str = "12345678"; 
       char[] test2 = HuffmanData.readDatachars();
        //Frequency (of the symbols above):
        int[] charFreqs =HuffmanData.ReadDatafrequncy() ;

		//HuffmanData.ReadData();
        // build tree
        HuffmanTree tree = Huffman.buildTree(charFreqs,test2);
        
        HuffmanStoring.StoreTree(tree);
      
        HuffmanTree tree1;
        File temp = new File("tree.dat");
		FileInputStream fis = new FileInputStream("tree.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		 try {
			 PrintWriter writerObj1 =null;
			 writerObj1 = new PrintWriter(new File("binary.txt"));
			tree1 = (HuffmanTree) ois.readObject();
			System.out.println("succefull read");
		Huffman.printCodes(tree1, new StringBuffer());
		//	HuffmanStoring.writingFile(tree1, new StringBuffer());
			System.out.println("<--ROUND 2-->");
			HuffmanStoring.writeFile(tree1, new StringBuffer());
			System.out.println("FINITO");
		 } catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ois.close();
	
		//	System.out.println("<--ROUND 2-->");
			
			//System.out.println("FINITO");
		}
	
			
    
	

}
