package rj.gate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.SortedSet;

public class BinarySearch {	
	static int count=0;
	public static void main(String[] args) {
		int arr[] = {22,94,15,99,100,34,53};
		Arrays.sort(arr);		
		int x=543;
		if(binarySearch(arr,0,arr.length-1,x)==true)
			System.out.println("Found: ");
		else
			System.out.println("Not found: ");

	}

	static boolean binarySearch(int a[],int low,int high,int x){
		if(low<=high){
			int	middle = (low+high)/2;
			if(x>a[middle]){			
				count++;
				return binarySearch(a,middle+1,high, x);}
			else if(x<a[middle]){
				count++;
				return binarySearch(a,low,middle-1,x);}
			else{count++;
				return true;}
		}
		else 
			return false;
	}

}
