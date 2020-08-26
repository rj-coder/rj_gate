package com.rj.gate.coding;

public class BinaryTreeTest{
	public static void main(String...strings){
		BinaryTree binaryTree=new BinaryTree(60);	
		binaryTree.insert(40);
		binaryTree.insert(80);
		binaryTree.insert(30);
		System.out.println(binaryTree.height(binaryTree));
		binaryTree.printBinaryTree(binaryTree);
	}

}
