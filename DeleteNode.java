public class DeleteNode {
	//Class for storing the nodes of the tree
	static class Node{
		Node left;
		Node right;
		int data;	
		public Node(int nodeData) {
            this.data = nodeData;
            this.left = null;
            this.right = null;
        }
	}
	
	//Class for binary search tree
	static class BST {
		Node root;
		public BST() {
            this.root = null;
        }
		
		//inserting element into bst
		Node insert(Node root, int data) {
			if (root == null) { 
	            root = new Node(data); 
	            return root; 
	        } 
	        if (data < root.data) 
	            root.left = insert(root.left, data); 
	        else if (data > root.data) 
	            root.right = insert(root.right, data); 
	        return root; 
			
		}
		
		//inorder traversal of bst
		void inorder(Node root) { 
	        if (root != null) { 
	            inorder(root.left); 
	            System.out.print(root.data + "\t"); 
	            inorder(root.right); 
	        } 
	    } 
	
	
		Node delete(Node root, int data) { 
	        if (root == null)  return root; 
	        Node head = root;
	        Node parent = root;
	        
	        //traversing the tree to find the node to be deleted
	        while(root.data!=data) {
	        	parent = root; //stores parent of the node 
	        	if(data>root.data) 
	        		root = root.right;
	        	else
	        		root = root.left;
	        }
	        
	        //case where node to be deleted has only one left child or no children
	        if(root.left == null) {
	        	if(parent.left == root)
	        		parent.left = root.right;
	        	else
	        		parent.right = root.right;
	        }
	        
	        //case where node to be deleted has only one right child
	        else if(root.right == null){
	        	if(parent.left == root)
	        		parent.left = root.left;
	        	else
	        		parent.right = root.left;
	        }
	        
	        //case where node to be deleted has two children
	        else { 
	        		//finding predecessor by going to left node and the going to last right node
	        		Node temp = root.left;
	        		while(temp.right!=null) {
	        			if(temp.right!=null) {
	        				parent = temp; //parent is used for storing the parent of the predecessor
	        			}
	        			temp = temp.right;        		        	
	        		}
	        		root.data = temp.data; //copying data of predecessor to deleted node
	        		parent.right = temp.left;  //deleting predecessor
	        }
	        return head; 
	    } 
	}
	
	public static void main(String[] args){	
		BST tree1 = new BST();
		int[] keys = { 100, 50, 200, 150, 300, 25, 75, 12, 37, 125, 175, 250, 320, 67, 87, 94, 89,92,88 }; //array to pass tree elements

		for (int key : keys) {
			tree1.root = tree1.insert(tree1.root, key);
		}
		System.out.println("Before deletion:");
		tree1.inorder(tree1.root);
		System.out.println();
		System.out.println("\nAfter deletion:");
		tree1.root = tree1.delete(tree1.root, 100);
		tree1.inorder(tree1.root);
	}	
}