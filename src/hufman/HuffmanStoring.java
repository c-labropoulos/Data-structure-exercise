package hufman;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

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

 

}
