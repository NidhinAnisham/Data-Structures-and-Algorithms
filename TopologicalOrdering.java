/*
* Author: Nidhin Anisham
*/

import java.util.Stack; 

public class TopologicalOrdering {
	
	//Function to print vertices
	public void printGraph(int[][] am,int v) {
		for(int i=0;i<v;i++) {
			for(int j=0;j<v;j++) {
				if(am[i][j]>0) {
					System.out.print("("+i+","+j+")  ");
				}
			}
		}
		System.out.println();
	}
		
	//function for performing depth-first-search recursively
	public void dfs(int i, int[][] a, boolean[] v, boolean[] d,Stack<Integer> s) {
		v[i] = true;
		for(int j = 0;j<a.length;j++) {
			if(a[i][j] == 1) { //checking for adjacent nodes of current node
				if(!v[j]) {
					dfs(j,a,v,d,s); //if node has not been visited, do recursive dfs
				}
				else {
					if(d[j] == false) //if node has been visited but not done ordering, there is a cycle
						return;
				}
			}
		} 
		
		d[i] = true; //setting done flag once the node is ordered
		s.push(new Integer(i)); //pushing the node to the ordered stack
	}
	
	public void topo_DFS(int[][] a,boolean[] v,boolean[] d) {
		Stack<Integer> topo_order = new Stack<>(); //the order is being stored in a stack
		int count = 0; 
		for(int i=0;i<a.length;i++) {  //running dfs on all nodes that have not been visited
			if(v[i]== false) {
				dfs(i,a,v,d,topo_order);
			}
		}
		System.out.println("\nTopological Ordering:");
		while(topo_order.empty()==false) {  //printing all ordered nodes
			System.out.print(topo_order.pop()+" ");
			count++;
		}
		if(count!=v.length) { //if there is a cycle, recursion is stopped abruptly and all nodes are not ordered
			System.out.println("\nCycle detected.");
		}
	}
	public static void main(String[] args) {
		
		int vertices=12,count=0; //number of vertices = 12
		int[][] adjacency_matrix_1 = new int[vertices][vertices];   //adjacency matrix for graph with cycle
		int[][] adjacency_matrix_2 = new int[vertices][vertices];   //adjacency matrix for graph without cycle
		boolean[] visited_1 = new boolean[vertices];  //visited flag array
		boolean[] visited_2 = new boolean[vertices];
		boolean[] done_1 = new boolean[vertices];  //done flag array to denote that element is done being ordered
		boolean[] done_2 = new boolean[vertices];
        
		///graph without cycle
		int weights_2[] = {0,0,1,1,1,0,0,0,0,0,0,0,
				 		   0,0,0,0,0,0,0,0,0,0,0,0,
				 		   0,0,0,0,0,1,0,0,0,0,0,0,
				 		   0,0,0,0,0,1,0,0,0,0,0,0,
				 		   0,0,0,1,0,0,0,0,0,0,0,0,
				 		   0,0,0,0,0,0,0,0,0,0,1,1,
				 		   0,0,0,1,0,0,0,0,0,0,0,1,
				 		   0,0,0,0,0,0,1,0,0,0,0,0,
				 		   0,0,0,0,0,0,1,0,0,1,0,0,
				 		   0,0,0,0,0,0,0,0,0,0,0,0,
				 		   0,0,0,0,0,0,0,0,0,1,0,1,
				 		   0,0,0,0,0,0,0,0,0,0,0,0
						};
	    
		//graph with cycle
		int weights_1[] = {0,0,1,1,1,0,0,0,0,0,0,0,
						 0,0,0,0,0,0,0,0,0,0,0,0,
						 0,0,0,0,0,1,0,0,0,0,0,0,
						 0,0,0,0,0,1,0,0,0,0,0,0,
						 0,0,0,1,0,0,0,0,0,0,0,0,
						 0,0,0,0,0,0,0,0,0,0,1,1,
						 0,0,0,1,0,0,0,0,0,0,0,1,
						 0,0,0,0,0,0,1,0,0,0,0,0,
						 0,0,0,0,0,0,1,0,0,1,0,0,
						 0,0,0,0,0,0,1,0,0,0,0,0,
						 0,0,0,0,0,0,0,0,0,1,0,1,
						 0,0,0,0,0,0,0,0,0,0,0,0
						};
        
		//placing elements of weights in the matrix and initializing visited and done array
		for (int i=0;i<vertices;i++)
        {
	        for (int j = 0;j<vertices;j++)
            {
	        	    adjacency_matrix_1[i][j] = weights_1[count]; //storing weights in adjacency matrix
	        	    adjacency_matrix_2[i][j] = weights_2[count]; //storing weights in adjacency matrix
	        	    count++;
            }
	        visited_1[i] = false;
	        done_1[i] = false;
	        visited_2[i] = false;
	        done_2[i] = false;
        }
       
        TopologicalOrdering temp = new TopologicalOrdering();
        System.out.println("Input Graph with cycle:");
        temp.printGraph(adjacency_matrix_1, vertices);
        temp.topo_DFS(adjacency_matrix_1, visited_1, done_1);
        System.out.println("---------------------------------------------------------");
        System.out.println("\nInput Graph without cycle:");
        temp.printGraph(adjacency_matrix_2, vertices);
        temp.topo_DFS(adjacency_matrix_2, visited_2, done_2);
	}
}
