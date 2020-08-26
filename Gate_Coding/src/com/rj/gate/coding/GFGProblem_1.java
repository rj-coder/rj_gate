/**
 * 
 * GeeksforGeeks developed its new system to make sure no two usernames are same. So, they selected you as a developer to develop the system. They have set some rules to do the same.
Rules are pretty simple: If you see the same username that already exists, just add a number at the end of that username (number starting from 1), else you will toast "Verified".

Input:
First line of the input contains an integer T denoting the number of test cases. Then T test cases follow. First line of every test case consists of an integer N, denoting number of usernames. Second line of every test case consists of N spaced separated Strings, denoting usernames(only lowercase letters).

Output:
Corresponding to each test case, print the required output in a new line.

Constraints:
1<=T<=100
1<=N<=10^5
1<=|String|<=10^3

Example:
Input:
2
4
abc aab abc aba
5
abc abc aab aab abc
Output:
Verified Verified abc1 Verified
Verified abc1 Verified aab1 abc2
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
public class GFGProblem_1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		short noOfTestCases = sc.nextShort();
		long noOfStrings;
		while(--noOfTestCases>=0){
			noOfStrings = sc.nextLong();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String testStrings = " ";
			try {
				testStrings= br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			long temp=noOfStrings;
			ArrayList<String> items=new ArrayList<String>();
			for (String string : testStrings.replaceAll("( )+", " ").split(" ")) {
				if(--temp>=0){
					items.add(string);
				}else
					break;					
			}
			//Collections.add(items,testStrings.split(" "));
		//	System.out.println(Arrays.deepToString(items.toArray()));
			ArrayList<String> hashTable = new ArrayList<String>();
			int userCounter = 1;

			for (String string : items) {
				if(hashTable.contains(string)){
					System.out.print(string+userCounter+" ");
					userCounter++;
				}else{
					System.out.print(string+" ");
				}
				hashTable.add(string);
			}				
			System.out.println();
		}
		sc.close();
	}		

}



