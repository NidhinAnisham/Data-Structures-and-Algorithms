# Data-Structures-and-Algorithms
Short programs on data structures and algorithms

DeleteNode.java
Program to delete a Node in a Binary Search Tree by using Predecessor

1. Compile & Run!
2. For changing the input data, edit variable "keys" in main()

Logic for finding predecessor of node to be deleted(delnode):
1. Go to delnode.left
2. Keep parsing through right values until right = null

There are three cases to deleting the node:
1. There are no child nodes
--Set child of parent to null

2. There is one child node
--Set parent to point to the child of the node to be deleted 

3. There are two children
--Find predecessor. Copy data of predecessor to the node to be deleted.
--Set parent of predecessor to point to predecessor.left as predecessor.right is null in all cases.

_____________________________________________________________________________________________________________________________

SelectionSort.java
Program to perform selection sort on Linked List by swapping nodes instead of just node data.

1. Compile & Run!
2. For changing the input data, edit variable "array" in main()

Logic for swapping min with current:
1. Swap next values of both current and min
2. Swap next values of nodes previous to current and min

There are four cases:
1. Swap elements that are not next to each other
--Use logic above

2. Swap between head and an element that is not next to the head
--make element as head and make head.next as the old head and old head.next as element.next

3. Swap between head and element next to it
--make head.next as element.next and make element.next as old head. Make element as head

4. Swap elements next to each other
--make current1.next as min.next and make min.next as current1. Make element previous to current1 point to min 

__________________________________________________________________________________________________________________________________

HeapSort.java
Performing heap sort on an array

1. Compile & Run!
2. For changing the input data, edit variable "to_sort" in main()
3. Input array of 20 elements is dynamically created by using Math.random()
4. a[0] contains size of unsorted heap

Heap Sort:
1. Create a max heap from the array by percolating max value up
2. Loop through the array
3. Swap a[1] and a[a[0]]
4. Decrement size of heap i.e. a[0]
5. Heapify root and subtrees using recursion

__________________________________________________________________________________________________________________________________

DijkstrasAlgorithm.java
Implementing the dijkstras algorithm to find the shortest path in a graph

1. Compile & Run!
2. For changing the input data, edit variable "weights" in main() and update "vertices"
3. Adjacency matrix representation is used for graph

__________________________________________________________________________________________________________________________________

TopologicalOrdering.java
Obtaining the topological ordering of a graph and detecting if there is a cycle in the graph

1. Compile & Run!
2. For changing the input data, edit variable "weights" in main() and update "vertices"
3. Adjacency matrix representation is used for graph
