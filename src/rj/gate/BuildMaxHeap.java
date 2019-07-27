package rj.gate;

import java.util.Arrays;

public class BuildMaxHeap {
	private static int heap_size;
	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		int[] arr = new int[10];
		int[] arr2= new int[]{100,50,20,1,3,10,5};
		for(int i=0;i<arr2.length;i++)
			arr[i]=arr2[i];
		heap_size = arr2.length-1;
		 
		System.out.println("After Heapify: "+Arrays.toString(arr));
/*		int key = 111;
		int position = 3;
		heap_increase_key(arr,position,key);
		System.out.println(Arrays.toString(arr));
		position = 0;
		key=2;
		heap_decrease_key(arr,position,key);
		key=999;
		heap_insert_key(arr,key);
*/
		heap_sort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	private static void heap_sort(int[] arr){
		build_Max_Heap(arr);
		for(int i=heap_size;i>0;i--){
			swap(arr,i,0);
			heap_size = heap_size-1;			
			max_Heapify(arr, 0);
		}			
	}
	
	private static void build_Max_Heap(int[] arr) {
 		System.out.println(Arrays.toString(arr)); 		
		for(int i=arr.length/2-1;i>=0;i--){ //call max_heapify on non leaf nodes
 			max_Heapify(arr,i);
		}		
	}

	private static void heap_insert_key(int[] arr, int key) {
		heap_size = heap_size +1;
		arr[heap_size] = key;
		int i = heap_size;
		while(i >= 0 && arr[i/2] < arr[i]){
			swap(arr,i/2,i);
			i=i/2;
		}

}		
		
	
	private static void heap_decrease_key(int[] arr, int position, int key) {
		arr[position] = key;
		max_Heapify(arr, position);
	}

	private static void heap_increase_key(int[] arr, int i, int key) {
		if(arr[i] > key)
			System.out.println("Error");
		arr[i]=key;
		while(i >= 0 && arr[i/2] < arr[i]){
			swap(arr,i/2,i);
			i=i/2;
		}
			
		
	}

	private static int heap_Extract_Min(int[] arr) {
		if(heap_size<0)
			System.out.println("OverFlow");
		int max =arr[0];
		arr[0]= arr[heap_size];
 		heap_size = heap_size-1;		
		max_Heapify(arr,0);
 		return max;
	}

	private static void max_Heapify(int[] arr, int i) {
		int leftChild = 2*i+1;
		int rightChild = 2*i+2;
		int largestElement ;

		if(leftChild <= heap_size && arr[leftChild] > arr[i])
			largestElement = leftChild;
		else
			largestElement = i;

		if(rightChild <= heap_size && arr[rightChild] > arr[largestElement])
			largestElement = rightChild;
		
		if(largestElement != i){
  			swap(arr,largestElement,i);			
			max_Heapify(arr, largestElement);			
		}
		
		
	}
	
	private static void swap(int [] arr,int largestElement,int i){
		int temp = arr[largestElement];
		arr[largestElement] = arr[i];
		arr[i]= temp;
	}

}
