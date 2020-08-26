package com.rj.gate.coding;
public class LinkedListTest {
	
	public LinkedListTest() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String...strings) throws Exception {
		SinglyLinkedList h=new SinglyLinkedList();
		h.insert(3);
		h.insert(4);
		h.insert(5);
		h.insert(6);
		h.insert(7);
		h.insert(8);
		h.insert(9);
		System.out.println("No.Of Nodes: "+h.count());
		//System.out.println(h.toString());
		//h.reverseLinkedList();
		h.deleteAt(21);
		//h.reverseList(null,h.head);
		 
		
		
		System.out.println(h.toString());
	}

}
