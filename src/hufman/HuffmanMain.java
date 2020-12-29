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
       // PrintWriter s = null;
        // print out results
        //System.out.println("SYMBOL\tFREQ\tHUFFMAN CODE");
        //Huffman.printCodes(tree, new StringBuffer());
     //   Huffman.write(tree,s, new StringBuffer());
      /* OutputStream file = new FileOutputStream( "tree.bin" );
        OutputStream buffer = new BufferedOutputStream( file );
        ObjectOutput output = new ObjectOutputStream( buffer );

        output.writeObject(tree);*/
       // t.saveTree("tree.dat");
       // HuffmanStoring.DeStoreTree();
        HuffmanTree tree1;
        File temp = new File("tree.dat");
		FileInputStream fis = new FileInputStream("tree.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		 try {
			tree1 = (HuffmanTree) ois.readObject();
			System.out.println("succefull read");
			Huffman.printCodes(tree1, new StringBuffer());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ois.close();
        
    }
	

}
