package rj.gate;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class MatrixChainMultiplication_DP {

	static int min = 9999;
	static int min2 = 9999;
	static int k=0;	
	static  int[] p = {1,2,1,4,1};
	static String s ="";
	public static void main(String[] args){	
		//System.out.println(matrix(0,3,0));
		System.out.println(matrixChainOrder(1,p.length-1));
		System.out.println(s);
	}

	static int matrixChainOrder(int i,int j){
		if(i==j)
			return 0;
		int k;
		int min= Integer.MAX_VALUE;
		int q;
		for(k=i;k<j;k++){
			q = matrixChainOrder(i, k)+
					matrixChainOrder(k+1, j)+
					p[i-1]*p[k]*p[j];
			if(q<min){
				min =q;
				s=""+k;
			}
								
		}		
		return min;
	}

}
