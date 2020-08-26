package com.rj.gate.coding;

public class BFSSearch {
	public BFSSearch left;
	public BFSSearch right;
	public int data;

	
	public BFSSearch(int data) {
		this.data=data;
		this.left=null;
		this.right=null;
				
	}
	
	public static void main(String[] args) {
		BFSSearch binaryTree = new BFSSearch(5);
		binaryTree.left=new BFSSearch(3);
		binaryTree.right=new BFSSearch(1);
		binaryTree.left.left=new BFSSearch(92);
		binaryTree.left.right=new BFSSearch(2);
		binaryTree.right.left=new BFSSearch(19);
		binaryTree.right.right=new BFSSearch(23);
		binaryTree.right.right.left=new BFSSearch(56);
		binaryTree.right.right.right=new BFSSearch(31);
		
		binaryTree.printTree(binaryTree);
//	//	if(findElement(binaryTree, 38))
//			System.out.println("found");
//		else
//			System.out.println("not found");
	}
	
	public static boolean findElement(BFSSearch root,int data){
		while(root!=null){
			if(root.data==data)
				return true;
			else{
				findElement(root.left, data);
			//	findElement(root.right, data);
			}
		}
		return false;
	}
	
	/*    			
	 *				5
	 * 			3		1
	 *		null  null	null  23 
	 * 
	 * 
	 */
	
	public static void printTree(BFSSearch root){
		if(root!=null){
			printTree(root.left);
			System.out.println(root.data);
			printTree(root.right);
			

			
		}
		return;
	}

}
