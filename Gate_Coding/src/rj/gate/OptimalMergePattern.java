package rj.gate;

import java.util.Arrays;	
/**
	Input: 
	N sorted arrays of length L[1], L[2],...,L[n] 
	
	Problem: 
	Ultimateley, to merge the arrays pairwise as fast as possible. 
	The problem is to determine which pair to merge everytime. 
	
	Method (the Greedy method): 
	The selection policy (of which best pair of arrays to merge next) is to choose the two shortest remaining arrays. 
	 Implementation:
	 Need a data structure to store the lengths of the arrays, 
	 to find the shortest 2 arrays at any time, to delete those lengths, 
	 and insert in a new length (for the newly merged array). 
	
	 In essence, the data structure has to support delete-min and insert. Clearly, a min-heap is ideal. 	
	
	Time complexity of the algorithm: The algorithm iterates (n-1) times. 
	At every iteration two delete-mins and one insert is performed. The 3 operations take O(log n) in each iteration. 
	
	Selection Sort is an Application of Greedy Method
 */

public class OptimalMergePattern {

	//11 5 8 82 99

	private static int noOfRecords;
	private static int[] noOfRecordMovements;

	public static void main(String[] args) {
		int[] inputArray = new int[]{11, 12, 24, 34, 34, 34 ,45 ,56, 56, 73, 78, 91, 91};
		SortAlgorithms.mergeSort(inputArray, 0, inputArray.length-1);
		System.out.println(Arrays.toString(inputArray));
		optimalMergePattern(inputArray);	
		int totalNoOfRecordMovements=0;
		for(int i=0;i<noOfRecordMovements.length;i++)
			totalNoOfRecordMovements+=noOfRecordMovements[i];
		System.out.println(Arrays.toString(noOfRecordMovements));
		System.out.println("Total No. of Record Movements: "+totalNoOfRecordMovements);

	}



	public static void optimalMergePattern(int[] aArray){
		noOfRecords=aArray.length-1;
		noOfRecordMovements= new int[noOfRecords];
		int sum=0;
		int j=0;
		for(int i=0;i<noOfRecords;j++){			
			sum=aArray[i]+aArray[i+1];				
			noOfRecordMovements[j]=sum;
			aArray[i+1]=sum;
			aArray[i]=0;
			SortAlgorithms.mergeSort(aArray, i+1, aArray.length-1);
			i=i+1;
		}
	}

}
