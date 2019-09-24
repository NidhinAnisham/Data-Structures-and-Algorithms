# Data-Structures-and-Algorithms
Short programs on data structures and algorithms

Using DeleteNode.java

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

Using SelectionSort.java

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

