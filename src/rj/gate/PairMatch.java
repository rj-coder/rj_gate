package rj.gate;

import java.util.ArrayList;
import java.util.Arrays;





public class PairMatch {
	static int x,y;
	static ArrayList<Integer> heapdata;
	public static void main(String[] args) {
		
		int aData[]=new int[]{1,1,8,3,3,4,5,6};//	O(nlogn);5,13,8,3,7,4      //3,0,1,4 fail.
		
		int numberMatch = 8;
		    
		System.out.println(findPairMatchEqualtoN(aData,numberMatch));
	
	}

	private static boolean findPairMatchEqualtoN(int[] aData, int numberMatch) {
		int MAX= 10000;
		int hash[] = new int[MAX];	//creating hash array with max element size
		
		for(int i=0;i<aData.length;i++)	////O(n) for storing complements
		{
			int pos= numberMatch-aData[i];
			if(pos>=0)
				hash[pos]=aData[i];//			
		}
		
		System.out.println(Arrays.toString(hash));
		for(int i=0;i<aData.length;i++){
			if(numberMatch-aData[i]>0 && (aData[i]==hash[numberMatch-aData[i]]) ){
				return true;
			}				
		}
		return false;							
	}
}

/**
 * Time Complexity = n-1
 *                 = O(n)
 * 
 */
