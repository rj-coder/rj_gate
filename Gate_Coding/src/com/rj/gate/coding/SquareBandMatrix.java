package com.rj.gate.coding;


public class SquareBandMatrix {

	

	public static void main(String[] args) {
		int value=1;
		int arraySize=6;
		int bandSize=5;
		int i1=4,j1=2;
		int lowerBoundary =0;
		int[][] arr = new int[arraySize][arraySize];
		int sizeoFMatrix= bandSize*arraySize-bandSize*(bandSize-1)/2 ;           // N+N-1+N-2+N-3 
		int[] oneMatrix=new int[sizeoFMatrix];
		System.out.println("Row Major Order of Symmetric Square Band Matrix:");
		for(int i=0,k=0;i<arraySize;i++)
			for(int j=0;j<arraySize;j++)
				if(((i-j)>=0)&&((i-j)<(bandSize))){
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
	
		System.out.println("\nValue of A("+i1+", "+j1+") is: "+arr[i1][j1]+"\nIndex in One Dimensional is: "+squareBandMatrixWalk(oneMatrix,i1,j1,lowerBoundary,bandSize));
		
		System.out.println();
		System.out.println("Column Major Order of Symmetric Square Band Matrix:");
		value=1;
		for(int i=0,k=0;i<arraySize;i++)
			for(int j=i;j<arraySize;j++)
				if(j<bandSize+i&&j<arraySize){
					arr[j][i]=value;
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
		i1=2;
		j1=4;
		System.out.println("\nValue of A("+i1+", "+j1+") is: "+arr[j1][i1]+"\nIndex in One Dimensional is: "+squareBandMatrixWalk(oneMatrix,j1,i1,lowerBoundary,bandSize));
		
	}
	
	public static int squareBandMatrixWalk(int[] n,int i,int j,int lb,int bandSize){
		
		if((i-j)<bandSize && (i-j)>=0)	
		
			return 0+(i*(i+1))/2-1+j-(i-lb); //
			
		else
			return 0;
		
		
	}
	
	public static int mod(int n){
		return n<0?-n:n;
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

