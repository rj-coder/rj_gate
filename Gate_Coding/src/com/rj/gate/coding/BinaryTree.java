package com.rj.gate.coding;

public class BinaryTree{
	private BinaryTree left;
	private BinaryTree right;
	private int data;
	public BinaryTree getLeft() {
		return left;
	}

	public void setLeft(BinaryTree left) {
		this.left = left;
	}

	public BinaryTree getRight() {
		return right;
	}

	public void setRight(BinaryTree right) {
		this.right = right;
	}


	public BinaryTree(int data) {
		this.left=null;
		this.right=null;
		this.data=data;
	}

	public int 	height(BinaryTree head){
		if(head==null){
			return -1;
		}else{
			return 1+max(height(head.left),height(head.right));
		}		
	}

	private int max(int i, int j) {
		return i>j?i:j;
	}

	public void insert(int i) {		
		if(i<=this.data)
			traverseLeftSubTree(this.left,i);
		else
			tranverseRightSubTree(this.right,i);
	}

	private void tranverseRightSubTree(BinaryTree binaryTree,int i) {
		if(binaryTree==null){
			binaryTree = new BinaryTree(i);
			return;
		}else{			
			if(i<=binaryTree.data)
				traverseLeftSubTree(binaryTree.left,i);
			else
				tranverseRightSubTree(binaryTree.right,i);
		}		
	}

	private void traverseLeftSubTree(BinaryTree binaryTree,int i) {
		if(binaryTree==null){
			binaryTree = new BinaryTree(i);
			return;
		}else{			
			if(i<=binaryTree.data)
				traverseLeftSubTree(binaryTree.left,i);
			else
				tranverseRightSubTree(binaryTree.right,i);
		}	
	}

	public void printBinaryTree(BinaryTree binaryTree) {
		if(binaryTree==null)
			return;
		else{
			System.out.println(binaryTree.data);			
			printBinaryTree(binaryTree.left);
			printBinaryTree(binaryTree.right);
		}

	}



}
