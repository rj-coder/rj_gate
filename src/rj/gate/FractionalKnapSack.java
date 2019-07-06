package rj.gate;

import java.util.Arrays;
import static  rj.gate.JobSequencing.swap;;

public class FractionalKnapSack {
	static int knapsack_size = 50;
	static int profit[] = {60, 40, 100, 120};
	static int weight[] = {10, 40, 20, 30};
	static double unitWeight[] = new double[profit.length];
	static double total_profit = 0;
	public static void main(String args[]){

		for(int i=0;i<profit.length;i++)
			unitWeight[i] = profit[i]/(weight[i]*1.0);

		//Sort in decreasing order of their unit Weights
		sortUnitWeights();


		int i=0;
		while(i<weight.length){
			if(knapsack_size-weight[i]>=0){
				knapsack_size-=weight[i];
				total_profit +=profit[i];
				i++;
			}else{						
				total_profit+=profit[i]*(1.0*knapsack_size)/(weight[i]);
				break;
			}		
		}

		System.out.println("Profit: "+total_profit);
	}

	static void sortUnitWeights(){
		//sort jobs in decreasing order of profit
		for(int i=0;i<unitWeight.length;i++){
			for(int j=0;j<unitWeight.length-i-1;j++){
				if( unitWeight[j]<unitWeight[j+1]){					
					swap2(unitWeight,i,j);
					swap(profit,i,j);
					swap(weight,i,j);
				}
			}
		}
	}
	static void swap2(double[] arr,int i,int j){
		double temp=arr[j];					
		arr[j]=arr[j+1];
		arr[j+1]=temp;
	}
}
