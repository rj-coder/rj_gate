package rj.gate;

import java.lang.reflect.Array;
import java.util.Arrays;


/**
 * @author rkalyada
 *
 * @param <T>
 */

public class Stack<T>  {
	private Stack<T> next=null;
	private T data;
	
	
	
	/**
	 * @param t
	 */
	public void push(T t){
		Stack<T> temp=this;	
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=new Stack<T>();
		temp.data=t;		
		
	}
	
	/**
	 * @param index
	 * @return
	 */
	public T get(int index){
		Stack<T> temp=this;
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
		Stack<T> temp=this;
		int count=0;
		while(temp.next!=null){
			temp=temp.next;
			++count;
		}
		return count;			
	}
	
	@SuppressWarnings("unchecked")
	public T[] toArray(){
		
		T[] object = (T[]) Array.newInstance(this.data.getClass(), this.size());
		object=traverse(this,object,this.size()-1);
		return object;
	}
	
	private T[] traverse(Stack<T> temp,T[] object,int i){
		if(temp.next==null){
			return object;
		}
		else{
			traverse(temp.next,object, i-1);
			object[i]=temp.data;
		}
		return object;
		
	}
	
	public T pop() {
		Stack<T> temp=this;
		while(temp.next.next!=null){
			temp=temp.next;
		}
		temp.next=null;
		return temp.data;		
	}
	
	public static void main(String[] args){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);		
		stack.push(4);
		stack.pop();
		stack.push(5);
		stack.push(6);	
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(10);
		stack.push(11);
		stack.pop();
		System.out.println(Arrays.deepToString(stack.toArray()));
		System.out.println(stack.size());
		System.out.println("Peek value of Stack: "+stack.peek());		 
	}	
}
