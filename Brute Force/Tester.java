//Arthur Kraus
//CS 375

package BruteForceDFS;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tester{
	public static void main(String[] args) throws IOException {
		
		//File file = new File(args[0]); 
	    //Scanner sc = new Scanner(file); 
		
		File file = new File("src/BruteForceDFS/input.txt"); 
	    Scanner sc = new Scanner(file); 
	    
	    String[] str = sc.nextLine().split(",");
	    if (str.length != 2) { System.out.println("Incorrect input file type"); }
	    int numItems = Integer.parseInt(str[0]);
	    int capacity = Integer.parseInt(str[1]);

	    int[] profits = new int[numItems];
	    int[] weights = new int[numItems];
	    
	    for (int i = 0; i < numItems; i++) {
	    	str = sc.nextLine().split(",");
	    	weights[i] = Integer.parseInt(str[0]);
	    	profits[i] = Integer.parseInt(str[1]);
	    	//System.out.println("" + weights[i] + " " + profits[i]);
	    }
	    
	    //SORT BY PROFIT/WEIGHT // INSERTION SORT
	    for (int i = 0; i < numItems; i++) {
	    	for (int j =0; j < i; j++) {
	    		if (profits[j]/weights[j] < profits[i]/weights[i]) {
	    			int tempprofits = profits[i];
	    			int tempweights = weights[i];
	    			
	    			profits[i] = profits[j];
	    			weights[i] = weights[j];
	    			
	    			profits[j] = tempprofits;
	    			weights[j] = tempweights;
	    			
	    		}
	    	}
	    }
	    
	    Item[] items = new Item[numItems];
	    //TODO
	    for (int i = 0; i < numItems; i++) {
	    	items[i] = new Item(weights[i], profits[i]);
	    }
	    
	    
	    
	    
	    
	    //for (int i = 0; i < numItems; i++) {
	    //	System.out.println("" + (profits[i] +" "+ weights[i]));
	    //}
	    
	    //RUN PROGRAM
	    int[] vals = BruteForce.knapsack(items, capacity);

	    System.out.println("Weight: " + vals[0]);
	    System.out.println("Profit: " + vals[1]);
	    
	    //SET UP OUTPUT
	    //PRINT FILE
	    //OUTPUT FILE
	    //File fileO = new File("src/BestFirstSearch/output.txt");
        //fileO.createNewFile();
	    FileOutputStream outputStream 
	    = new FileOutputStream("src/BruteForceDFS/output.txt");
	    outputStream.write(("" + vals[0] + "\n").getBytes());
	    outputStream.write(("" + vals[1] + "\n").getBytes());
	    outputStream.close();
	    return;
	}
	    
}