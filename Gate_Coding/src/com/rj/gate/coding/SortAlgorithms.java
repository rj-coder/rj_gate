package com.rj.gate.coding;

import java.util.Arrays;


/**@QuickSort_Algorithm
 * divide into half		 
 * select pivot on first half and second half recursively
 * choose pivot element
 * i = m - 1 ;
 * j = m
 * loop until n-1;
 * if a[j]<=key increment i value by 1 and swap i and swap a[i] and a[j]
 * end loop
 * swap a[i+1] a[j]	
 * 
 * */

/**@InsertionSort_Algorithm
 * 
 * loop j from 1 to n-1
 * key=a[j]	  j values can be taken randomly or first value or last value or median
 * i=j-1;
 * loop i>=0 & a[j] > key
 * swap a[i+1] a[i]
 * decrement i value
 * end loop
 * a[i+1]=key;
 *
 *	1. Use to sort when some of the array elements are already sorted need to sort new one's
 *	2. Best Case: if array is already sorted in Increasing Order T(n) = O(n) 
 *  3. Worst Case: if array is sorted in Decreasing Order T(n) = O(n^2)
 *  4. Time Complexity of Insertion Sort depends on Number of Inversions   T(n)= O(n+d) where d= no. Of Inversions
 *  5. No. of Inversion in an array is n(n-1)/2 if it is in worst case. 
 *
 */

/**@MergeSort_Algorithm
 * three steps required to do mergeSort
 * 1. split array into two halves
 * 2. apply mergeSort on left half and right half
 * 3. merge sorted lists
 * 	
 * Time Complexity: T(n) = T(n/2)+ T(n/2) + O(n)	
 * 							2T(n/2)+O(n) = O(nlogn)
 * Space Complexity: S(n) = O(n) 
 * 
 * Cons:
 * 1. O(n) Auxilary Space is needed
 * 2. MergeSort is used only in external memory it is not used in main memory.
 * 
 * Pros:
 * 1. All the cases are equal and stable Performance  i.e O(nlogn). 
 *
 */

/**@DivideAndConquer_Find_MinAndMax_Algorithm
 * 
 * General Approach  
 * 
 * Time Complexity:-
 * =============== 
 * T(n) = (n-1)+1 if it is in increasing Order 
 * T(n) = (n-1)+(n-1) if it is decreasing Order
 * T(n) = (n-1)/2+(n-1)/2+(n-1)/2+1 if 50% if and 50% else
 * T(n) = 3/2(n-1)+1
 * T(n) = O(1.5n-n) 
 * 
 * Divide & Conquer Approach:- 
 * =========================
 *   T(n) = T(floor(n/2)) + T(ceil(n/2)) + 2
 *   T(2) = 1
 *   T(1) = 0
 *   If n is a power of 2, then we can write T(n) as:
 *   T(n) = 2T(n/2) + 2
 *	After solving above recursion, we get T(n)  = 3/2n -2
 *
 *		  
 */

public class SortAlgorithms {
	public static int pass=0;
	public static int nCount=0;
	public static int nPart=0;

	public static void main(String[] args){		
		int[] inputArray =  new int[]{11, 5, 3 ,6, 10 ,9, 1,18};//1,2,3,4,18,29,30,31};	//20, 10, 90 ,60, 30 ,80, 40
		//System.out.println("Bubble Sort:");
		//modifiedBubbleSort(Arrays.copyOf(inputArray, inputArray.length), 0, inputArray.length-1);
		//modifiedBubbleSort(inputArray, 0, inputArray.length-1);
		//System.out.println("");
		//System.out.println("Quick Sort:");
		//quickSort(inputArray ,0,inputArray.length-1);	
		//System.out.println("No. of Comparisions: "+nCount);
		//System.out.println("No. of Partitions: "+nPart);
		//insertionSort(inputArray);
		insertionSortRecursive(inputArray,1);
		nCount=0;

	//		mergeSort(inputArray ,0,inputArray.length-1); 
		//System.out.println(Arrays.toString(inputArray));
		//	boolean found=binarySearch(inputArray,0,inputArray.length-1,128);
		//	if(found)
		//		System.out.println("key found");
		//	else
		//		System.out.println("key not found");
		//System.out.println(nCount);
		System.out.println(Arrays.toString(inputArray));
	}
	public static void insertionSort(int[] aArray){	    
		//n=8
		//0-    n-1
		//0 1 2 3 4 5 6 7  1-n-1
		for(int j=1;j<aArray.length;j++){	//n-1
			int k=aArray[j];
			int i=j-1;
			while(i>=0 && aArray[i]>k){  //  n
				aArray[i+1] = aArray[i];
				i--;				
			}
			aArray[i+1]=k;
		}
	}
	
