/*
* Author: Nidhin Anisham
*/

import java.util.PriorityQueue;

public class DijkstrasAlgorithm {
	
	//Function to print vertices and corresponding edge
	public void printGraph(int[][] am,int v) {
		System.out.println("Vertices  |  Edge");
		for(int i=0;i<v;i++) {
			for(int j=0;j<v;j++) {
				if(am[i][j]>0) {
					System.out.println("("+i+","+j+")"+"         "+am[i][j]);
				}
			}
		}
		System.out.println();
	}
	
	//Function implementing Dijkstra's algorithm
	public void getShortestDistance(int[][] am,PriorityQueue<Graph> pq,int vertices,int source) {
		PriorityQueue<Graph> ShortestDistances = new PriorityQueue<>(); //heap to store computed shortest distances
		int count;
		int[] v = new int[vertices];
		int[] d = new int[vertices];
		int[] parent = new int[vertices];
		int[][] out_matrix = new int[vertices][vertices]; //matrix to store output graph
		parent[source] = -1; //root is the source so setting parent to -1
		
		//Loop to calculate shortest distance to each node
		while(!pq.isEmpty()) {
			count = 0;
			Graph temp = pq.remove();
			int current_v = temp.vertex;
			int current_d = temp.distance;
			
			ShortestDistances.add(new Graph(current_v,current_d));
			
			//loop to traverse through the remaining nodes
			while (!pq.isEmpty()) {
				
	            Graph element = pq.remove();
	            v[count] = element.vertex;
				d[count] = element.distance;
				
				//check if there is an edge between source and current vertex
				if(am[current_v][v[count]]>0) {
						
						int new_d = current_d + am[current_v][v[count]];						
						if(new_d < d[count]) { //check if current calculated distance is less than previously calculated distance
							parent[v[count]] = current_v; //to store parent of node
							d[count] = new_d;
						}
					
				}
				count++;
	        }
			
			//updating heap with new distance values
			while(count>0) {
				pq.add(new Graph(v[count-1],d[count-1]));
				count--;
			}
		}
		count = 0;
		
		//getting shortest distances in an array
		for(Graph element : ShortestDistances) {
			//System.out.println(element.vertex+" "+element.distance);
			d[element.vertex] = element.distance;
		}
		
		//creating adjacency matrix for output graph
		for(int i=0;i<vertices;i++) {
			//System.out.print(parent[i]+" ");
			for(int j=0;j<vertices;j++) {
				if(parent[j] == i) {
					out_matrix[i][j] = d[j] - d[i];
				}
			}
		}
		System.out.println("Shortest-Distance Graph:");
		this.printGraph(out_matrix, vertices);
	}
	
	public static void main(String[] args) {
        int vertices=10,count=0,source=0;
        int[][] adjacency_matrix = new int[vertices][vertices];
        
        /*
        int weights[] = {0,10,5,0,0,   
        		         0,0,6,0,1,  
        		         0,3,0,2,9,  
        		         7,0,0,0,6,  
        		         0,0,0,4,0};
             
        
        int weights[] = {0,9,0,0,0,14,15,0,
				         0,0,24,0,0,0,0,0,
				         0,0,0,0,2,0,0,19,
				         0,0,6,0,0,0,0,6,
				         0,0,0,11,0,0,0,16,
				         0,0,18,0,30,0,5,0,
				         0,0,0,0,20,0,0,44,
				         0,0,0,0,0,0,0,0};
		
        
        */
        int weights[] = {0,8,0,0,0,0,0,7,0,5,
				         0,0,7,0,2,0,0,1,0,0,
				         0,10,0,0,0,2,0,0,0,0,
				         0,0,9,0,0,0,0,0,0,0,
				         0,0,7,0,0,0,6,0,0,0,
				         0,0,4,3,0,0,0,0,0,0,
				         0,0,0,0,0,8,0,0,8,0,
				         6,0,0,0,9,0,9,0,3,4,
				         0,0,0,0,0,0,0,0,0,6,
				         2,0,0,0,0,0,0,0,0,0};
        
        PriorityQueue<Graph> GraphPriorityQueue = new PriorityQueue<>();  //Heap to store shortest distances
        
        for (int i=0;i<vertices;i++)
        {
        	if(i!=source) {
        		GraphPriorityQueue.add(new Graph(i,Integer.MAX_VALUE));  //If not source, distance is infinity
        	}
        	else {
        		GraphPriorityQueue.add(new Graph(i,0)); //If source, distance is 0
        	}
 	        for (int j = 0;j<vertices;j++)
                {
 	        	    adjacency_matrix[i][j] = weights[count]; //storing weights in adjacency matrix
 	        	    count++;
                }
         }
         System.out.println("Input Graph:");
         DijkstrasAlgorithm temp = new DijkstrasAlgorithm();
         temp.printGraph(adjacency_matrix, vertices);
         temp.getShortestDistance(adjacency_matrix,GraphPriorityQueue,vertices,source);
	}
}


//Close to store a graph node
class Graph implements Comparable<Graph> {
    int vertex;
    int distance;
    
    //stores node vertex and distance
    public Graph(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    
    //overriding compare function to compare distances of two vertices
    @Override
    public int compareTo(Graph vertex) 
    { 
        if (this.distance < vertex.distance) 
            return -1; 
        if (this.distance > vertex.distance) 
            return 1; 
        return 0; 
    } 
    
}
