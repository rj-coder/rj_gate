package rj.gate;

import java.lang.reflect.Array;
import java.util.Arrays;


public class LinkedList<T>  {
	private LinkedList<T> next=null;
	private T data;



	

	public LinkedList() {
		
	}

	public void add(T t){
		LinkedList<T> temp=this;	
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=new LinkedList<T>();
		temp.data=t;		
	}

	public T get(int index){
		LinkedList<T> temp=this;
		if(index>=this.size())
			throw new ArrayIndexOutOfBoundsException();
		for(int i=0;i<index;i++){
			temp=temp.next;
		}

		return temp.data;
	}
	public int size(){
		LinkedList<T> temp=this;
		int count=0;
		while(temp.next!=null){
			temp=temp.next;
			++count;
		}
		return count;			
	}

	@SuppressWarnings("unchecked")
	public T[] toArray(){
		LinkedList<T> temp=(LinkedList<T>) this;
		T[] object = (T[]) Array.newInstance(this.data.getClass(), this.size());
		int index=0;
		while(temp.next!=null){
			object[index++]=(T)temp.data;			
			temp=temp.next;
		}
		return (T[])object;
	}


	public static void main(String[] args){
		LinkedList<Integer> t =new  LinkedList<Integer>();
		t.add(1);
		t.add(3);
		t.add(5);
		t.add(9);
		t.add(11);
		t.add(13);
		t.add(15);
		t.add(17);
		System.out.println(t.size());
		//jSystem.out.println(t.get(8));
		Object[] a=t.toArray();
		System.out.println(Arrays.deepToString(a));


	}
}
