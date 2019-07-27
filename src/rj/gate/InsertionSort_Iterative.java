package rj.gate;

import java.util.Arrays;

public class InsertionSort_Iterative {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[]{3,2,5,0,9,6};
		//insertionSort(arr);
		insertionSort_recu(arr, 1);
		System.out.println(Arrays.toString(arr));


	}

	static void insertionSort_recu(int[] a,int i){
		if(i<a.length){
			insert(a,i-1,a[i]);
			insertionSort_recu(a, i+1);
		}
		return;		
	}
	static void insert(int a[],int j,int key){
		if(j>=0 && a[j]>key){
			a[j+1]=a[j];
			insert(a, j-1, key);
		}else{
			a[j+1]=key;
			return;}		
	}
	static void insertionSort(int[] a){
		int key;
		int j=0;
		for(int i=1;i<a.length;i++){ //omitting first index
			key=a[i];
			j=i-1;
			while(j>=0 && a[j]>key){
				a[j+1]=a[j];
				j--;
			}
			a[j+1] = key;
		}
	}

}
