package hufman;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.PriorityQueue;

import huffman.HuffmanTree;

public class Huffman {
    // input is an array of frequencies, indexed by character code
    public static HuffmanTree buildTree(int[] charFreqs, char[] test2) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(charFreqs[i], test2[i]));

        assert trees.size() > 0;
        // loop until there is only one tree left
        while (trees.size() > 1) {
            // two trees with least frequency
            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();

            // put into new node and re-insert into queue
            trees.offer(new HuffmanNode(a, b));
        }
        return trees.poll();
    }

    public static void printCodes(HuffmanTree tree, StringBuffer prefix) throws IOException {
    	//BufferedWriter bwr = new BufferedWriter(new FileWriter("treecode.txt"));
    	//PrintWriter out = new PrintWriter("treecode.txt");
    	assert tree != null;
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;

            // print out character, frequency, and code for this leaf (which is just the prefix)
           System.out.println(leaf.value + "\t" + leaf.frequency + "\t" + prefix);

        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode)tree;

            // traverse left
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);

            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
          
            prefix.deleteCharAt(prefix.length()-1);
        }  
       
    }
    public static  HuffmanTree loadTree() throws IOException, ClassNotFoundException
	{
    	HuffmanTree tree1;
		File temp = new File("tree.dat");
			FileInputStream fis = new FileInputStream("tree.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			 tree1 = (HuffmanTree) ois.readObject();
			ois.close();
			
			return tree1;
		
		
	}
    

}
