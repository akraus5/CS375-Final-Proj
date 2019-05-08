//Arthur Kraus
//CS 375 Proj

package BruteForceDFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class BruteForce{
	@SuppressWarnings("null")
	public static  int[] knapsack(Item[] items, int capacity) {
		long startTime = System.nanoTime();
		
		int NUMITEMS = items.length;

		Node optimalSol = new Node();
		optimalSol.level = 0;
		optimalSol.weight = 0;
		optimalSol.profit = 0;
		
		Deque<Node> stack = new LinkedList<Node>();
		Node root = new Node();
		stack.add(root);
		while (!stack.isEmpty()) {
			Node X = stack.pop();
			//System.out.print("" + X.level + "");
			if (X.level < NUMITEMS){

				//System.out.println("NOT LEAF");
				
				if (X.Yes == null) {
					X.Yes = new Node();
					X.Yes.level = X.level + 1;
					X.Yes.weight = X.weight + items[X.level].getWeight();
					X.Yes.profit = X.profit + items[X.level].getProfit();
					stack.add(X.Yes);
				}
				if (X.No == null) {
					X.No = new Node();
					X.No.level = X.level + 1;
					X.No.weight = X.weight;
					X.No.profit = X.profit;
					stack.add(X.No);
				}
			}
			else {
			//	System.out.println("LEAF");
				if ((X.weight <= capacity)&&(optimalSol.profit < X.profit)) optimalSol = X;	
			}
			X.visited = true;
		}
		
		int[] retVal = new int[2];
		retVal[0] = optimalSol.weight;
		retVal[1] = optimalSol.profit;
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		//System.out.println("Total NanoSeconds: " + totalTime);
		return retVal;
	}
}

class Node{
	public int level;
	public int profit;
	public int weight;
	public boolean visited;
	public Node Yes;
	public Node No;
	
	public Node() {
		level = 0;
		profit = 0;
		weight = 0;
		visited = false;
		Yes = null;
		No = null;
		}
	}