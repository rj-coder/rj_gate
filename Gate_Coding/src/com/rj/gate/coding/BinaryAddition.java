package com.rj.gate.coding;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

import org.omg.CORBA.INTERNAL;

public class BinaryAddition{

	public static void main(String[] args) {
		System.out.print("Enter 2 No.s:\n");
		Scanner sc= new Scanner(System.in);
		int i=998;
		int j=999999;
		int k=1;
		int sum=0;
		int carry=0;
		int p=i,q=j;
		boolean bitsLeft=true;
		//	System.out.println(i|j);
		
	//	System.out.println(add(13,42));
		//shift-Add Binary Algorithm
		int n=Integer.SIZE;
		//System.out.println(Integer.SIZE);
		int r=0;
		while(n!=0){
			if((j&k)!=0){
				r=r+i;	
			}
			j=j>>1;
			i=i<<1;
			n=n-1;			
		}
		System.out.println(r);
		
//		Addition
//========================
	/*	while(j!=0)
		{				
			
			carry = i&j;
			i=i^j;
			j=carry<<1;
			System.out.println(j);
	}

		//System.out.println(i);*/
		
	}
	
	public static int add(int x,int y){
		if(y==0)
			return x;
		else{
			return add(x^y,(x&y)<<1);
		}		
	}
	
}
