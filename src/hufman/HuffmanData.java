package hufman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HuffmanData {
    public static  int[] ReadDatafrequncy() {
    	ArrayList<String> valuestmp = new ArrayList<>();
	   // ArrayList<String> keys = new ArrayList<>();
	
	    ArrayList<Integer> values = new ArrayList<>();
	    try(BufferedReader in = new BufferedReader(new FileReader("C:\\\\Users\\\\lampr\\\\eclipse-workspace\\\\Data_structure_exercise\\\\frequency.dat"))){
	      String line;
	      while((line = in.readLine())!=null){
	          String[] pair = line.split("->");
	     //     keys.add(pair[0]);
	          valuestmp.add(pair[1]);
	      }
	    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	    for (String myInt :valuestmp) 
        { 
          values.add(Integer.valueOf(myInt)); 
        }
	  
	  /*  char[] chars = keys.toString().toCharArray();

	    for (char i : chars){
	       System.out.print(i);
	    }
	    System.out.println();*/
	    int[] freq = new int[values.size()];
	    for (int i=0; i < freq.length; i++)
	    {
	        freq[i] = values.get(i).intValue();
	    }
	    
	   /* for (int i : freq){
		       System.out.println(i);
		    }*/
	return freq;
    }
    public static char[] readDatachars() {
    	  ArrayList<String> keys = new ArrayList<>();
    	  try(BufferedReader in = new BufferedReader(new FileReader("C:\\\\Users\\\\lampr\\\\eclipse-workspace\\\\Data_structure_exercise\\\\frequency.dat"))){
    	      String line;
    	      while((line = in.readLine())!=null){
    	          String[] pair = line.split("->");
    	        keys.add(pair[0]);
    	     //     valuestmp.add(pair[1]);
    	      }
    	    } catch (FileNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	  char[] chars = keys.toString().toCharArray();

  	    return chars;
    }
}
