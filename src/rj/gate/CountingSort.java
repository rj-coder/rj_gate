package rj.gate;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		int[] arr=new int[]{10,20,13,14,15,9,1,12,16,19,89,76,56,45,78,67,45};
		int max=arr[0];
		for(int i=1;i<arr.length;i++){	//n-1=>O(n-1)
			max=max<arr[i]?arr[i]:max;				
		}
		//System.out.println(max);
		countingSort(arr, max);
		System.out.println(Arrays.toString(arr));

	}

	public static void countingSort(int[] arr,int range){
		int[] temp=new int[range+1];
		for(int i=0;i<arr.length;i++){//Original Array traversed - O(N) Time
			temp[arr[i]]++;
		}
		System.out.println(Arrays.toString(temp));
		for(int i=0,j=0;j<arr.length;){//Auxilary Aray Traversed - Range O(N+K)
			if(temp[i]>0){
				arr[j]=i;
				--temp[i];
				j++;
			}else{
				i++;
			}
		}
	}
}



/**
 * Time Complexity
 * ===============
 * Best: O(n+k)
 * Average: O(n+k)
 * Worst: O(n+k)
 * 
 * Space Complexity
 * ================
 * O(r) */