package rj.gate;
import rj.gate.Node;
public class SinglyLinkedList {
	Node head;
	public void insert(int data){
		Node curNode=head;
		if(head==null){
			head=new Node();
			head.setData(data);
			head.setLink(null);						
		}
		else{
			while(curNode.getLink()!=null)				
				curNode=curNode.getLink();
			Node newNode=new Node();
			newNode.setData(data);
			newNode.setLink(null);
			curNode.setLink(newNode);		

		}

	}
	public boolean isEmpty(){
		return (head==null);

	}

	public void insertAt(int data,int position) throws Exception{
		if(position<1){
			throw new Exception("Insertion Index is not Valid");
		}
		if(position==1){
			Node newNode=new Node();
			newNode.setData(data);
			newNode.setLink(head);	
			head=newNode;
		}
	}
	public int count(){
		Node curNode=head;
		int count=0;
		if(curNode==null){
			return 0;
		}else{
			while(curNode!=null){
				curNode=curNode.getLink();
				++count;
			}
		}
		return count;
	}
	public void deleteAt(int position) throws Exception{
		Node curNode=head;
		if(head==null){
			throw new Exception("Linked List is Empty");
		}else if(head!=null&&position==1){
			head=(curNode.getLink());
			
		}else if(head!=null&&position>count()){
			throw new Exception("Index out of Bounds");
		}
		else{
			int count=1;// 
			Node temp=curNode;
			while(count!=position){
				temp=curNode;
				curNode=curNode.getLink();				
				count++;				
			}
			temp.setLink(curNode.getLink());
			
		}
		
	}
	public String toString(){
		Node temp=head;
		String tempString="";
		while(temp!=null){
			tempString=tempString+temp.getData()+"  ";			
			temp=temp.getLink();

		}
		return tempString;

	}
	
	public void reverseLinkedList() throws Exception{
		Node node=head;
		if(node==null)
			throw new Exception("LinkedList is Empty");
		Node q=null;
		Node r;		
		while(node!=null){
			r=q;
			q=node;
			node=node.getLink();
			q.setLink(r);			
		}
		head=q;
		
	}
	
	public void reverseList(Node pre,Node temp){
		if(temp!=null){
			reverseList(temp,temp.getLink());
			temp.setLink(pre);		}
		else{
			head=pre;
		}
			 
		
	}




}
