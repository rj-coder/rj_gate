package rj.gate;
/*
 * 
 */

public class JobSequencing {
	static int profits[]={25,100,27,15};
	static int dead_lines[]={1,0,1,0};
	static int jobs[]={0,1,2,3};
	static int total_profit = 0;
	static String text = "JOBS: ";
	static boolean slots[];
	public static void main(String[] args) {
		//Sort jobs in decreasing order of profits
		sortJobs();		
		slots = new boolean[findMaxDed()];

		for(int i=0,j=0; i < jobs.length ||j < slots.length;i++){
			int  index = dead_lines[i];
			if(isEmpty(index)){
				slots[index]=true;
				j++;
				text=text+"j"+(jobs[i])+" ";
				total_profit+=profits[i];
			}else{
				if(isBelowAvailble(index)){
					index = getBelowIndex(index);
					slots[index]=true;
					j++;
					text+= (jobs[i])+" ";
					total_profit+=profits[i];
				}
			}
		}
		System.out.println(text);
		System.out.println("PROFIT: "+total_profit);
	}

	private static int findMaxDed() {
		int max=dead_lines[0];
		for(int i=1;i<dead_lines.length;i++){
			if(max<dead_lines[i])
				max=dead_lines[i];
		}	
		return  max+1;
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
		for(int i=0;i<profits.length;i++){
			for(int j=0;j<profits.length-i-1;j++){
				if(profits[j]<profits[j+1]){					
					swap(profits,i,j);
					swap(dead_lines,i,j);
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
