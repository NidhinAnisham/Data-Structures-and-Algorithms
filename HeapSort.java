/*
 * Author: Nidhin Anisham
 * Title: Assignment 3 - Heap Sort
 * Class: CS 5343.004
 */

public class HeapSort {
	public void heapify(int[] a,int i) {
		int max = i;
		int left = i*2;
		int right = i*2 +1;
		
		//find largest of root, right child and left child
		if (left <= a[0] && a[left] > a[i]) 
            max = left; 
        if (right <= a[0] && a[right] > a[max]) 
            max = right; 
  
        // If largest is one of the children 
        if (max != i) 
        { 
            int tmp = a[i]; 
            a[i] = a[max]; 
            a[max] = tmp; 
  
            //percolate down by recursive call to subtree 
            heapify(a, max); 
        } 
		
	}
	
	public void sort(int[] a) {
		//build a max heap 
		for(int i = a[0]/2;i>0;i--) 
			heapify(a,i);
		
		System.out.println("\n\nArray after converting to heap:");
		for(int i=1;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		
		while(a[0]>1){
			
			//put max element in the right place at the end of the array
			int temp = a[1];
			a[1] = a[a[0]];
			a[a[0]] = temp;
			
			a[0] = a[0]-1;	//decrement size of heap	
			heapify(a,1); //to preserve heap property
		}
	}
	
	public static void main(String[] args) {
		//int[] to_sort = {11,21,15,25,3,5,12,7,19,45,2,9};
		int[] to_sort = new int[21];
		to_sort[0] = to_sort.length-1;  //stores size of unsorted heap
		
		//generate array of random 20 integers from 1 to 100
		System.out.println("Array to be sorted:");
		for(int i=1;i<=to_sort[0];i++) {
			to_sort[i] = (int)(Math.random()*100 + 1);
			System.out.print(to_sort[i]+" ");
		}
		
		//creating object to call sort function
		HeapSort temp = new HeapSort();
		temp.sort(to_sort);
		
		System.out.println("\n\nSorted Array:");
		for(int i=1;i<to_sort.length;i++) {
			System.out.print(to_sort[i]+" ");
		}
		
	}

}
