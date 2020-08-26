/**
 * 
 * [Last two digits of Fibonacci]
Show Topic Tags      
Saksham has recently learnt about Fibonacci series, and told his father about it. His father being a mathematician asked him to tell the Nth number of the Fibonacci series.
But, Saksham told his father that it is difficult to solve the series as he is getting very large numbers. His father being lenient made his work less and asked to tell only last two digits of the Nth number of Fibonacci series. Please help Saksham to find the answer.


Note: 1st element of series is 1. And 2nd element of series is 1.
If last 2 digits are 03(for instance) print 3.

Input:
First line of the input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of a single line containing an integer N.

Output:
Corresponding to each test case, print the required output in a new line.

Constraints:
1<=T<=100
1<=N<=10^9

Example:
Input:
8
1
2
3
4
5
6
7
8
Output:
1
1
2
3
5
8
13
21
 */

package com.rj.gate.coding;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * @author rkalyada
 *
 */
public class GFGProblem_2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		short noOfTestCases = sc.nextShort();
		int data[]=new int[noOfTestCases];
		for(int i=0;i<noOfTestCases;i++){
			data[i]=findLastTwoDigitsOfFibonnaci(sc.nextLong())	;		
		}
		for(int i:data){
			System.out.println(i);
		}
		sc.close();
		}
		
		public static int findLastTwoDigitsOfFibonnaci(long number){
			double temp= Math.pow((1+Math.sqrt(5)),(double)number)-Math.pow((1-Math.sqrt(5)),(double)number);
					temp=temp/(Math.pow(2, (double)number)*Math.sqrt(5));
			return (int) (temp%100);			
		}
	}		





