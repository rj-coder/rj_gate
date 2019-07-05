package rj.gate;

import java.util.Arrays;
import java.util.PriorityQueue;

public class OptimalMergePattern {

	
	public static void main(String[] args) {
		int arr[]={4,2,1,5,10,15,20,10,3,5};
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i:arr)			
			pq.add(i);
		System.out.println(Arrays.toString(pq.toArray()));
		int count=0;
		while(pq.size()>1){			
			int temp = pq.poll()+pq.poll();
			pq.add(temp);
			count+=temp;
		}
		System.out.println("Optimal Merge Pattern : "+count);	
	}

}
