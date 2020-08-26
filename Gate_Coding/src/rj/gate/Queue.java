package rj.gate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * @author rkalyada
 *
 * @param <T>
 */

public class Queue<T>  {
	private Queue<T> next=null;
	private T data;
	
	
	
	/**
	 * @param t
	 */
	public void push(T t){
		Queue<T> temp=this;	
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=new Queue<T>();
		temp.data=t;		
		
	}
	
	/**
	 * @param index
	 * @return
	 */
	public T get(int index){
		Queue<T> temp=this;
		if(index>=this.size())
			throw new ArrayIndexOutOfBoundsException();
		for(int i=0;i<index;i++){
			temp=temp.next;
		}		
		return temp.data;
	}
	
	public T peek(){
		return this.get(this.size()-1);
	}
	
	public int size(){
		Queue<T> temp=this;
		int count=0;
		while(temp.next!=null){
			temp=temp.next;
			++count;
		}
		return count;			
	}
	
	@SuppressWarnings("unchecked")
	public T[] toArray(){
		Queue<T> temp=(Queue<T>) this;
		T[] object = (T[]) Array.newInstance(this.data.getClass(), this.size());
		int index=0;
		while(temp.next!=null){
			object[index++]=(T)temp.data;			
			temp=temp.next;
		}
		return (T[])object;
	}
	
	
	
	public T pop() {
		Queue<T> temp=this;
		while(temp.next.next!=null){
			temp=temp.next;
		}
		temp.next=null;
		return temp.data;		
	}
	
	public static void main(String[] args){
		Queue<Integer> queue = new Queue<Integer>();
		java.util.Queue<Integer> t = new PriorityQueue<Integer>(11);		
		queue.push(1);
		queue.push(2);
		queue.push(3);		
		queue.push(4);
		queue.pop();
		queue.push(5);
		queue.push(6);	
		queue.push(7);
		queue.push(8);
		queue.push(9);
		queue.push(10);
		queue.push(11);
		queue.pop();
		System.out.println(Arrays.deepToString(queue.toArray()));
		System.out.println(queue.size());
		System.out.println("Peek value of Stack: "+queue.peek());		 
	}	
}
