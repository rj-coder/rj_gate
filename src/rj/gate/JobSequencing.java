package rj.gate;

import java.util.Arrays;

public class JobSequencing {
	static int arr[]={25,100,27,15};
	static int ded[]={1,0,1,0};
	static int jobs[]={0,1,2,3};
	static int profit = 0;
	static boolean slots[];
	public static void main(String[] args) {

		sortJobs();

		int max=ded[0];

		for(int i=1;i<ded.length;i++){
			if(max<ded[i])
				max=ded[i];
		}
		//System.out.println();
		slots = new boolean[max+1];
	//	System.out.println("max: "+max);
	//	System.out.println(Arrays.toString(slots));
		String text = "JOBS: {";

		for(int i=0,j=0; i < jobs.length ||j < slots.length;i++){
			int  index = ded[i];
		//	System.out.println("index: "+index);
		
			if(isEmpty(index)){
				slots[index]=true;
				j++;
				text=text+"j"+(jobs[i]+1)+",";
				//System.out.println("jobs: "+(jobs[i]+1));					
				profit+=arr[i];
			}else{
				if(isBelowAvailble(index)){
					index = getBelowIndex(index);
					slots[index]=true;
					j++;
					text+= (jobs[i]+1);
					//System.out.println("jobs: "+(jobs[i]+1));					
					profit+=arr[i];
					}

			}

		}
		text=text+"}";
		System.out.println(text);
		System.out.println("PROFIT: "+profit);
	}

	private static int getBelowIndex(int index) {
		for(int i=0;i<index;i++)
			if(slots[i]==false)
				return i;
		return 0;
	}

	private static boolean isBelowAvailble(int index) {
		for(int  i=0;i<index;i++){
			if(slots[i]==false)
				return true;
		}
		return false;
	}

	static void sortJobs(){
		//sort jobs in decreasing order of profit
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j]<arr[j+1]){					
					swap(arr,i,j);
					swap(ded,i,j);
					swap(jobs,i,j);
				}
			}
		}
	}

	static boolean isEmpty(int index){
		if(slots[index]==false)
			return true;
		else
			return false;
	}

	static void swap(int[] arr,int i,int j){
		int temp=arr[j];					
		arr[j]=arr[j+1];
		arr[j+1]=temp;
	}


}
