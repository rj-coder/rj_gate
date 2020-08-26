package rj.gate;

import java.util.Arrays;

public class MinMaxDivideAndConquer {

	private static int[] minMax = new int[2];
	public MinMaxDivideAndConquer() {
	}

	public static void main(String[] args) {
		int[] inputArray=new int[]{13,29,11,16,19};
		System.out.println(Arrays.toString(findMinMax(inputArray,0,inputArray.length-1)));
	}

	public  static int[] findMinMax(int[] aArray, int i, int j) {
		int mid,min,max;
		minMax=new int[2];		
		if(i==j)	
			min=max=aArray[i];
		else if(i==j-1){
			if(aArray[i]>aArray[j]){
				min=aArray[j];
				max=aArray[i];
			}else{
				min=aArray[i];
				max=aArray[j];
			}
				
		}
		else{
			mid=(i+j)/2;			
		int[]	minMax1= findMinMax(aArray, i, mid);			
		int[]	minMax2= findMinMax(aArray, mid+1,j);
			//System.out.println(min1+" "+min);
			if(minMax1[0]<minMax2[0])
				max=minMax2[0];
			else
				max=minMax1[0];
			if(minMax1[1]<minMax2[1])
				min=minMax1[1];
			else
				min=minMax2[1];
			
		}		
		minMax[0]=max;
		minMax[1]=min;
		return minMax;
	}

}
