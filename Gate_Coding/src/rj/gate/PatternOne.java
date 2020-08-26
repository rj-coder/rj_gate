package rj.gate;

public class PatternOne {


	public static void main(String[] args) {
		int noOfLevels=5;//Level Number in Series

		//Top Fillup
		for(int i=noOfLevels;i>1;i--){
			for(int j=noOfLevels;j>=i;j--){
				System.out.print(i-1+" "+(i-1)+" ");
			}
			System.out.println();
		}

		//Bottom Fillup
		for(int i=1,k=0;i<=noOfLevels*2;i++){ 
			for(int j=noOfLevels*2;j>=i;j--)
				if(i%2==0)				   
					System.out.print(k+" ");				  	
			if(i%2==0){
				System.out.println();
				k++;
			}
		}
	}

}
