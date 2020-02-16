/*
* Author: Nidhin Anisham
*/

import java.io.*; 
import java.math.*;

public class SpellCheckerHashTable {
	
	int tableSize = 53; //initial table size
	int collision;
	String[] hashtable;
	
	SpellCheckerHashTable(){  //constructor to initialize hash table
		this.tableSize = 53;
		this.collision = 0;
		this.hashtable = new String[tableSize];
	}
	
	int hash(String s) { //hash function = adds alphabetical value(i.e a=0,b=1 etc.) % tableSize
		int ascii = 0;
		for (int i = 0; i < s.length(); i++){
		    ascii += ((int)s.charAt(i) - 97);        
		}
		return ascii%tableSize;
	}
	
	void linearprobeinsert(int in,String s) { //function to insert using linear probe
		if(hashtable[in] == null) {
			hashtable[in] = s;
		}
		else {
			collision++;
			in++;
			linearprobeinsert(in%tableSize,s);
		}
	}
	
	int linearprobesearch(int in,String s,int col) { //function to search in linear probe table
		if(col >= tableSize) {
			System.out.println("No of collisions: "+col);
			return -1;
		}
		else if(hashtable[in] == null) {
			System.out.println("No of collisions: "+col);
			return -1;
		}
		else if(hashtable[in].equals(s)) {
			System.out.println("No of collisions: "+col);
			return in;
		}
		else {
			col++;
			in++;
			return linearprobesearch(in%tableSize,s,col);
		}
	}
	
	int quadraticprobesearch(int in,String s,int i,int col) { //function to search in linear probe table
		if(col >= tableSize) {
			System.out.println("No of collisions: "+col);
			return -1;
		}
		else if(hashtable[in] == null) {
			col++;
			in = in + (i*i);
			return quadraticprobesearch(in%tableSize,s,i,col);
		}
		else if(hashtable[in].equals(s)) {
			System.out.println("No of collisions: "+col);
			return in;
		}
		else {
			col++;
			in = in + (i*i);
			return quadraticprobesearch(in%tableSize,s,i,col);
		}
	}
	
	void quadraticprobeinsert(int in,String s,int i) {  //function to insert using quadratic probe
		if(hashtable[in] == null) {
			hashtable[in] = s;
		}
		else {
			collision++;
			in = in + (i*i);
			quadraticprobeinsert(in%tableSize,s,++i);
		}
	}
	
	void increase_ts() { //function to increase table size
	    BigInteger b = new BigInteger(String.valueOf(2*tableSize)); 
	    tableSize = Integer.parseInt(b.nextProbablePrime().toString());  //to get the next prime number after 2*table size
	    hashtable = new String[tableSize];
	    System.out.println("Collision count: "+collision);
	    collision = 0;
	}
	
	void insert(boolean flag) throws Exception{  //general insert function to parse through the file
		File file = new File("src/110words.txt"); //change input file path here
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String[] st = new String[110];
		String temp;
		int i = 0;
		float count = 0;
		while((temp = br.readLine()) != null) {
			st[i] = temp;
			i++;
		}
		br.close();	
		System.out.println("Original table size: "+tableSize);
		for(i=0;i<st.length;i++) {
			count++;
			if(flag) {
				linearprobeinsert(hash(st[i]),st[i]);
			}
			else {
				quadraticprobeinsert(hash(st[i]),st[i],1);
			}
			if((count/tableSize) > 0.5) { //increase table size if load factor is > 0.5
				increase_ts();
				System.out.println("Load factor > 0.5");
				System.out.println("Table size increased to "+tableSize);
				i = 0;
				count = 0;
			}
		}
		System.out.println("Collision count: "+collision);
	}
	

	public static void main(String[] args) throws Exception{ 
		System.out.println("Using linear probe to insert:");
		SpellCheckerHashTable temp = new SpellCheckerHashTable();
		temp.insert(true);
		System.out.println();
		
		System.out.println("Using quadratic probe to insert:");
		SpellCheckerHashTable temp2 = new SpellCheckerHashTable();
		temp2.insert(false);
		
		String s;
		int location_lp;
		int location_qp;
		BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nEnter a string (enter quit to exit):"); 
 		s = ob.readLine();
		while(!s.equals("quit")) {
			
	 		location_lp = temp.linearprobesearch(temp.hash(s),s,0);
	 		
	 		if(location_lp < 0) {
	 			System.out.println("Element not found in linear probe table!");
	 		}
	 		else {
	 			System.out.println("Using linear probe element found in location:"+location_lp);
	 		}
	 		System.out.println();
	 		location_qp = temp2.quadraticprobesearch(temp2.hash(s),s,1,0);
	 		if(location_qp < 0) {
	 			System.out.println("Element not found in quadratic probe table!");
	 		}
	 		else {
	 			System.out.println("Using quadratic probe element found in location:"+location_qp);
	 		}
	 		
			System.out.println();
			System.out.println("\nEnter a string (enter quit to exit):"); 
	 		s = ob.readLine();
		}
 		
	}
}
