package com.rj.gate.coding;

import java.util.Random;

/* General Approach
 * @Author: Raju Kalyadapu
 * @
 * */

public class MinMax {
	private static int min,max=0;
	
	public static void main(String[] args) {
		Random m=new Random();
		int arraySize=8;
		int[] inputArray=new int[arraySize];
		for(int i=0;i<arraySize;i++)
			inputArray[i]=m.nextInt(30);
		for(int i=0;i<inputArray.length;i++){
			System.out.print(inputArray[i]+" ");
		}
		System.out.println();
		findMinMax(inputArray);
		System.out.println("Minimum: "+min);
		System.out.println("Maximum: "+max);
	}

	private static void findMinMax(int[] aArray){
		max=min= aArray[0];
		for(int j=1;j<aArray.length-1;j++){ 
			if(aArray[j]>max)
				max=aArray[j];			
			else 
				if(aArray[j]<min)
					min=aArray[j];
			/* Time Complexity:-
			 * =============== 
			 * T(n) = (n-1) if it is in increasing Order 
			 * T(n) = (n-1)+(n-1) if it is decreasing Order
			 * T(n) = (n-1)/2+(n-1)/2+(n-1)/2 if 50% if and 50% else
			 * T(n) = 3/2(n-1)
			 * T(n) = O(1.5n-1.5)           
			 */
		}
	}
}
