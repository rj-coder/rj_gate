package com.rj.gate.coding;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int[] arr=new int[]{215,19,2,125};	

		int max=arr[0];
		for(int i=1;i<arr.length;i++){	//n-1=>O(n-1)
			max=max<arr[i]?arr[i]:max;				
		}
		System.out.println(max);
		radixSort(arr,max);

		//countingSort(arr, max);
		System.out.println(Arrays.toString(arr));

	}

	private static void radixSort(int[] arr, int max) {
		for(int exp=1;max/exp>0;exp*=10){
			countingSort(arr, exp);
		}


	}

	public static void countingSort(int[] arr,int exp){
		int[] temp=new int[10];	
		int[] bkp =arr.clone();
		for(int i=0;i<arr.length;i++){//Original Array traversed - O(N) Time
			//215   19   10
			//215%10 5  019%10 9  002%10  2
			int lsb=(arr[i]%(exp*10))/(exp);	
			//System.out.print(lsb+" ");
			temp[lsb]=temp[lsb]+1;
		}

		System.out.println(Arrays.toString(temp));

		for(int i=0,j=0,k=0;j<bkp.length;){
			k=0;
			int tvalue;
			if(temp[i]>0)//i==2
				for(;k<arr.length;){
					if(i==(arr[k]%(exp*10))/(exp)){//2#
						tvalue=arr[j];
						arr[j]=arr[k];
						arr[k]=tvalue;
						j++;
						--temp[i];
					}						
					k++;					
				}else
					i++;


		}
		
		
		//System.out.println(Arrays.toString(bkp));

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