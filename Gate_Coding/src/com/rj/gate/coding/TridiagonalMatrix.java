package com.rj.gate.coding;


public class TridiagonalMatrix {

	

	public static void main(String[] args) {
		int value=1;
		int arraySize=6;
		int[][] arr = new int[arraySize][arraySize];
		int sizeoFMatrix= 3*arraySize-2 ;//(N+N-1+N-2)=3N-2 
		int[] oneMatrix=new int[sizeoFMatrix];
		System.out.println("Row Major Order of Tri-Diagonal Matrix:");
		for(int i=0,k=0;i<arraySize;i++)
			for(int j=0;j<arraySize;j++)
				if((i-j)<=1 && (i-j) >=-1){
					arr[i][j]=value;
					oneMatrix[k]=value;
							k++;
							value++;
				}
						 
		
		for(int i=0;i<arraySize;i++){
			for(int j=0;j<arraySize;j++)
			{
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();			
		}
		System.out.println();
		System.out.println("Size of Matrix in One Dimensional: "+oneMatrix.length);
		System.out.println();

		for(int j=0;j<oneMatrix.length;j++){
			System.out.print(j+"\t");
		}
		System.out.println();
		for(int j=0;j<oneMatrix.length;j++){
			System.out.print(oneMatrix[j]+"\t");
		}
		System.out.println();
		int i=6,j=6;
		int lowerBoundary =0;
		System.out.println("\nValue of A("+i+", "+j+") is: "+arr[i-1][j-1]+"\nIndex in One Dimensional is: "+triDiagonalWalk(oneMatrix,i,j,lowerBoundary));
	}
	
	public static int triDiagonalWalk(int[] n,int i,int j,int lb){
		switch(i-j)
		{
		case 0:
		case 1:
		case -1:
			return 0+3*(i-1)-1+j-(i-1); //
			
		default:
			return 0;
		}
		
	}
	 
}
/*
 *  N+N-1+N-2+N-3........N-(A-1)
 *  N(A-1)-(1+2+3+4+5......+(A-1)
 *  N(A-1)-A(A-1)/2
 *  //n+x Symetric Square Band Matrix  
 *  
 *  
 *  
 *  
 *  
 *  
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

