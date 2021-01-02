package hufman;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

//import huffman.HuffmanTree;

public class HuffmanStoring implements Serializable {
 public static void StoreTree( HuffmanTree tree) {
	 try {
         FileOutputStream fileOut =
         new FileOutputStream("tree.dat");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(tree);
         out.close();
         fileOut.close();
         System.out.println("Serialized data is saved in tree.dat");
      } catch (IOException i) {
         i.printStackTrace();
      }
 }	
 public static void writeFile(HuffmanTree tree, StringBuffer prefix) 
	{
	 PrintWriter writerObj1 =null;     
		String s;
		char t;
		HashMap<Character, String> hash_map = new HashMap<Character, String>();
		try {
			writerObj1 = new PrintWriter(new File("Binary.dat"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		assert tree != null;
	 
		if (tree instanceof HuffmanLeaf) {
			HuffmanLeaf leaf = (HuffmanLeaf) tree;


	s = prefix.toString();
//		System.out.println(leaf.value + "\t" + leaf.frequency + "\t" + s);
		t=leaf.value;
		hash_map.put(t, s);
		if(!hash_map.isEmpty()) {
			for (Entry<Character, String> entry : hash_map.entrySet()) {
			                                                  
				writerObj1.println(entry.getKey()+" "+entry.getValue());
			}
			 writerObj1.flush();  
			 writerObj1.close();  
	      }else {
	    	  System.out.println("no map printing");
	      }
		} else if (tree instanceof HuffmanNode) {
			HuffmanNode node = (HuffmanNode) tree;

			// traverse left
			prefix.append('0');

			writeFile(node.left, prefix);
			prefix.deleteCharAt(prefix.length() - 1);

			// traverse right
			prefix.append('1');

			writeFile(node.right, prefix);

			prefix.deleteCharAt(prefix.length() - 1);

		}
		

}

 

}
