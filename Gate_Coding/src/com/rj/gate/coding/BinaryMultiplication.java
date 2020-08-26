package com.rj.gate.coding;

public class BinaryMultiplication {

	public static void main(String[] args) {
		System.out.print("Enter 2 No.s:\n");
		int i=998;
		int j=999999;
		int k=1;
		/**
		 * Shift-Add Binary Multiplication
		 */
		int n=Integer.SIZE;		
		int r=0;
		while(j!=0){	
			if((j&1)!=0){
				r=r+i;	
			}
			j=j>>1;
			i=i<<1;
			//n=n-1;			
		}
		System.out.println(r);	
		
	}
	
	
	
}