	public static void insertionSortRecursive(int[] aArray,int j){
		if(j<aArray.length){
			int k=aArray[j];
			int i=j-1;
			moveData(aArray, i, k);
			insertionSortRecursive(aArray, j+1);
		}
		
	}
	

	private static void moveData(int[] aArray,int i,int k){
		if(i>=0&&aArray[i]>k){
			aArray[i+1] = aArray[i];
			moveData(aArray, i-1, k);
		}
		else
			aArray[i+1]=k;

	}
	public static void quickSort(int[] aArray, int m, int n){
		int q=0;

		if(m<n){
			q=partition(aArray, 0, n);	//arrange pivot element in the proper place
			quickSort(aArray, m, q-1);  
			quickSort(aArray, q+1, n);
			nPart++;
		}


	}

	public static int[] modifiedBubbleSort(int[] bArray,int m,int n){

		for(int i=m;i<=n;i++){
			int swap=0;			
			for(int j=m;j<=n-i-1;j++){
				if(bArray[j]>bArray[j+1]){
					int temp=0;
					temp=bArray[j+1];
					bArray[j+1]=bArray[j];
					bArray[j]=temp;
					swap++;

					//	System.out.println("Pass "+i+1+": "+Arrays.toString(bArray));
				}
			}
			System.out.println("Pass "+(i+1)+": "+Arrays.toString(bArray));
			if(swap==0)
				return bArray;
		}
		return bArray;
	}

	public static int partition(int[] aArray,int m,int n){
		int key = aArray[n];
		int i = m-1;
		int j=m;
		for(;j<=n-1;j++){
			if(aArray[j]<=key){
				i=i+1;
				//swap elements	
				int temp=aArray[j];
				aArray[j]=aArray[i];
				aArray[i]=temp;
				nCount++;			
			}
		}
		int temp=aArray[i+1];
		aArray[i+1]=aArray[j];
		aArray[j]=temp;
		System.out.println("Pass "+ ++pass+": "+Arrays.toString(aArray));

		return i+1;
	}


	public static void mergeSort(int[] cArray,int l,int r){
		if(l<r)     
		{
			int	m=(l+r)/2;
			mergeSort(cArray, l, m);  //t(n/2)    tree heigh=logn data movement=n
			mergeSort(cArray, m+1, r); //T(n/2)
			merge(cArray, l,m, r); //o(n1+n2-1)=n-1=  nlogn
		}		
	}
	//list 1 length list 2 lengh
	public static void merge(int[] cArray,int l,int m,int r){		
		//create 2 temp arrays with sizes
		//copy old data 
		// merge 2 arrays by comparing		

		//find sizes of arrays
		int n1=m-l+1;
		int n2=r-m;
		int[] listOne = new int[n1];
		int[] listTwo = new int[n2];


		for(int i=0;i<n1;i++)//copy elements from array1
			listOne[i]=cArray[l+i];

		for(int j=0;j<n2;j++)//copy elements form array2
			listTwo[j]=cArray[m+j+1];
		//	System.out.println(Arrays.toString(listOne)+" "+Arrays.toString(listTwo));

		int i=0,j=0,k=l;
		for(;i<n1&&j<n2;){//check which arrays is smaller 
			if(listOne[i]<=listTwo[j]){
				cArray[k]=listOne[i];					
				i++;
			}else{					
				cArray[k]=listTwo[j];				
				j++;
			}
			k++;
		}		

		while(i<n1){			//copy remainint elements	
			cArray[k]=listOne[i];
			i++;
			k++;
		}
		while(j<n2){				
			cArray[k]=listTwo[j];
			j++;
			k++;
		}
		//System.out.println(Arrays.toString(cArray));



	}

}



