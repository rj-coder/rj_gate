package rj.gate;
public class SpiralPrint {
	public static void main(String[] args) {
		int value=1;
		int arraySize=6;
		int[][] arr = new int[arraySize][arraySize];

		for(int i=0;i<arraySize;i++)
			for(int j=0;j<arraySize;j++)
				arr[i][j]=value++;	
		
		for(int i=0;i<arraySize;i++){
			for(int j=0;j<arraySize;j++){
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();		
		spiralWalk(arr);
	}

	public static void spiralWalk(int[][] arr){
		int noOfSteps = (arr.length+1)/2;
		for(int step =0;step<noOfSteps;step++){

			for(int i=step;i<arr.length-step;i++){
				System.out.print(arr[step][i]+"\t");
			}			
			System.out.println();
			for(int i=0;i<arr.length-2*(step+1);i++){
				System.out.print(arr[i+step+1][arr.length-step-1]+"\t");
			}
			System.out.println();
			for(int i=arr.length-step;i>step;i--){
				if(step!=arr.length/2)
					System.out.print(arr[arr.length-step-1][i-1]+"\t");
			}
			System.out.println();
			for(int i=0;i<arr.length-2*(step+1);i++){
				System.out.print(arr[arr.length-step-i-2][step]+"\t");
				
			}
			System.out.println();
			
		}
	}


}
