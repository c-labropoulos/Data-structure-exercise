package hufman;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;

import huffman.HuffmanTree;
import jdk.jfr.internal.StringPool;

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

	public static void  printCodes(HuffmanTree tree, StringBuffer prefix) throws IOException {
		String s,t;

	
		assert tree != null;
	//	  top_call = false;  
		if (tree instanceof HuffmanLeaf) {
			HuffmanLeaf leaf = (HuffmanLeaf) tree;

			// print out character, frequency, and code for this leaf (which is just the
			// prefix)

			//s = prefix.toString();
	
	s = prefix.toString();
	//	System.out.println(leaf.value + "\t" + leaf.frequency + "\t" + s);
		t=leaf.value+" ";
		System.out.println(t+s);
		} else if (tree instanceof HuffmanNode) {
			HuffmanNode node = (HuffmanNode) tree;

			// traverse left
			prefix.append('0');

			printCodes(node.left, prefix);
			prefix.deleteCharAt(prefix.length() - 1);

			// traverse right
			prefix.append('1');

			printCodes(node.right, prefix);

			prefix.deleteCharAt(prefix.length() - 1);

		}
		
	}

}
