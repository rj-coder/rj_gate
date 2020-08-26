package rj.gate;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.IconUIResource;

import com.ibm.as400.access.CoreMRI;

public class ICPC2K17_Problem_A {
	static double lengthValue = 0;
	public static void main(String[] args){
		int noOfVertices = 0;
		Scanner sc = new Scanner(System.in);
		noOfVertices = sc.nextInt();
		
		int[][] coordinates= new int[noOfVertices][2];
		for(int i=0;i<noOfVertices;i++){
			coordinates[i][0] = sc.nextInt();
			coordinates[i][1] = sc.nextInt();
		}
		for(int i=0;i<coordinates.length;i++){
			for(int j=0;j<coordinates[i].length;j++){
				System.out.print(coordinates[i][j]+ " ");			
			}
			System.out.println();
		}
		if(noOfVertices>=3 & noOfVertices <=200){
			System.out.println(computeLine(coordinates));
		}
		
		
	}
	
	static double computeLine(int[][] points){
		for(int i=0;i<points.length;i++){
			for(int j=i+1;j<points.length;j++){
				  int temp = doSquare(points[i][0]-points[j][0])+doSquare(points[i][1]-points[j][1]);
				  if(temp>lengthValue)
					  lengthValue = temp;
			}			
		}
		return Math.sqrt(lengthValue);		
	}

	private static int doSquare(int i) {
		// TODO Auto-generated method stub
		return i*i;
	}

	
	
	
}
