package rj.gate;
/*ALGORITHM:
 * Sort all the jobs based on the profit in an descreasing order.
	Let α be the maximum deadline that will define the size of array.
	Create a solution array S with d slots.
	Initialize the content of array S with zero.
	Check for all jobs.
	If scheduling is possible a lot ith slot of array s to job i.
	Otherwise look for location (i-1), (i-2)...1.
	Schedule the job if possible else reject.
	Return array S as the answer.
	End.
 * 
 */

public class JobSequencing {
	static int profits[]={85,25,16,40,55,19,92,80,15};
	static int dead_lines[]={4,3,2,2,3,4,1,2,6};
	static int jobs[]={0,1,2,3,4,5,6,7,8};
	static int total_profit = 0;
	static String text = "JOBS: ";
	static boolean slots[];
	public static void main(String[] args) {
		//Sort jobs in decreasing order of profits
		sortJobs();		
		slots = new boolean[findMaxDed()];
		System.out.println(slots.length);
		for(int i=0,j=0; i < jobs.length && j < slots.length;i++){
			int  index = dead_lines[i];
			if(isEmpty(index)){
				slots[index]=true;
				j++;
				text+="j"+(jobs[i])+" ";
				total_profit+=profits[i];
			}else{
				if(isBelowAvailble(index)){
					index = getBelowIndex(index);
					slots[index]=true;
					j++;
					text+= "j"+(jobs[i])+" ";
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
